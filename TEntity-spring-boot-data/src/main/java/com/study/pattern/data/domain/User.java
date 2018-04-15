package com.study.pattern.data.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class User {

    @Id
	private Long userId;
	private String userName;
	private String password;
	
	@OneToMany(targetEntity=Address.class,mappedBy="user")
	private Set<Address> address;

}
