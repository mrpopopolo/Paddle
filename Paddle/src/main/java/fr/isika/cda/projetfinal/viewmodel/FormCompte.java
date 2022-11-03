package fr.isika.cda.projetfinal.viewmodel;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class FormCompte {

	@NotEmpty(message = "Ne doit pas être vide")
	@NotNull(message = "Ne doit pas être null")
	@Size(min = 1, max = 25, message = "Doit être entre 1 et 25 car.")
	@Pattern(regexp = "[^0-9]*", message = "Ne doit pas contenir des chiffres")
	private String prenom;
	
	@NotEmpty(message = "Ne doit pas être vide")
	@NotNull(message = "Ne doit pas être null")
	@Size(min = 1, max = 25, message = "Doit être entre 1 et 25 car.")
	@Pattern(regexp = "[^0-9]*", message = "Ne doit pas contenir des chiffres")
	private String nom;
	
	@NotEmpty(message = "Ne doit pas être vide")
	@NotNull(message = "Ne doit pas être null")
	@Email
	private String email;
	
	@NotEmpty(message = "Ne doit pas être vide")
	@NotNull(message = "Ne doit pas être null")
	@Size(min = 1, max = 25, message = "Doit être entre 1 et 25 car.")
	private String motDePasse;
	
	@NotEmpty(message = "Ne doit pas être vide")
	@NotNull(message = "Ne doit pas être null")
	@Size(min = 1, max = 25, message = "Doit être entre 1 et 25 car.")
	private String confirmerMdp;

	public FormCompte() {}
	
	public boolean mdpEgaux() {
		return motDePasse.equals(confirmerMdp);
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getConfirmerMdp() {
		return confirmerMdp;
	}

	public void setConfirmerMdp(String confirmerMdp) {
		this.confirmerMdp = confirmerMdp;
	}
	
	
}
