package com.project.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.project.Entities.Bike;
import com.project.Exception.BikeAlreadyExistsException;
import com.project.Exception.BikeNotFoundException;
import com.project.Service.BikeService;

import jakarta.validation.Valid;

@RestController
public class BikeController {

	@Autowired
	public BikeService bikeService;
	
	
	// To display a welcome message
	
	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome";
	}

	// For getting all the bikes
	
	@GetMapping("/bikeservice")
	public List<Bike> getBikes() throws BikeNotFoundException {
		List<Bike> bikes = this.bikeService.getBikes();
		if (bikes.isEmpty()) {
			throw new BikeNotFoundException("Bike not found");
		}
		return bikes;
	}
	

	// For fetching a particular bike using it's ID
	
	
	@GetMapping("/bikeservice/{bikeId}")
	public Bike getBike(@PathVariable String bikeId) throws BikeNotFoundException {
		if (bikeService.bikeExists(Long.parseLong(bikeId))) {
			Bike bike = bikeService.getBike(Long.parseLong(bikeId));
			return bike;
		} 
		else{
			throw new BikeNotFoundException("Bike with ID: " + bikeId + " not found");
		}
	}
	

	// For inserting details of bikes
	
	@PostMapping("/bikeservice")
//	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<String> addBike(@Valid @RequestBody Bike bike) throws BikeAlreadyExistsException {

		if (bikeService.bikeExistsByBikeRegistrationNumber(bike.getBikeRegistrationNumber())) {
			throw new BikeAlreadyExistsException(
					"Bike with registration number " + bike.getBikeRegistrationNumber() + " already exists");
		} 
		else {
			if (bikeService.bikeExistsByBikeChassisNumber(bike.getBikeChassisNumber())) {
				throw new BikeAlreadyExistsException(
						"Bike with Chassis number " + bike.getBikeChassisNumber() + " already exists");
			}
		}

		this.bikeService.addBike(bike);
		return new ResponseEntity<>("Created Successfully!!",HttpStatus.CREATED);
		 
	}
	
	
	// For updating details of a particular bike using it's ID

	
	@PutMapping("/bikeservice/{bikeId}")
//	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<String> updateBike(@Valid @PathVariable long bikeId, @RequestBody Bike bike) throws BikeNotFoundException {

		if (bikeService.bikeExists(bikeId)) {
			this.bikeService.updateBike(bikeId, bike);
		} else {
			throw new BikeNotFoundException("Bike with ID: " + bikeId + " not found");
		}
		return new ResponseEntity<>("Updated Successfully!!",HttpStatus.CREATED);
	}
	
	
	// For deleting the details of a particular bike using it's ID

	@DeleteMapping("/bikeservice/{bikeId}")
	//@ResponseStatus(code = HttpStatus.ACCEPTED)
	public ResponseEntity<String> deleteBike(@PathVariable long bikeId) throws BikeNotFoundException {
		if (bikeService.bikeExists(bikeId)) {
			this.bikeService.deleteBike(bikeId);	
		} 
		else {
			throw new BikeNotFoundException("Bike with ID: " + bikeId + " not found");

		}
		return  new ResponseEntity<>("Deleted Successfully!",HttpStatus.ACCEPTED);
	}
}
