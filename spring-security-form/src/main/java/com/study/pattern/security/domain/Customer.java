package com.study.pattern.security.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(staticName="of")
public class Customer {
	
	
	private String id;
	
	private String firstName;
	
	private String lastName;
	
	private String middleName;
	
	

}
