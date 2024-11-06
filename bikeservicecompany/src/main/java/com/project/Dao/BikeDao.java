package com.project.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.Entities.Bike;

public interface BikeDao extends JpaRepository<Bike, Long> {

	boolean existsByBikeRegistrationNumber(String bikeRegistrationNumber);
	boolean existsByBikeChassisNumber(long bikeChassisNumber);
	Bike findById(long bikeId);
	

}
