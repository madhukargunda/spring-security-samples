package com.study.pattern.vm.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.study.pattern.vm.constant.Recommendation;

public class AppVersion {
	
	@EmbeddedId
	private AppVersionIdentity id;
	
	@Column(name="PLATFORM",nullable=false)
	private String platform;
	
	@Column(name="TAG",nullable=false)
	private String appVersion;
	
	
	@Column(name="RECOMMENDATION" ,nullable=false)
	@Enumerated(EnumType.STRING)
	private Recommendation recommendation;
	
	
	
	

}
