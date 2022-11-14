package fr.isika.cda.projetfinal.entity.service;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import fr.isika.cda.projetfinal.entity.user.Utilisateur;

@Entity
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne
	private Service serviceReserve;
	
	@ManyToOne
	@JoinColumn(name = "utilisateur_id")
	private Utilisateur reserveur;
	
	private LocalDate dateExecution;
	// attribut paiment de la reservation (voir avec les autres)

	public Reservation() {

	}
	
	

	public Reservation(Service serviceReserve, LocalDate dateExecution) {
		super();
		this.serviceReserve = serviceReserve;
		this.dateExecution = dateExecution;
	}



	public Service getServiceReserve() {
		return serviceReserve;
	}

	public void setServiceReserve(Service serviceReserve) {
		this.serviceReserve = serviceReserve;
	}

	public LocalDate getDateExecution() {
		return dateExecution;
	}

	public void setDateExecution(LocalDate dateExecution) {
		this.dateExecution = dateExecution;
	}

	public Long getId() {
		return id;
	}

	public Utilisateur getReserveur() {
		return reserveur;
	}

	public void setReserveur(Utilisateur reserveur) {
		this.reserveur = reserveur;
	}

}
