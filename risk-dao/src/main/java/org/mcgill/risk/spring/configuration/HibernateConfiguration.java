package org.mcgill.risk.spring.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * <p>
 * Hibernate configuration class
 * </p>
 * 
 * //
 * @author akamami
 * 
 * @since January 29, 2015
 * @version 1.0
 *
 */
@Configuration
@EnableTransactionManagement
@ComponentScan({ "org.mcgill.risk.spring.configuration" })
@PropertySource(value = { "classpath:application.properties" })
public class HibernateConfiguration {

	@Autowired
	private Environment environment;

	private final String db = "ora.";

	/**
	 * 
	 * @return
	 */
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(new String[] { "org.mcgill.risk.spring.model" });
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}

	/**
	 * Create the application data source
	 * @return
	 */
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getRequiredProperty(db + "jdbc.driverClassName"));
		dataSource.setUrl(environment.getRequiredProperty(db + "jdbc.url"));
		dataSource.setUsername(environment.getRequiredProperty(db + "jdbc.username"));
		dataSource.setPassword(environment.getRequiredProperty(db + "jdbc.password"));
		return dataSource;
	}

	/**
	 * @return Properties
	 */
	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", environment.getRequiredProperty(db + "hibernate.dialect"));
		properties.put("hibernate.show_sql", environment.getRequiredProperty(db + "hibernate.show_sql"));
		properties.put("hibernate.format_sql", environment.getRequiredProperty(db + "hibernate.format_sql"));
		return properties;
	}

	/**
	 * @param SessionFactory
	 * @return HibernateTransactionManager
	 */
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory s) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(s);
		return txManager;
	}
}
