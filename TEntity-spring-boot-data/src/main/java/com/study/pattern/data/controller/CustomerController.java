package com.study.pattern.data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.study.pattern.data.domain.Customer;
import com.study.pattern.data.filter.WebFilter;
import com.study.pattern.data.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@GetMapping("/customers")
	public Iterable<Customer> list(){
		return customerService.list();
	}
	
	@PostMapping("/customers")
	public @ResponseBody Customer Save(@RequestBody Customer customer){
		return customerService.save(customer);
	}
	
	@GetMapping("/customers/search")
	public @ResponseBody List<Customer> listByEmaill(WebFilter filter){
		return customerService.findByEmail(filter.getEmail());
	}
}
