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

	private String rue;

	private int codePostal;

	private String ville;

	private Integer nombreLogements;

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

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Integer getNombreLogements() {
		return nombreLogements;
	}

	public void setNombreLogements(Integer nombreLogements) {
		this.nombreLogements = nombreLogements;
	}

	public Long getId() {
		return id;
	}

}
