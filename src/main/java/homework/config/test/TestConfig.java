package homework.config.test;

import homework.config.HibernateConfigConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import org.h2.jdbcx.JdbcDataSource;
import jakarta.persistence.EntityManagerFactory;

import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "homework.repository")
@PropertySource("classpath:application-test.properties")
public class TestConfig {

    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource() {
        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setURL(env.getProperty("jdbc.url"));
        dataSource.setUser(env.getProperty("jdbc.username"));
        dataSource.setPassword(env.getProperty("jdbc.password"));
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource);
        emf.setPackagesToScan("homework.entity");

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        emf.setJpaVendorAdapter(vendorAdapter);

        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", HibernateConfigConstants.HIBERNATE_DIALECT);
        properties.setProperty("hibernate.hbm2ddl.auto", HibernateConfigConstants.HBM2DDL_AUTO);
        properties.setProperty("hibernate.show_sql", HibernateConfigConstants.SHOW_SQL);
        emf.setJpaProperties(properties);

        return emf;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }
}
