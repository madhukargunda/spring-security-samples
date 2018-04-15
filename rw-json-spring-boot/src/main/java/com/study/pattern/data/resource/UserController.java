package com.study.pattern.data.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.pattern.data.domain.User;
import com.study.pattern.data.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/users")
	public Iterable<User> list(){
		return userService.list();
	}
	


}
