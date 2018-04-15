package com.study.pattern.data.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor(staticName="of")
@NoArgsConstructor
@Table(name="ratings")
@Builder
public class Rating {
	
	@Id	
	private Long ratingId;	
	private double rating;	
	private String userId;
}
