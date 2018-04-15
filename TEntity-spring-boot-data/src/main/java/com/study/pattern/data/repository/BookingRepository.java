package com.study.pattern.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.pattern.data.domain.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
	public Booking findByDepature(String departure);
}
