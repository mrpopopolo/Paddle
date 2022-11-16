package fr.isika.cda.projetfinal.repositories.reservation;

import java.util.List;

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
	
	public List<Reservation> findMesReservations(Long userId) {
		return this.entityManager
				  .createQuery("SELECT res FROM Reservation res LEFT JOIN FETCH res.reserveur WHERE res.reserveur.id = :user_id_param", Reservation.class)
				  .setParameter("user_id_param", userId)
				  .getResultList();

	}
}
