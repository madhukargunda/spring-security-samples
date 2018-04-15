package com.study.pattern.vm.service;

import java.util.Optional;

import com.study.pattern.vm.dto.AppVersionDto;


public interface AppVersionService {
	
	public Optional<AppVersionDto> checkVersion(String application,String hashCode);
}
