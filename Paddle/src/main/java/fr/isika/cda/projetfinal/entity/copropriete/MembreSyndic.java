package fr.isika.cda.projetfinal.entity.copropriete;

import java.util.Date;

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
	
	private Date dateDeNaissance;  // Java.util ou sql ? 
	
	private String fonction; 
	
	private Date dateElection; 
	
	private Date dateFinMandat;
	
	
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


	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}


	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}


	public String getFonction() {
		return fonction;
	}


	public void setFonction(String fonction) {
		this.fonction = fonction;
	}


	public Date getDateElection() {
		return dateElection;
	}


	public void setDateElection(Date dateElection) {
		this.dateElection = dateElection;
	}


	public Date getDateFinMandat() {
		return dateFinMandat;
	}


	public void setDateFinMandat(Date dateFinMandat) {
		this.dateFinMandat = dateFinMandat;
	}


	public Long getId() {
		return id;
	}
	

	
	
}
