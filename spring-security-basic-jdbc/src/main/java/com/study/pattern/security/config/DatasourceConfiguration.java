package com.study.pattern.security.config;

import java.sql.SQLException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DatasourceConfiguration {

	@Bean
	public DriverManagerDataSource mysqldataSource() {
	     DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
	     driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
	     driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/userbase");
	     driverManagerDataSource.setUsername("root");
	     driverManagerDataSource.setPassword("MADHUKAR");
	     return driverManagerDataSource;
	 }


	/*@Bean
	@Profile("h2")*/
	public DriverManagerDataSource h2dataSource() {
	     DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
	     driverManagerDataSource.setDriverClassName("org.h2.Driver");
	     driverManagerDataSource.setUrl("jdbc:h2:mem:auth");
	     driverManagerDataSource.setUsername("sa");
	     driverManagerDataSource.setPassword("");
	     return driverManagerDataSource;
	}

	  
	/* @Bean(initMethod="start",destroyMethod="stop")
	 @Profile("h2")*/
	 public org.h2.tools.Server h2WebConsonleServer () throws SQLException {
	   return org.h2.tools.Server.createWebServer("-web","-webAllowOthers","-webDaemon","-webPort", "8082");
	 }

	 

}
