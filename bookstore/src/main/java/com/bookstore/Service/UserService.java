package com.bookstore.Service;

import java.util.List;

import com.bookstore.Entity.User;

public interface UserService {
	
	public User registerUser(User user);

	public String login(String username, String password);
	
	public List<User> getUsers();
	
	public void deleteUser(Long userId);

}
