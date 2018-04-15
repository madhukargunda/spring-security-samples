package com.study.pattern.security.service;

import java.util.List;

import com.study.pattern.security.domain.User;


public interface UserService {
	
	public List<User> findAllUsers();
	public User findByName(String name);
	public void saveUser(User user);
    public void deleteAllUsers();
    public void updateUser(User user);
    public void deleteUserById(long id);
    public User findById(long id);
    public boolean isUserExist(User user);	
	
	
}
