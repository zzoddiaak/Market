package homework.config.basic;

import liquibase.integration.spring.SpringLiquibase;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@Configuration
@RequiredArgsConstructor
public class LiquibaseConfig {
    private final DataSource dataSource;
    @Bean
    @SneakyThrows
    public SpringLiquibase liquibase(){
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog("classpath:changelog-master.xml");
        liquibase.setDataSource(dataSource);
        return liquibase;
    }

}