package com.study.pattern.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.pattern.data.domain.Customer;
import com.study.pattern.data.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	public Iterable<Customer> list(){
		return customerRepository.findAll();
	}
	
	public Customer save(Customer customer){
		return customerRepository.save(customer);
	}
	
	public List<Customer>  save(Iterable<Customer> customers){
		return  customerRepository.save(customers);
	}
	
	public List<Customer>  findByEmail(String emailId){
		return  customerRepository.findByEmail(new StringBuilder().append("'").append(emailId).append("'").toString());
	}
	
}
