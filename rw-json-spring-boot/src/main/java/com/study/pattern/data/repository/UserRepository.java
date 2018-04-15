package com.study.pattern.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.pattern.data.domain.User;

public interface UserRepository  extends JpaRepository<User, Long>{
	
	

}
