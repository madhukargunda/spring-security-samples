package com.study.pattern.data;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.study.pattern.data.domain.Booking;
import com.study.pattern.data.repository.BookingRepository;

@SpringBootApplication
@EnableJpaRepositories
public class EmployeSpringBootDataApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext configuration = SpringApplication.run(EmployeSpringBootDataApplication.class, args);
		BookingRepository repository = configuration.getBean(BookingRepository.class);
		List<Booking> findAll = repository.findAll();
		findAll.stream().forEach(i -> System.out.println(i));
		
	}
	
	
	
}
