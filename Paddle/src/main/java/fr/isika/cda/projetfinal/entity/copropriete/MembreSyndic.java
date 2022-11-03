package fr.isika.cda.projetfinal.entity.copropriete;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MembreSyndic {

	// ***** Variables *****

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nom;

	private String prenom;

	private LocalDate dateDeNaissance;

	private String fonction;

	private LocalDate dateElection;

	private LocalDate dateFinMandat;

	// ***** Constructeur *****

	public MembreSyndic() {

	}

	// ***** Getters / Setters *****

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(LocalDate dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public LocalDate getDateElection() {
		return dateElection;
	}

	public void setDateElection(LocalDate dateElection) {
		this.dateElection = dateElection;
	}

	public LocalDate getDateFinMandat() {
		return dateFinMandat;
	}

	public void setDateFinMandat(LocalDate dateFinMandat) {
		this.dateFinMandat = dateFinMandat;
	}

	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	public Long getId() {
		return id;
	}

}
