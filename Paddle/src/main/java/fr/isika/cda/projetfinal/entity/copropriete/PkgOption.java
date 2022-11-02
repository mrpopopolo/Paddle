package fr.isika.cda.projetfinal.entity.copropriete;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PkgOption {

	// ***** Variables *****

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nom;

	// ***** Constructeur *****

	public PkgOption() {

	}

	// ***** Getters / Setters *****

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Long getId() {
		return id;
	}

}
