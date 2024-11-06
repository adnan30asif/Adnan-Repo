package com.project.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.Dao.BikeDao;
import com.project.Entities.Bike;


@Service
public class BikeServiceImpl implements BikeService {

	@Autowired
	public BikeDao bikeDao;
	
	@Override
	public Bike addBike(Bike bike) {
		 Bike save = bikeDao.save(bike);
		 return save;
	}
	
	@Override
	public List<Bike> getBikes() {									// Method for showing all the bikes
		return bikeDao.findAll();
	}
	
	
	@Override
	public Bike getBike(long bikeId) {								// Method for fetching a bike by it's ID
		Bike entity = bikeDao.findById(bikeId);
		return entity;
	}


	@Override
	public Bike updateBike(long bikeId, Bike bike) {				// Method for updating details of Bike 
		
		Bike oldBike=null;
		Optional<Bike> optionalBike= Optional.ofNullable(bikeDao.findById(bikeId));
		if(optionalBike.isPresent()){
			oldBike=optionalBike.get();
			oldBike.setBikeMake(bike.getBikeMake());
			oldBike.setModelName(bike.getModelName());
			oldBike.setBikeRegistrationNumber(bike.getBikeRegistrationNumber());;
			oldBike.setBikeChassisNumber(bike.getBikeChassisNumber());
			oldBike.setKnownIssue(bike.getKnownIssue());
			oldBike.setCost(bike.getCost());
			oldBike.setExpDeliveryDate(bike.getExpDeliveryDate());
			oldBike.setCreatedDT(bike.getCreatedDT());
			oldBike.setUpdatedDT(bike.getUpdatedDT());
			oldBike.setAddress(bike.getAddress());
			oldBike.setPhoneNo(bike.getPhoneNo());
			bikeDao.save(oldBike);
		}
		else {
			return new Bike();
		}
		return oldBike;		
		
	}

	@Override
	public void deleteBike(long bikeId) {							// Method for deleting details of Bike
		bikeDao.deleteById(bikeId);
	}

	@Override
	public boolean bikeExists(long parseLong) {						// Method for checking if a bike already exists with a particular id
		return bikeDao.existsById(parseLong);
	}

	@Override
	public boolean bikeExistsByBikeRegistrationNumber(String bikeRegistrationNumber) {		// Method for checking if a bike already exists with a registration number 
		return bikeDao.existsByBikeRegistrationNumber(bikeRegistrationNumber);
	}

	@Override
	public boolean bikeExistsByBikeChassisNumber(long bikeChassisNumber) {			// Method for checking if a bike already exists with a chassis number
		return bikeDao.existsByBikeChassisNumber(bikeChassisNumber);
	}


	}
