package com.study.pattern.data;

import java.io.InputStream;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.pattern.data.domain.User;
import com.study.pattern.data.service.UserService;

@SpringBootApplication
public class RwJsonSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(RwJsonSpringBootApplication.class, args);
	}

	 @Bean
	public CommandLineRunner getCommandLineRunner(UserService userService) {
		return (args) -> {
			TypeReference<List<User>> typeReference = new TypeReference<List<User>>() {
			};
			InputStream inputstream = TypeReference.class.getResourceAsStream("/users/users.json");
			try {
				List<User> users = getObjectMapper().readValue(inputstream, typeReference);
				userService.save(users);
			} catch (Exception e) {
				e.printStackTrace();
			}
		};
	} 

	@Bean
	public ObjectMapper getObjectMapper() {
		return new ObjectMapper();
	}
	
	
}
