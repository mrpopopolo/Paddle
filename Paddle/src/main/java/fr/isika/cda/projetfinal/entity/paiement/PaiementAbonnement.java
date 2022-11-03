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

	// TODO : nommer la variable avec les unités de mesure
	private Integer dureeAbo;

	public PaiementAbonnement() {

	}

	public Long getId() {
		return id;
	}

	public Integer getDureeAbo() {
		return dureeAbo;
	}

	public void setDureeAbo(Integer dureeAbo) {
		this.dureeAbo = dureeAbo;
	}


}
