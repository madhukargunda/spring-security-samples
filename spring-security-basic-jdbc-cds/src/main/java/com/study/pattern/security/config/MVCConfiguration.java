package com.study.pattern.security.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
@ComponentScan({ "com.study.pattern.*" })
@Import({SecurityConfiguration.class,PersistenceConfig.class})
public class MVCConfiguration {

}
