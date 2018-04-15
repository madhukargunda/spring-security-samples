package com.study.pattern.vm.exception;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ErrorCode {

  String ERROR_CODE_PREFIX_API_ENTRY_METHOD_CODE="API_VCHK";	
  String ERROR_CODE_PREFIX_API_ENTRY_UNKNOW_METHOD="API_UNK";	
  String value() default ERROR_CODE_PREFIX_API_ENTRY_UNKNOW_METHOD;
}
