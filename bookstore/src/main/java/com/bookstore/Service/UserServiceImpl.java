package com.bookstore.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bookstore.Dao.UserDao;
import com.bookstore.Entity.User;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@Override
	public User registerUser(User user) {
		// TODO Auto-generated method stub
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userDao.save(user);
	}
	
	@Override
	public String login(String username, String password) {
		// TODO Auto-generated method stub
		User user = userDao.findByUsername(username);
		if(user != null && passwordEncoder.matches(password, user.getPassword())) {
			return jwtTokenProvider.generateToken(user.getUsername());
		}
		throw new RuntimeException("Invalid Credentials");
	}
	
	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

	@Override
	public void deleteUser(Long userId) {
		// TODO Auto-generated method stub
		userDao.deleteById(userId);
		
	}

}
