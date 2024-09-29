package homework.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@Import({
        DatabaseConfig.class,
        LiquibaseConfig.class,
        MapperConfig.class
})
@EnableWebMvc
@ComponentScan("homework")
public class AppConfig {
}
