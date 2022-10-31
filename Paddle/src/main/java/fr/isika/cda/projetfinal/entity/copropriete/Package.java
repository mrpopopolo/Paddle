package fr.isika.cda.projetfinal.entity.copropriete;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Package {
	
	// ***** Variables *****
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	// @OneToOne ? 
	private List<Option> options;
	
	// ***** Constructeur *****
	
	public Package() {
		
	}

	// ***** Getters / Setters *****
	
	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}

	public Long getId() {
		return id;
	}
	
	
	
	
	
	
	

}
