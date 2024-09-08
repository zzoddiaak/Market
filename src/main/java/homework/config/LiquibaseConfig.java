package homework.config;

import liquibase.integration.spring.SpringLiquibase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class LiquibaseConfig {

    @Value("${spring.liquibase.change-log}")
    private String changeLog;

    private final DataSource dataSource;


    @Bean
    public SpringLiquibase liquibase() {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog(changeLog);
        liquibase.setDataSource(dataSource);
        return liquibase;
    }
}
