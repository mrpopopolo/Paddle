package fr.isika.cda.projetfinal.entity.copropriete;

import java.io.File;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class IdentiteVisuelle {

	// ***** Variables *****

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private File logo; // A Changer en tableau de byte 

	// voir avec Mohammed pour creer une classe template

	// ***** Constructeur *****

	public IdentiteVisuelle() {

	}

	// ***** Getters / Setters *****

	public File getLogo() {
		return logo;
	}

	public void setLogo(File logo) {
		this.logo = logo;
	}

	public Long getId() {
		return id;
	}

}
