package fr.isika.cda.projetfinal.entity.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import fr.isika.cda.projetfinal.entity.copropriete.Copropriete;
import fr.isika.cda.projetfinal.entity.paiement.Paiement;
import fr.isika.cda.projetfinal.entity.service.Reservation;
import fr.isika.cda.projetfinal.entity.service.Service;

@Entity
@NamedQuery(name = "Utilisateur.findByEmail", query = "SELECT ua FROM Utilisateur ua WHERE ua.compte.email = :email_param")
public class Utilisateur {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne(cascade = CascadeType.ALL)
	private Compte compte;

	@OneToOne (cascade = CascadeType.ALL)
	private InfosLogement infosLogement;

	@OneToOne (cascade = CascadeType.ALL)
	private InfosPerso infosPerso;

	@OneToOne (cascade = CascadeType.ALL)
	private Contact contact;

	@OneToMany (mappedBy = "createurService")
	private List<Service> services;

	@OneToMany (mappedBy = "reserveur")
	private List<Reservation> reservations;
	
	@OneToMany  (mappedBy = "payeur")
	private List<Paiement> paiements;
	
	@ManyToOne
	@JoinColumn(name = "copropriete_id")
	private Copropriete copropriete;

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

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Copropriete getCopropriete() {
		return copropriete;
	}

	public void setCopropriete(Copropriete copropriete) {
		this.copropriete = copropriete;
	}

	public Long getId() {
		return id;
	}
	
	public void ajouterService(Service service) {
		this.services.add(service);
	}

	public void ajouterReservation(Reservation reservation) { // voir avec Mohammed 
		this.reservations.add(reservation);
	}
	
}
