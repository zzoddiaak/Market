package homework.config.security;

import homework.security.JwtAuthFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity(debug = true)
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final AuthenticationProvider authenticationProvider;
    private final JwtAuthFilter jwtAuthFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        // Открытый доступ к ресурсам
        http.authorizeHttpRequests(request -> request
                .requestMatchers(new AntPathRequestMatcher("/api/v1/resource-controller/**")).permitAll()  // Доступ ко всем
        );

        // Доступ для пользователей с ролью CLIENT
        http.authorizeHttpRequests(request -> request
                .requestMatchers(new AntPathRequestMatcher("/api/v1/users/**")).hasAuthority("ROLE_CLIENT")  // Доступ для CLIENT
        );

        // Доступ для администраторов
        http.authorizeHttpRequests(request -> request
                .requestMatchers(new AntPathRequestMatcher("/api/v1/admin/**")).hasAuthority("ROLE_ADMIN")  // Доступ для ADMIN
        );

        // Доступ для администратора и клиента к определенным ресурсам
        http.authorizeHttpRequests(request -> request
                .requestMatchers(new AntPathRequestMatcher("/api/v1/orders/**"))
                .hasAnyAuthority("ROLE_CLIENT", "ROLE_ADMIN")  // Доступ для CLIENT и ADMIN
        );

        // Доступ к другим запросам только аутентифицированным пользователям
        http.authorizeHttpRequests(request -> request.anyRequest().authenticated());

        // Настройка политики сессий, отключение CSRF, добавление JWT фильтра
        http.csrf(AbstractHttpConfigurer::disable);
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        // Настройка провайдера аутентификации и добавление фильтра
        http.authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
