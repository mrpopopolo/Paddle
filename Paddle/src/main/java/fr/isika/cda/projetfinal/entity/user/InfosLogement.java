package fr.isika.cda.projetfinal.entity.user;

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
	private Double montantLoyer;
	private Double montantCharges;
	
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

	public Double getMontantLoyer() {
		return montantLoyer;
	}

	public void setMontantLoyer(Double montantLoyer) {
		this.montantLoyer = montantLoyer;
	}

	public Double getMontantCharges() {
		return montantCharges;
	}

	public void setMontantCharges(Double montantCharges) {
		this.montantCharges = montantCharges;
	}

	public Long getId() {
		return id;
	}

}
