package com.bikeservice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bikeservice.Entities.BikeCompany;
import com.bikeservice.Service.BikeCompanyService;

@RestController
public class MyController {
	
	@Autowired
	private BikeCompanyService bikeCompanyService;
	
	@GetMapping("/home")
	public String home() {
		return "Bike Service Company";
	}
	
	@GetMapping("/bikeservices")
	public List<com.bikeservice.Entities.BikeCompany> getBikes(){
		return this.bikeCompanyService.getBikes();
	}
	

	
	
}
