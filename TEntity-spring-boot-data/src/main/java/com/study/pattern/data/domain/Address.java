package com.study.pattern.data.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Address {
	
	private String city;
	private String state;
	private String country;	
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	@Id
	private String address_id;



}
