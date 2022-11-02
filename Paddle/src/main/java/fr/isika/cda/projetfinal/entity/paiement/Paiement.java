package fr.isika.cda.projetfinal.entity.paiement;

import java.sql.Date;

import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Paiement {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;


	private Double montant;

	private LocalDate datePaiement;

	private int idPayeur;

	private int idBeneficiaire;


	private String montantPaiement;

	private String formePaiement;

	private Statut statut;

	public Paiement() {

	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}


	

	public LocalDate getDatePaiement() {
		return datePaiement;
	}

	public void setDatePaiement(LocalDate datePaiement) {
		this.datePaiement = datePaiement;

	}

	public int getIdPayeur() {
		return idPayeur;
	}

	public int getIdBeneficiare() {

		return idBeneficiaire;
	}

	public void setIdBeneficiare(int idBeneficiare) {
		this.idBeneficiaire = idBeneficiare;

	}

	public String getMontantPaiement() {
		return montantPaiement;
	}

	public void setMontantPaiement(String montantPaiement) {
		this.montantPaiement = montantPaiement;
	}

	public String getFormePaiement() {
		return formePaiement;
	}

	public void setFormePaiement(String formePaiement) {
		this.formePaiement = formePaiement;
	}

	public Statut getStatut() {
		return statut;
	}

	public void setStatut(Statut statut) {
		this.statut = statut;
	}

}
