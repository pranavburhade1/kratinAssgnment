package com.Kratin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Kratin.entity.User;
import com.Kratin.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserServices {
	
	@Autowired
	private UserRepository uRepo;

	@Override
	public User addUser(User user) {
		
		return uRepo.save(user);
	}

	@Override
	public User logInUser(String email, String password) {
		
		return uRepo.findByEmailAndPassword(email, password);
	}

}
