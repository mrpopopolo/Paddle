package fr.isika.cda.projetfinal.entity.paiement;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import fr.isika.cda.projetfinal.entity.user.Utilisateur;

@Entity
public class Paiement {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private BigDecimal montant;

	private LocalDate datePaiement;

	@ManyToOne
	@JoinColumn(name = "utilisateur_id")
	private Utilisateur payeur;

	@OneToOne
	private Utilisateur beneficiaire;

//	private String motifPaiement;
//
//	private String formePaiement;
//
//	@Enumerated(EnumType.STRING)
//	private Statut statut;

	public Paiement() {

	}

	public BigDecimal getMontant() {
		return montant;
	}

	public void setMontant(BigDecimal montant) {
		this.montant = montant;
	}

	public LocalDate getDatePaiement() {
		return datePaiement;
	}

	public void setDatePaiement(LocalDate datePaiement) {
		this.datePaiement = datePaiement;
	}

	public Utilisateur getPayeur() {
		return payeur;
	}

	public void setPayeur(Utilisateur payeur) {
		this.payeur = payeur;
	}

	public Utilisateur getBeneficiaire() {
		return beneficiaire;
	}

	public void setBeneficiaire(Utilisateur beneficiaire) {
		this.beneficiaire = beneficiaire;
	}

	public Long getId() {
		return id;
	}


}
