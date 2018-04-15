package com.study.pattern.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.study.pattern.security.domain.AppUser;
import com.study.pattern.security.dto.SpringSecurityUser;

@Service
public class AppUserDetailsService implements UserDetailsService {

	@Autowired
	AppUserServiceImpl appUserServiceImpl;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser appUser = appUserServiceImpl.findByName(username);
		if (appUser == null) {
			throw new UsernameNotFoundException(String.format("No appUser found with username '%s'.", username));
		} else {
			return new SpringSecurityUser(appUser.getId(), appUser.getUsername(), appUser.getPassword(), null, null,
					AuthorityUtils.commaSeparatedStringToAuthorityList(appUser.getAuthorities()));
		}
	}

}
