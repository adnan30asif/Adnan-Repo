package com.bikeservice.Entities;

import java.sql.Date;
import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BikeCompany {
	
	@Id
	private long bikeId;
	private String bikeMake;
	private String modelName;
	private String bikeRegistrationNumber;
	private int bikeChassisNumber;
	private String knownIssuse;
	private int cost;
	private Date expDeliveryDate;
	private Timestamp createdDT;
	private Timestamp updatedDT;
	private Number phoneno;
	public long getBikeId() {
		return bikeId;
	}
	public void setBikeId(long bikeId) {
		this.bikeId = bikeId;
	}
	public String getBikeMake() {
		return bikeMake;
	}
	public void setBikeMake(String bikeMake) {
		this.bikeMake = bikeMake;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getBikeRegistrationNumber() {
		return bikeRegistrationNumber;
	}
	public void setBikeRegistrationNumber(String bikeRegistrationNumber) {
		this.bikeRegistrationNumber = bikeRegistrationNumber;
	}
	public int getBikeChassisNumber() {
		return bikeChassisNumber;
	}
	public void setBikeChassisNumber(int bikeChassisNumber) {
		this.bikeChassisNumber = bikeChassisNumber;
	}
	public String getKnownIssuse() {
		return knownIssuse;
	}
	public void setKnownIssuse(String knownIssuse) {
		this.knownIssuse = knownIssuse;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public Date getExpDeliveryDate() {
		return expDeliveryDate;
	}
	public void setExpDeliveryDate(Date expDeliveryDate) {
		this.expDeliveryDate = expDeliveryDate;
	}
	public Timestamp getCreatedDT() {
		return createdDT;
	}
	public void setCreatedDT(Timestamp createdDT) {
		this.createdDT = createdDT;
	}
	public Timestamp getUpdatedDT() {
		return updatedDT;
	}
	public void setUpdatedDT(Timestamp updatedDT) {
		this.updatedDT = updatedDT;
	}
	public Number getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(Number phoneno) {
		this.phoneno = phoneno;
	}
	public BikeCompany(long bikeId, String bikeMake, String modelName, String bikeRegistrationNumber,
			int bikeChassisNumber, String knownIssuse, int cost, Date expDeliveryDate, Timestamp createdDT,
			Timestamp updatedDT, Number phoneno) {
		super();
		this.bikeId = bikeId;
		this.bikeMake = bikeMake;
		this.modelName = modelName;
		this.bikeRegistrationNumber = bikeRegistrationNumber;
		this.bikeChassisNumber = bikeChassisNumber;
		this.knownIssuse = knownIssuse;
		this.cost = cost;
		this.expDeliveryDate = expDeliveryDate;
		this.createdDT = createdDT;
		this.updatedDT = updatedDT;
		this.phoneno = phoneno;
	}
	public BikeCompany() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
