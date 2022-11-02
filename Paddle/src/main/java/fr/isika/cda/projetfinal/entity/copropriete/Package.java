package fr.isika.cda.projetfinal.entity.copropriete;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Package {
	
	// ***** Variables *****
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	// @OneToOne ?
	@OneToMany
	private List<PkgOption> options;
	
	// ***** Constructeur *****
	
	public Package() {
		
	}

	// ***** Getters / Setters *****
	
	public List<PkgOption> getOptions() {
		return options;
	}

	public void setOptions(List<PkgOption> options) {
		this.options = options;
	}

	public Long getId() {
		return id;
	}
	
	
	
	
	
	
	

}
