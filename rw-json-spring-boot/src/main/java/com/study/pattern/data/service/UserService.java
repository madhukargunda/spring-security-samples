package com.study.pattern.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.pattern.data.domain.User;
import com.study.pattern.data.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public Iterable<User> list(){
		return userRepository.findAll();		
	}
	
	public Iterable<User> save(List<User> users){
		return userRepository.save(users);
	}
	
	public User save(User user){
		return userRepository.save(user);
	}

}
