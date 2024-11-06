package com.bikeservice.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bikeservice.Dao.BikeCompanyDao;
import com.bikeservice.Entities.BikeCompany;


@Service
public class BikeCompanyServiceImp implements BikeCompanyService {

	@Autowired
	private BikeCompanyDao bikeDao;
	
	public List<BikeCompany> getBikes() {
		return bikeDao.findAll();
	}

}
