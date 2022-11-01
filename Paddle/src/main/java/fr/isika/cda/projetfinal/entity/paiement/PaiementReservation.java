package fr.isika.cda.projetfinal.entity.paiement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PaiementReservation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private int reservationId;

	public PaiementReservation() {

	}

	public Long getId() {
		return id;
	}

	public int getReservationId() {
		return reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

}
