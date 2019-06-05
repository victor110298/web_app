package webapp.config;

import lombok.Value;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import java.util.Properties;

@Configuration
@ComponentScan("webapp")
@EnableJpaRepositories("webapp.repository")
@PropertySource("classpath:application.properties")
public class ApplicationConfig {
    @Value("${url}")
    private String url;

    @Value("${user}")
    private String user;

    @Value("${driver}")
    private String driver;

    @Value("${password}")
    private String password;

    @Value("${hibernate.dialect}")
    private String dialect;

    @Value("${ddl-auto}")
    private String ddlAuto;

    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource(url, user, password);
        dataSource.setDriverClassName(driver);
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder) {
        LocalContainerEntityManagerFactoryBean emFactory = builder
                .dataSource(dataSource())
                .persistenceUnit("mateacademy1")
                .packages("com.mateacademy.springmvc.entity")
                .jta(true)
                .build();
        emFactory.setJpaProperties(setJpaProperties());
        return emFactory;
    }

    public Properties setJpaProperties() {
        Properties jpaProperties = new Properties();
        jpaProperties.setProperty("hibernate.dialect", dialect);
        jpaProperties.setProperty("hibernate.hbm2ddl.auto", ddlAuto);
        return jpaProperties;
    }
}