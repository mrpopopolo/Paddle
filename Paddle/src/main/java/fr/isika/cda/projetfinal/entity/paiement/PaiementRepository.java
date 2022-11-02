package fr.isika.cda.projetfinal.entity.paiement;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PaiementRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void initData() {
		Paiement paiement = new Paiement();
			paiement.setMontant(200);
			paiement.setDatePaiement(LocalDate.of(1,11,2022));
			paiement.setMotifPaiement("facture");
			paiement.setFormePaiement("Virement");
			paiement.setStatut(Statut.Crée);
			
			
		PaiementAbonnement paiementAbonnement = new PaiementAbonnement();
			paiementAbonnement.setDureeAbo(4);
			
		
		PaiementLoyer paiementLoyer = new PaiementLoyer();
		//	paiementLoyer.setQuittance();
		
		PaiementReservation paiementReservation = new PaiementReservation();
		
		entityManager.persist(paiement);
		
				
	}
	
}
