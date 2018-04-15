package com.study.pattern.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.pattern.security.domain.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
	
	public AppUser findByUsername(String username);
}
