package com.study.pattern.vm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.pattern.vm.entity.AppVersion;
import com.study.pattern.vm.entity.AppVersionIdentity;

public interface VersionRepository extends JpaRepository<AppVersion,AppVersionIdentity> {

	public Optional<AppVersion> findbyId(AppVersionIdentity appversionIdentity);
	
	

}
