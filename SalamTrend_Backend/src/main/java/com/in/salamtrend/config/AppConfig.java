/*
 * 
 */
package com.in.salamtrend.config;
import java.beans.PropertyVetoException;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
@ComponentScans(value = {@ComponentScan("com.in.salamtrend.dao"),
	      @ComponentScan("com.in.salamtrend.service")})
public class AppConfig {
	 @Value("${db.driver}")
	    private String DB_DRIVER;

	    @Value("${db.password}")
	    private String DB_PASSWORD;

	    @Value("${db.url}")
	    private String DB_URL;

	    @Value("${db.username}")
	    private String DB_USERNAME;

	    @Value("${hibernate.dialect}")
	    private String HIBERNATE_DIALECT;

	    @Value("${hibernate.show_sql}")
	    private String HIBERNATE_SHOW_SQL;

	    @Value("${hibernate.hbm2ddl.auto}")
	    private String HIBERNATE_HBM2DDL_AUTO;

	    @Value("${entitymanager.packagesToScan}")
	    private String ENTITYMANAGER_PACKAGES_TO_SCAN;

	    @Value("${hibernate.c3p0.max_size}")
	    private String CONN_POOL_MAX_SIZE;

	    @Value("${hibernate.c3p0.min_size}")
	    private String CONN_POOL_MIN_SIZE;

	    @Value("${hibernate.c3p0.idle_test_period}")
	    private String CONN_POOL_IDLE_PERIOD;

	    /*
	    // this is the standard datasource used by spring : import org.springframework.jdbc.datasource.DriverManagerDataSource;
	    @Bean
	    public DataSource dataSource() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName(DB_DRIVER);
	        dataSource.setUrl(DB_URL);
	        dataSource.setUsername(DB_USERNAME);
	        dataSource.setPassword(DB_PASSWORD);
	        return dataSource;
	    }
	    */

	    @Bean
	    public ComboPooledDataSource dataSource() {
	        // a named datasource is best practice for later jmx monitoring
	        ComboPooledDataSource dataSource = new ComboPooledDataSource("jupiter");

	        try {
	            dataSource.setDriverClass(DB_DRIVER);
	        } catch (PropertyVetoException pve){
	            System.out.println("Cannot load datasource driver (" + DB_DRIVER +") : " + pve.getMessage());
	            return null;
	        }
	        dataSource.setJdbcUrl(DB_URL);
	        dataSource.setUser(DB_USERNAME);
	        dataSource.setPassword(DB_PASSWORD);
	        dataSource.setMinPoolSize(Integer.parseInt(CONN_POOL_MIN_SIZE));
	        dataSource.setMaxPoolSize(Integer.parseInt(CONN_POOL_MAX_SIZE));
	        dataSource.setMaxIdleTime(Integer.parseInt(CONN_POOL_IDLE_PERIOD));

	        return dataSource;
	    }

	    @Bean
	    public LocalSessionFactoryBean sessionFactory() {
	        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
	        sessionFactoryBean.setDataSource(dataSource());
	        sessionFactoryBean.setPackagesToScan(ENTITYMANAGER_PACKAGES_TO_SCAN);
	        Properties hibernateProperties = new Properties();
	        hibernateProperties.put("hibernate.dialect", HIBERNATE_DIALECT);
	        hibernateProperties.put("hibernate.show_sql", HIBERNATE_SHOW_SQL);
	        hibernateProperties.put("hibernate.hbm2ddl.auto", HIBERNATE_HBM2DDL_AUTO);
	        sessionFactoryBean.setHibernateProperties(hibernateProperties);

	        return sessionFactoryBean;
	    }

	    @Bean
	    public HibernateTransactionManager transactionManager() {
	        HibernateTransactionManager transactionManager =
	                new HibernateTransactionManager();
	        transactionManager.setSessionFactory(sessionFactory().getObject());
	        return transactionManager;
	    }
/*
 * @Bean public Docket api() { return new Docket(DocumentationType.SWAGGER_2)
 * .select() .apis(RequestHandlerSelectors.any()) .paths(PathSelectors.any())
 * .build(); } }
 */
}
