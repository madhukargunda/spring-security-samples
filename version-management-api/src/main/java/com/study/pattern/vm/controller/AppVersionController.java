package com.study.pattern.vm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.pattern.vm.dto.AppVersionDto;
import com.study.pattern.vm.dto.AppVersionRequest;
import com.study.pattern.vm.service.AppVersionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/applications/{application}/versions")
@Api(value="/applications/{application}/versions")
public class AppVersionController {
	
	@Autowired
	AppVersionService appVersionServiceImpl;
	
	
	@PostMapping("/check")
	@ApiOperation("This Operation Givets the latest version of the app ")
	@ApiResponses(value = {@ApiResponse(code=200,message="succcess",response=AppVersionDto.class),@ApiResponse(code=500,message="failue")})
	public AppVersionDto checkAppversion(@PathVariable("application") String application, @RequestBody AppVersionRequest request){
		return null;
	}

}
