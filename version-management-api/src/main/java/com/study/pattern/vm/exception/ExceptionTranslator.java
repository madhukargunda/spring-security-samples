package com.study.pattern.vm.exception;

import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.HandlerMethod;

@ControllerAdvice
public class ExceptionTranslator {

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	@ExceptionHandler(Exception.class)
	public ApiError handleException(Exception ex ,HandlerMethod handler){
		return new ApiError("","");
	}
	
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	@ExceptionHandler(ResourceNotFoundException.class)
	public ApiError handleResourceNotFoundException(ResourceNotFoundException ex ,HandlerMethod handler){
		return new ApiError("","");
	}
	
}
