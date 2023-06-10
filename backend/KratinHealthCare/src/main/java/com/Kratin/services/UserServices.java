package com.Kratin.services;

import com.Kratin.entity.User;

public interface UserServices {
	
	public User addUser(User user);
	
	public User logInUser(String email, String password);

}
