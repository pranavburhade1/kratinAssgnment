package com.Kratin.entity;

import java.util.List;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Disease {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private  String diseaseName;
	
	@OneToMany(mappedBy = "disease", cascade = CascadeType.ALL, orphanRemoval = true)

	private List<Dosage> dosage;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_userId")
	@JsonIgnore
	private User user;

}
