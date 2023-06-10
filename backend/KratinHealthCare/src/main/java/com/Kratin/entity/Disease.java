package com.Kratin.entity;

import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Disease {
	
	@Id
	private Integer id;
	
	private  String diseaseName;
	
	@OneToMany(mappedBy = "disease", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Dosage> dosage;
	
	@ManyToAny(fetch = FetchType.EAGER)
	@JoinColumn()
	private User user;

}
