package com.study.pattern.vm.config;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.assertj.core.util.Lists;
import org.springframework.context.annotation.Bean;

import io.swagger.models.Contact;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

public class WebConfig {

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("guru.springframework.controllers"))
				.paths(PathSelectors.any()).build().securitySchemes(Lists.newArrayList(apikey()))
				.securityContexts(Lists.newArrayList(securityContext()))
				.produces(new HashSet<>(Arrays.asList(new String[] { "https" }))).apiInfo(metaData());
	}

	public SecurityContext securityContext() {
		SecurityReference ref = SecurityReference.builder().reference("api_auth")
				.scopes(new AuthorizationScope[] { scopes().get(0) }).build();
		return SecurityContext.builder().securityReferences(Lists.newArrayList(ref)).forPaths(PathSelectors.any())
				.build();

	}

	@Bean
	public SecurityScheme apikey() {
		return new ApiKey("api_key", "api_key", "header");
	}

	private ApiInfo metaData() {
		Contact contact = new Contact().name("name");
		ApiInfo apiInfo = new ApiInfo("Spring Boot REST API", "Spring Boot REST API for Online Store", "1.0",
				"Terms of service", "", "Apache License Version 2.0", "https://www.apache.org/licenses/LICENSE-2.0");
		return apiInfo;
	}

	private List<AuthorizationScope> scopes() {
		return Lists.newArrayList(new AuthorizationScope("api_read", "Reading the data"),
				new AuthorizationScope("api_write", "Reading the data"));
	}

}
