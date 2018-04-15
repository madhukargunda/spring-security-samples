package com.study.pattern.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.pattern.data.domain.Rating;

public interface RatingRepository extends JpaRepository<Rating, Long> {

	public Rating findByRatingId(Long id);
}
