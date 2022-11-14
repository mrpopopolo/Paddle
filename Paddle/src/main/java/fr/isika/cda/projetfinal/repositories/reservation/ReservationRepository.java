package fr.isika.cda.projetfinal.repositories.reservation;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda.projetfinal.entity.service.Reservation;

@Stateless
public class ReservationRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	public Reservation creer(Reservation reservation) {
		entityManager.persist(reservation);
		return reservation;
	}
}
