package fr.isika.cda.projetfinal.entity.paiement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PaiementLoyer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private int quittanceId;

	public PaiementLoyer() {

	}

	public Long getId() {
		return id;
	}

	public int getQuittanceId() {
		return quittanceId;
	}

	public void setQuittanceId(int quittanceId) {
		this.quittanceId = quittanceId;
	}

}
