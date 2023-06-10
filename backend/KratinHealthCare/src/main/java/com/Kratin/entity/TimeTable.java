package com.Kratin.entity;

import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class TimeTable {
	
	@Id
	private Integer id;
	
	private LocalTime time;
	
	private Dosage dosage;

}
