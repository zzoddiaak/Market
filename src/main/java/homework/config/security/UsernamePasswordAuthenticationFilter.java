package homework.config.security;

import homework.entity.UserCredential;
import homework.exeption.UserNotFoundLogin;
import homework.repository.api.UserCredentialRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

@AllArgsConstructor
@Configuration
public class UsernamePasswordAuthenticationFilter {
    private final UserCredentialRepository userCredentialRepository;

    @Bean
    public UserDetailsService findUserLogin(){
        return login -> {
            UserCredential userCredential = Optional.ofNullable(userCredentialRepository.findLogin(login))
                    .orElseThrow(() -> new UserNotFoundLogin(login));

            return new UserDetailsConfig(userCredential);
        };
    }
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(findUserLogin());
        authProvider.setPasswordEncoder(bCryptPasswordEncoder());
        return authProvider;
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
