package fr.isika.cda.projetfinal.repositories.paiement;

import java.time.LocalDate;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda.projetfinal.entity.paiement.Paiement;
import fr.isika.cda.projetfinal.entity.paiement.PaiementAbonnement;
import fr.isika.cda.projetfinal.entity.paiement.Statut;

@Stateless
public class PaiementRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public void initData() {
		Paiement paiement = new Paiement();
		paiement.setMontant(200);
		paiement.setDatePaiement(LocalDate.of(2022, 11, 1));
		paiement.setMotifPaiement("facture");
		paiement.setFormePaiement("Virement");
		paiement.setStatut(Statut.CREE);

		PaiementAbonnement paiementAbonnement = new PaiementAbonnement();
		paiementAbonnement.setDureeAbo(4);

		// PaiementLoyer paiementLoyer = new PaiementLoyer();
		// paiementLoyer.setQuittance();

		// PaiementReservation paiementReservation = new PaiementReservation();

		entityManager.persist(paiement);

	}

}
