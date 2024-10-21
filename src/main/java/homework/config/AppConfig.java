package homework.config;

import homework.config.basic.DatabaseConfig;
import homework.config.basic.LiquibaseConfig;
import homework.config.basic.MapperConfig;
import homework.config.security.SecurityConfig;
import homework.config.security.UsernamePasswordAuthenticationFilter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@Import({
        DatabaseConfig.class,
        LiquibaseConfig.class,
        MapperConfig.class,
        UsernamePasswordAuthenticationFilter.class,
        SecurityConfig.class
})
@EnableWebMvc
@ComponentScan("homework")
public class AppConfig {
}
