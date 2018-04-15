package com.study.pattern.data.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor(staticName="of")
@NoArgsConstructor
@Builder
public class Customer {

/*	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE ,generator="CUSTOMER_SEQUENCE")
	@SequenceGenerator(name="CUSTOMER_SEQUENCE",sequenceName="CUSTOMER_SEQ",initialValue=123 , allocationSize=1) */
	
	@Id
    @SequenceGenerator(name = "mySeqGen", sequenceName = "mySeq", initialValue = 10, allocationSize = 100)
    @GeneratedValue(generator = "mySeqGen")
	private Long id;
	private String name;
	private String email;
	private Date date;
}
