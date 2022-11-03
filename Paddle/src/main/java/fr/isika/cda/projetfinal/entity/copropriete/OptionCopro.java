package fr.isika.cda.projetfinal.entity.copropriete;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OptionCopro {

	// ***** Variables *****

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nom;
	
	private Double cout;

	// ***** Constructeur *****
	
	public OptionCopro() {

	}

	// ***** Getters / Setters *****

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Double getCout() {
		return cout;
	}

	public void setCout(Double cout) {
		this.cout = cout;
	}

	public Long getId() {
		return id;
	}

}
