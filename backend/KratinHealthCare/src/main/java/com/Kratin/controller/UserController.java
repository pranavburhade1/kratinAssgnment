package com.Kratin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Kratin.dto.ApiResponse;
import com.Kratin.dto.LogInCred;
import com.Kratin.entity.User;
import com.Kratin.services.UserServices;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserServices uService;

	
	@PostMapping("/add")
	public ResponseEntity<?> addUser(@RequestBody User user) {
		User userFromDB = null;

		try {
			userFromDB = uService.addUser(user);
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse("Unable to create User.",e.getMessage()));
			
		}
	    return ResponseEntity.status(HttpStatus.OK).body(userFromDB);
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> logIn(@RequestBody LogInCred user) {
		User userFromDB = null;

		try {
			userFromDB = uService.logInUser(user.getEmail(), user.getPassword());
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse("Something went wrong",e.getMessage()));	
		}
		if(user == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("Invalid Credinals"));	
		}
	    return ResponseEntity.status(HttpStatus.OK).body(userFromDB);
		
	}
}
