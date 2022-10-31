package fr.isika.cda.projetfinal.entity.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Utilisateur {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	private Compte compte;
	
	@OneToOne
	private InfosLogement infosLogement;
	
	@OneToOne
	private InfosPerso infosPerso;
	
	@OneToOne
	private Contact contact;

	public Utilisateur() {

	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public InfosLogement getInfosLogement() {
		return infosLogement;
	}

	public void setInfosLogement(InfosLogement infosLogement) {
		this.infosLogement = infosLogement;
	}

	public InfosPerso getInfosPerso() {
		return infosPerso;
	}

	public void setInfosPerso(InfosPerso infosPerso) {
		this.infosPerso = infosPerso;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Long getId() {
		return id;
	}

}
