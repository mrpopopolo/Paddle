package fr.isika.cda.projetfinal.entity.paiement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import fr.isika.cda.projetfinal.entity.service.Reservation;

@Entity
public class PaiementReservation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

//	private int reservationId;
	
	@OneToOne
	private Reservation reservation;

	public PaiementReservation() {

	}

	public Long getId() {
		return id;
	}

	public Reservation getReservation() {
		return reservation;
	}
	
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
}
