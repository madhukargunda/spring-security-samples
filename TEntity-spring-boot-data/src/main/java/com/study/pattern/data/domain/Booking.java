package com.study.pattern.data.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

 
@Entity
@Data
@Table(name="booking")
@NoArgsConstructor
@AllArgsConstructor(staticName="of")
@ToString
@Builder
public class Booking implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long  bookingId;
	
	private String psngrName;
	
	private String depature;

	private String destination;
	
	private Date travelDate;

}
