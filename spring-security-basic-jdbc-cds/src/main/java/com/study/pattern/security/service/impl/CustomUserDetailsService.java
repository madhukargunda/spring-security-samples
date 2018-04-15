package com.study.pattern.security.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.study.pattern.security.domain.CustomUserDetails;
import com.study.pattern.security.domain.SecUser;
import com.study.pattern.security.repository.SecUserDetailsRepository;
import com.study.pattern.security.repository.SecUserRoleRespository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	SecUserDetailsRepository secUserDetailRepository;
	
	@Autowired
	SecUserRoleRespository secUserRoleRespository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		SecUser user = secUserDetailRepository.findByUserName(username);
		if (null == user) {
			throw new UsernameNotFoundException("No user present with username: " + username);
		} else {
			List<String> userRoles = secUserRoleRespository.findRoleByUserName(username);
			return new CustomUserDetails(user, userRoles);
		}
	}
}
