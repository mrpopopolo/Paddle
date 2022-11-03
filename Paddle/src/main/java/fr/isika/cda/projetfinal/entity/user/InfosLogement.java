package fr.isika.cda.projetfinal.entity.user;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class InfosLogement {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String adresseLogement;
	private Integer tailleLogement;
	private Integer nbrePlaceParking;
	private Integer nbreHabitants;
	private BigDecimal montantLoyer;
	private BigDecimal montantCharges;
	
	public InfosLogement() {
		
	}

	public String getAdresseLogement() {
		return adresseLogement;
	}

	public void setAdresseLogement(String adresseLogement) {
		this.adresseLogement = adresseLogement;
	}

	public Integer getTailleLogement() {
		return tailleLogement;
	}

	public void setTailleLogement(Integer tailleLogement) {
		this.tailleLogement = tailleLogement;
	}

	public Integer getNbrePlaceParking() {
		return nbrePlaceParking;
	}

	public void setNbrePlaceParking(Integer nbrePlaceParking) {
		this.nbrePlaceParking = nbrePlaceParking;
	}

	public Integer getNbreHabitants() {
		return nbreHabitants;
	}

	public void setNbreHabitants(Integer nbreHabitants) {
		this.nbreHabitants = nbreHabitants;
	}

	public BigDecimal getMontantCharges() {
		return montantCharges;
	}
	public void setMontantCharges(BigDecimal montantCharges) {
		this.montantCharges = montantCharges;
	}
	public BigDecimal getMontantLoyer() {
		return montantLoyer;
	}
	public void setMontantLoyer(BigDecimal montantLoyer) {
		this.montantLoyer = montantLoyer;
	}

	public Long getId() {
		return id;
	}

}
