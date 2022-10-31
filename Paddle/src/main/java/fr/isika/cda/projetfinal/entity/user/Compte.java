package fr.isika.cda.projetfinal.entity.user;

import java.util.List;

public class Compte {

	private Long id;
	private String email;
	private String motDePasse;
	private List<Role> roles;

	public Compte() {

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

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

}
