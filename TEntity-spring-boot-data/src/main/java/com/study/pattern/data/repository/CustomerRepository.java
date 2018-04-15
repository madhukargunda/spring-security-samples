package com.study.pattern.data.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.pattern.data.domain.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
	List<Customer> findByEmail(String email);
	
    List<Customer> findByDate(Date date);
}
