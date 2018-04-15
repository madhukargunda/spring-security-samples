package com.study.pattern.security.service;

import java.util.List;

import com.study.pattern.security.domain.AppUser;

public interface AppUserService {

	AppUser loadUserByName(String userName);

	public List<AppUser> findAllUsers();

	public AppUser saveUser(AppUser user);

	public void updateUser(AppUser user);

	public void deleteUserById(long id);

	public AppUser findById(long id);

	public boolean isUserExist(AppUser user);

	public AppUser findByName(String name);

	public void deleteAllUsers();

}
