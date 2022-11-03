package fr.isika.cda.projetfinal.entity.paiement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Quittance {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

}
