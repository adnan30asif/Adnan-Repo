package com.project.Entities;

import java.sql.Date;
import java.sql.Timestamp;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Bike {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long bikeId;
	@NotBlank(message="Must have some value")
	private String bikeMake;
	
	@NotBlank(message="Must have some value")
	private String modelName;
	
	@NotBlank(message="Must have some value")
	private String bikeRegistrationNumber;
	
	@NotNull(message="Must have some value")
	private long bikeChassisNumber;

	@NotBlank(message="Must have some value")
	private String knownIssue;
	
	@NotNull(message="Must have some value")
	private int cost;
	
	@NotNull(message="Must have some value")
	private Date expDeliveryDate;
	
	@NotNull(message="Must have some value")
	private Timestamp createdDT;
	
	@NotNull(message="Must have some value")
	private Timestamp updatedDT;

	//@OneToOne(cascade=CascadeType.ALL)
	@Size(min = 10, max = 250)
	@NotBlank(message="Must have some value")
	private String address;
	
	@Digits(integer = 10,fraction = 0)
	@NotNull(message="Must have some value")	
	private Number phoneNo;
	
	
	//Generating getters and setters for the above data members
	
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

	public long getBikeChassisNumber() {
		return bikeChassisNumber;
	}

	public void setBikeChassisNumber(long bikeChassisNumber) {
		this.bikeChassisNumber = bikeChassisNumber;
	}

	public String getKnownIssue() {
		return knownIssue;
	}

	public void setKnownIssue(String knownIssue) {
		this.knownIssue = knownIssue;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Number getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(Number phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	
	public Bike(long bikeId, @NotBlank String bikeMake, @NotNull String modelName,
			@NotNull String bikeRegistrationNumber, @NotNull long bikeChassisNumber, @NotNull String knownIssue,
			@NotNull int cost, @NotNull Date expDeliveryDate, @NotNull Timestamp createdDT,
			@NotNull Timestamp updatedDT,@NotNull String address,@NotNull Number phoneNo) {
		super();
		this.bikeId = bikeId;
		this.bikeMake = bikeMake;
		this.modelName = modelName;
		this.bikeRegistrationNumber = bikeRegistrationNumber;
		this.bikeChassisNumber = bikeChassisNumber;
		this.knownIssue = knownIssue;
		this.cost = cost;
		this.expDeliveryDate = expDeliveryDate;
		this.createdDT = createdDT;
		this.updatedDT = updatedDT;
		this.address = address;
		this.phoneNo = phoneNo;
	}

	public Bike() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean isPresent() {
		// TODO Auto-generated method stub
		return false;
	}

}
