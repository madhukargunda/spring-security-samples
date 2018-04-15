package com.study.pattern.data.domain;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Embeddable
@NoArgsConstructor
public class Address {

	private String street;
    private String suite;
    private String city;
    private String zipcode;
    
    @Embedded
    private Geo geo;
    
    
}
