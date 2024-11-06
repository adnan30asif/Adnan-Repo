package com.bookstore.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.Entity.User;

public interface UserDao extends JpaRepository<User, Long>{
	
	public User findByUsername(String username);

}
