package com.study.pattern.data.config;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import com.study.pattern.data.domain.Booking;
import com.study.pattern.data.domain.Customer;
import com.study.pattern.data.domain.Rating;
import com.study.pattern.data.repository.BookingRepository;
import com.study.pattern.data.repository.RatingRepository;
import com.study.pattern.data.service.CustomerService;

@Configuration
public class DataLoader {
	
	
	@Bean
	@Order(1)
	CommandLineRunner loadDataIntoBookingRepository(BookingRepository bookingRepository){	
		return arg1 -> {
			bookingRepository.save(Booking.of(1l,"Madhukar","SIN","HYD",new Date()));
			bookingRepository.save(Booking.builder().bookingId(2l).psngrName("deepthi").depature("HYD").destination("SIN").travelDate(new Date()).build());
		};
	}
	
	@Bean
	@Order(2)
	CommandLineRunner loadDataIntoRatingsRepository(RatingRepository repository){
		return repo->{
			repository.save(Rating.builder().ratingId(2L).rating(23.5D).userId("206359").build());
		};
	}
	
	@Bean
	@Order(3)
	CommandLineRunner loadDataIntoCustomerRepository(CustomerService customerService){		
		return (args) -> {
			Customer lakshman =  Customer.builder().email("lakshman@gmail.com").name("Lakshman").date(new Date()).build();
			Customer ram =  Customer.builder().email("ram@gmail.com").name("Ram").date(new Date()).build();
			Customer venki =  Customer.builder().email("venki@gmail.com").name("Venki").date(new Date()).build();
			List<Customer> customerlist = Arrays.asList(lakshman,ram,venki);
			customerService.save(customerlist);
		};
	}
}	