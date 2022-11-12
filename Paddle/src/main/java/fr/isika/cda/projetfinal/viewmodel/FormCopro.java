package fr.isika.cda.projetfinal.viewmodel;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


import org.hibernate.validator.constraints.NotEmpty;

import fr.isika.cda.projetfinal.entity.user.Compte;
import fr.isika.cda.projetfinal.entity.user.InfosPerso;
import fr.isika.cda.projetfinal.entity.user.Utilisateur;

public class FormCopro {

	@NotEmpty(message = "Ne doit pas être vide")
	@NotNull(message = "Ne doit pas être null")
	@Size(min = 1, max = 50, message = "Doit être entre 1 et 50 car.")
	private String rue;
	
	@Digits(fraction = 0, integer = 5)
	private Integer codePostal;
	
	@NotEmpty(message = "Ne doit pas être vide")
	@NotNull(message = "Ne doit pas être null")
	@Size(min = 1, max = 50, message = "Doit être entre 1 et 50 car.")
	private String ville;

	@NotEmpty(message = "Ne doit pas être vide")
	@NotNull(message = "Ne doit pas être null")
	@Size(min = 1, max = 25, message = "Doit être entre 1 et 25 car.")
	@Pattern(regexp = "[^0-9]*", message = "Ne doit pas contenir des chiffres")
	private String nom;

	@Digits(fraction = 0, integer = 4)
	private Integer nombreLogements;
	
	private String pathToBlason;
	
	private String nomAdmin;
	
	private String prenomAdmin;
	
	private String emailAdmin;
	
	private String motDePasseAdmin;
	
	private String confirmerMotDePasse;

	public FormCopro() {
	}

	
	// ***** Getters / Setters *****

	public String getNom() {
		return nom;
	}

	public String getRue() {
		return rue;
	}


	public void setRue(String rue) {
		this.rue = rue;
	}


	public Integer getCodePostal() {
		return codePostal;
	}


	public void setCodePostal(Integer codePostal) {
		this.codePostal = codePostal;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getNombreLogements() {
		return nombreLogements;
	}

	public void setNombreLogements(Integer nombreLogements) {
		this.nombreLogements = nombreLogements;
	}

	public String getPathToBlason() {
		return pathToBlason;
	}

	public void setPathToBlason(String pathToBlason) {
		this.pathToBlason = pathToBlason;
	}

	public String getNomAdmin() {
		return nomAdmin;
	}

	public void setNomAdmin(String nomAdmin) {
		this.nomAdmin = nomAdmin;
	}

	public String getPrenomAdmin() {
		return prenomAdmin;
	}

	public void setPrenomAdmin(String prenomAdmin) {
		this.prenomAdmin = prenomAdmin;
	}


	public String getEmailAdmin() {
		return emailAdmin;
	}

	public void setEmailAdmin(String emailAdmin) {
		this.emailAdmin = emailAdmin;
	}


	public String getMotDePasseAdmin() {
		return motDePasseAdmin;
	}

	public void setMotDePasseAdmin(String motDePasseAdmin) {
		this.motDePasseAdmin = motDePasseAdmin;
	}

	public String getConfirmerMotDePasse() {
		return confirmerMotDePasse;
	}

	public void setConfirmerMotDePasse(String confirmerMotDePasse) {
		this.confirmerMotDePasse = confirmerMotDePasse;
	}
	
}
