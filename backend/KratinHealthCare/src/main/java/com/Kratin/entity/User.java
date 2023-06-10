package com.Kratin.entity;

import com.Kratin.enums.Gender;
import com.Kratin.enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Data
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(nullable = false)
	private String fullName;
	
	@Column(nullable = false)
	private int age;
	
	@Column(unique = true)
	private String email;
	
	@Column(nullable = false)
	private String password;
	
	private String addressLine1;
	
	@Column(nullable = false)
	private String city;
	
	private Gender gender;
	
	private Role role;
	
	
	
	

}
