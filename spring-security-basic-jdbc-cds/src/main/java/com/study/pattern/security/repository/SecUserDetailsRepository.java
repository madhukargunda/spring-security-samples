package com.study.pattern.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.pattern.security.domain.SecUser;

public interface SecUserDetailsRepository extends JpaRepository<SecUser, Long>  {
	public SecUser findByUserName(String username);
}
