package com.project.Service;

import java.util.List;

import com.project.Entities.Bike;
import com.project.Exception.BikeNotFoundException;

public interface BikeService {

	public List<Bike> getBikes();
	
	public Bike getBike(long bikeId);
	
	public Bike addBike(Bike bike);
	
	public Bike updateBike(long bikeId, Bike bike) throws BikeNotFoundException;
	
	public void deleteBike(long bikeId);

	public boolean bikeExists(long parseLong);

	public boolean bikeExistsByBikeRegistrationNumber(String bikeRegistrationNumber);

	public boolean bikeExistsByBikeChassisNumber(long l);

	
	
}
