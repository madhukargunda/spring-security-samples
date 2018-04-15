package com.study.pattern.data.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Embeddable
@NoArgsConstructor
public class Company {
	
	@Column(name="company_name")
	private String name;
    private String catchPhrase;
    private String bs;
    
    
}
