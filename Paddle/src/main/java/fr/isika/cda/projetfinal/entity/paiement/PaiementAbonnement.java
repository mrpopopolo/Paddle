package fr.isika.cda.projetfinal.entity.paiement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PaiementAbonnement {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private int dureeAbo;

	public PaiementAbonnement() {

	}

	public Long getId() {
		return id;
	}

	public int getDureeAbo() {
		return dureeAbo;
	}

	public void setDureeAbo(int dureeAbo) {
		this.dureeAbo = dureeAbo;
	}

}
