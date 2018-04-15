package com.study.pattern.vm.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.pattern.vm.dto.AppVersionDto;
import com.study.pattern.vm.repository.VersionRepository;
import com.study.pattern.vm.service.AppVersionService;

@Service
public class AppVersionServiceImpl implements AppVersionService {
	
	@Autowired
	VersionRepository repository;

	@Override
	public Optional<AppVersionDto> checkVersion(String application, String hashCode) {
		
		
		return null;
	}
	
	

}
