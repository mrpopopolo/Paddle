package fr.isika.cda.projetfinal.entity.user;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import fr.isika.cda.projetfinal.entity.service.Reservation;
import fr.isika.cda.projetfinal.entity.service.Service;

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

	@OneToMany
	private List<Service> services;

	@OneToMany
	private List<Reservation> reservations;

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
