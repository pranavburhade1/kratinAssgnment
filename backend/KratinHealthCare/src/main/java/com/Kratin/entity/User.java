package com.Kratin.entity;

import java.util.List;

import com.Kratin.enums.Gender;
import com.Kratin.enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
	
	@JsonIgnore
	@OneToMany(mappedBy = "user" , cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Disease> disease;
	
	
	

}
