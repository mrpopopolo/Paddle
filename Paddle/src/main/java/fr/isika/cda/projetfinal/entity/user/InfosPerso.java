package fr.isika.cda.projetfinal.entity.user;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class InfosPerso {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nom;
	private String prenom;
	private String sexe;
	private LocalDate dateDeNaissance;
	private String lieuDeNaissance;

	public InfosPerso() {

	}

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

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public LocalDate getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(LocalDate dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public String getLieuDeNaissance() {
		return lieuDeNaissance;
	}

	public void setLieuDeNaissance(String lieuDeNaissance) {
		this.lieuDeNaissance = lieuDeNaissance;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return   nom + " " + prenom  ;
	}
	
	

}
