package fr.isika.cda.projetfinal.entity.copropriete;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Residence {

	// ***** Variables *****

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nom;

	private String adresse;

	private int nombreLogements;

	// ***** Constructeur *****

	public Residence() {

	}

	// ***** Getters / Setters *****

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getNombreLogements() {
		return nombreLogements;
	}

	public void setNombreLogements(int nombreLogements) {
		this.nombreLogements = nombreLogements;
	}

	public Long getId() {
		return id;
	}

}
