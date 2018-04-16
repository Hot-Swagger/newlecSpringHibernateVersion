package com.notepubs.web.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableTransactionManagement
@ComponentScans(value= {
		@ComponentScan("com.notepubs.web.dao"),
		@ComponentScan("com.notepubs.web.service")
})
public class HibernateConfig {
	
	@Bean(destroyMethod="close")
	public ComboPooledDataSource dataSource() throws PropertyVetoException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		dataSource.setJdbcUrl("jdbc:mysql://vaio.notepubs.com/notepubsdb?serverTimezone=UTC&amp;autoReconnect=true&amp;useSSL=false&amp;useUnicode=true&amp;characterEncoding=utf8");
		dataSource.setUser("notepubs");
		dataSource.setPassword("cclass");
		
		dataSource.setMinPoolSize(5);
		dataSource.setMaxPoolSize(20);
		dataSource.setMaxIdleTime(3000);
		
		return dataSource;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() throws PropertyVetoException {
		
		Properties pros = new Properties();
		pros.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		pros.put("hibernate.show_sql", "true");
		
		LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
		factory.setDataSource(dataSource());
		factory.setPackagesToScan("com.notepubs.web.entity");
		factory.setHibernateProperties(pros);
		
		return factory;
	}
	
	@Bean
	public HibernateTransactionManager transactionManager() throws PropertyVetoException {
		HibernateTransactionManager transaction = new HibernateTransactionManager();
		transaction.setSessionFactory(sessionFactory().getObject());
		return transaction;
		
	}
}
