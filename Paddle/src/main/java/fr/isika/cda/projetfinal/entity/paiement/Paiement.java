package fr.isika.cda.projetfinal.entity.paiement;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Paiement {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private double montant;

	private Date date;

	private int idPayeur;

	private int idBeneficiare;

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getIdPayeur() {
		return idPayeur;
	}

	public int getIdBeneficiare() {
		return idBeneficiare;
	}

	public void setIdBeneficiare(int idBeneficiare) {
		this.idBeneficiare = idBeneficiare;
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
