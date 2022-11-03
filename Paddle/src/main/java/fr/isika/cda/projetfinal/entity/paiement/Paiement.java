package fr.isika.cda.projetfinal.entity.paiement;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

	private Integer idPayeur;

	private Integer idBeneficiaire;

	private String motifPaiement;

	private String formePaiement;

	@Enumerated(EnumType.STRING)
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

	public String getMotifPaiement() {
		return motifPaiement;
	}

	public void setMotifPaiement(String motifPaiement) {
		this.motifPaiement = motifPaiement;
	}

}
