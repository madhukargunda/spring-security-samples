package com.study.pattern.security.config;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DatasourceConfiguration {
	
	@Resource
	private Environment env;

	@Bean(destroyMethod = "close")
	DataSource dataSource() {
		HikariConfig dataSourceConfig = new HikariConfig();
		dataSourceConfig.setDriverClassName("com.mysql.jdbc.Driver");
		dataSourceConfig.setJdbcUrl("jdbc:mysql://localhost:3306/secbase");
		dataSourceConfig.setUsername("root");
		dataSourceConfig.setPassword("MADHUKAR");		
		return new HikariDataSource(dataSourceConfig);
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
