package com.project;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.Dao.BikeDao;
import com.project.Entities.Bike;
import com.project.Service.BikeServiceImpl;

@SpringBootTest
class BikeServiceCompanyApplicationTests {

	@Mock
	private BikeDao bikeDao;
	
	@InjectMocks
	private BikeServiceImpl bikeService;
	
	@Test
	void contextLoads() {
	}

	@BeforeEach
	void setup() {
		Date today = new Date(0); 
		Timestamp t1= new Timestamp(0);
		Timestamp t2= new Timestamp(0);
		Bike bike= new Bike(1,"abcde","400","dfgh",1,"fdgh",1,today,t1,t2,"abcdefghijk",1234567890);
		bikeDao.save(bike);
	}
	
	@Test
	void getBikes() {
		Date today = new Date(0); 
		Timestamp t1= new Timestamp(0);
		Timestamp t2= new Timestamp(0);
		List <Bike> expected = new ArrayList<>();
		expected.add(new Bike(1,"abcde","400","dfgh",1,"fdgh",1,today,t1,t2,"abcdefghijk",1234567890));
		expected.add(new Bike(2,"abcde","400","dfgh",1,"fdgh",1,today,t1,t2,"abcdefghijk",1234567890));
		when(bikeDao.findAll()).thenReturn(expected);
		List <Bike> actual = bikeService.getBikes();
		assertEquals(expected, actual);
	}
	
	@Test
	void getById() {
		Date today = new Date(0); 
		Timestamp t1= new Timestamp(0);
		Timestamp t2= new Timestamp(0);
		Bike expected = new Bike(1,"abcde","400","dfgh",1,"fdgh",1,today,t1,t2,"abcdefghijk",1234567890);
		when(bikeDao.findById(1)).thenReturn(expected);
		Bike actual = bikeService.getBike(1);
		assertEquals(expected, actual);
	}
	
	@Test
	void addBike() {
		Date today = new Date(0); 
		Timestamp t1= new Timestamp(0);
		Timestamp t2= new Timestamp(0);
		Bike expected = new Bike(1,"abcde","400","dfgh",1,"fdgh",1,today,t1,t2,"abcdefghijk",1234567890);
		when(bikeDao.save(expected)).thenReturn(expected);
		Bike actual = bikeService.addBike(expected);
		assertEquals(expected, actual);
	}

	@Test
	void updateBike() {
		Date today = new Date(0); 
		Timestamp t1= new Timestamp(0);
		Timestamp t2= new Timestamp(0);
		Bike expected = new Bike(1,"abcde","400","dfgh",1,"fdgh",1,today,t1,t2,"abcdefghijk",1234567890);
		when(bikeDao.findById(1)).thenReturn(expected);
		when(bikeDao.save(expected)).thenReturn(expected);
		Bike actual = bikeService.updateBike(1,expected);
		assertEquals(expected, actual);
	}
	
	@Test
	void deleteBike() {
		bikeDao.deleteById(1L);
		assertThat(bikeDao.existsById(1L)).isFalse();
	}
	
	
	/*
	 * @BeforeEach void addBike(){ Date today = new Date(0); Timestamp t1= new
	 * Timestamp(0); Timestamp t2= new Timestamp(0);
	 * 
	 * Bike bike= new
	 * Bike(1,"abcde","400","dfgh",1,"fdgh",1,today,t1,t2,"abcdefghijk",1234567890);
	 * bikeDao.save(bike); }
	 * 
	 * @Test void updateBike(){ Date today = new Date(0); Timestamp t1= new
	 * Timestamp(0); Timestamp t2= new Timestamp(0);
	 * 
	 * Bike bike= new
	 * Bike(1,"abcde","400","dfgh",1,"fdgh",1,today,t1,t2,"abcdefghijk",1234567890);
	 * bikeDao.save(bike); }
	 * 
	 * @Test void setUp(){ Date today = new Date(0); Timestamp t1= new Timestamp(0);
	 * Timestamp t2= new Timestamp(0);
	 * 
	 * Bike bike= new
	 * Bike(1,"abcde","400","dfgh",1,"fdgh",1,today,t1,t2,"abcdefghijk",1234567890);
	 * bikeDao.save(bike); }
	 * 
	 * 
	 * @Test void deleteBike() { bikeDao.deleteById((long) 1); }
	 * 
	 * @Test void getUsers() { List<Bike> list = bikeDao.findAll();
	 * assertThat(list).asList(); }
	 * 
	 * @Test void findById() { Bike bike = bikeDao.findById((long) 1);
	 * assertThat(bike).isNotNull(); }
	 */
	
}
