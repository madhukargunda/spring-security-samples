package com.study.pattern.security.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.pattern.security.domain.AppUser;
import com.study.pattern.security.repository.AppUserRepository;
import com.study.pattern.security.service.AppUserService;

@Service
public class AppUserServiceImpl implements AppUserService {

	@Autowired
	AppUserRepository appUserRepository;

	@Override
	public AppUser loadUserByName(String userName) {
		return appUserRepository.findByUsername(userName);
	}

	@Override
	public List<AppUser> findAllUsers() {
		// TODO Auto-generated method stub
		return  appUserRepository.findAll();
	}

	@Override
	public AppUser saveUser(AppUser user) {
		return appUserRepository.save(user);

	}

	@Override
	public void updateUser(AppUser user) {
		

	}

	@Override
	public void deleteUserById(long id) {
		appUserRepository.delete(id);
	}

	@Override
	public AppUser findById(long id) {
		return appUserRepository.findOne(id);
	}

	@Override
	public boolean isUserExist(AppUser user) {
		return findByName(user.getUsername())!=null;
	}

	@Override
	public AppUser findByName(String name) {
		return appUserRepository.findByUsername(name);
	}

	@Override
	public void deleteAllUsers() {
		// TODO Auto-generated method stub
		
	}

}
