package com.study.pattern.security.config;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("madhukar").password("madhukar").authorities("ROLE_USER").and().
		withUser("santosh").password("santosh").authorities("ROLE_USER").and().
		withUser("kishore").password("kishore").authorities("ROLE_USER");		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().exceptionHandling().authenticationEntryPoint(getAuthenticationEntryPoint()).and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER).and()
				.authorizeRequests().anyRequest().access("hasRole('ROLE_USER')").and().httpBasic();
	}
	
	@Bean
	public AuthenticationEntryPoint getAuthenticationEntryPoint(){		
		System.out.println("Calling this method here now");
		return  (request,response,auth) -> {response.sendError( HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized" );
		PrintWriter writer = response.getWriter();
        writer.println("HTTP Status 401 : " + "auth.getMessage()");
	};
	}
}
