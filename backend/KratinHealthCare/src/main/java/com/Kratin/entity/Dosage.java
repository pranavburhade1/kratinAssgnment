package com.Kratin.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Dosage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String medicineName;
	
	@ManyToOne
	@JoinColumn(name = "fk_diseaseId")
	@JsonIgnore
	private Disease disease;
	
	@OneToMany(mappedBy = "dosage", cascade = CascadeType.ALL, orphanRemoval = true)

	private List<TimeTable> timeTable;

}
