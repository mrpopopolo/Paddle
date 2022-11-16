package fr.isika.cda.projetfinal.repositories.paiement;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda.projetfinal.entity.paiement.Paiement;

@Stateless
public class PaiementRepository {

	@PersistenceContext
	private EntityManager entityManager;

//	public void initData() {
//		Paiement paiement = new Paiement();
//		paiement.setMontant(200);
//		paiement.setDatePaiement(LocalDate.of(2022, 11, 1));
//		paiement.setMotifPaiement("facture");
//		paiement.setFormePaiement("Virement");
//		paiement.setStatut(Statut.CREE);
//
//		PaiementAbonnement paiementAbonnement = new PaiementAbonnement();
//		paiementAbonnement.setDureeAbo(4);
//
//		// PaiementLoyer paiementLoyer = new PaiementLoyer();
//		// paiementLoyer.setQuittance();
//
//		// PaiementReservation paiementReservation = new PaiementReservation();
//
//		entityManager.persist(paiement);
//
//	}
	
	public Paiement creer(Paiement paiement) {
		entityManager.persist(paiement);
		return paiement;
	}
	
	public List<Paiement> findMesPaiements(Long userId) {
		return this.entityManager
				  .createQuery("SELECT paye FROM Paiement paye WHERE paye.payeur.id = :user_id_param", Paiement.class)
				  .setParameter("user_id_param", userId)
				  .getResultList();

	}

}
