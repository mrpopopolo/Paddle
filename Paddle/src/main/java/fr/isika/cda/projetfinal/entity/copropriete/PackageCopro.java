package fr.isika.cda.projetfinal.entity.copropriete;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class PackageCopro {
	
	// ***** Variables *****
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToMany
	private List<OptionCopro> options;
	
	// ***** Constructeur *****
	
	public PackageCopro() {
		
	}

	// ***** Getters / Setters *****

	public List<OptionCopro> getOptions() {
		return options;
	}

	public void setOptions(List<OptionCopro> options) {
		this.options = options;
	}

	public Long getId() {
		return id;
	}
	
	
	
	
	
	
	

}
