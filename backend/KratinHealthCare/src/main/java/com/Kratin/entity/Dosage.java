package com.Kratin.entity;

import java.util.List;

import jakarta.persistence.Entity;

@Entity
public class Dosage {
	
	private Integer id;
	
	private String medicineName;
	
	private Disease disease;
	
	private List<TimeTable> timeTable;

}
