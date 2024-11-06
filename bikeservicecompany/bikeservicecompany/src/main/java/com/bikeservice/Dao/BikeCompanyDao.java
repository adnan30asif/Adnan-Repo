package com.bikeservice.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bikeservice.Entities.BikeCompany;

public interface BikeCompanyDao extends JpaRepository<BikeCompany, Long>{

}
