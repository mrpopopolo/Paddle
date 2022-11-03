package fr.isika.cda.projetfinal.repositories.copropriete;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda.projetfinal.entity.copropriete.Copropriete;
import fr.isika.cda.projetfinal.entity.copropriete.MembreSyndic;
import fr.isika.cda.projetfinal.entity.copropriete.Residence;

@Stateless
public class CoproRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public void initData() {
		MembreSyndic membreSyndic = new MembreSyndic();
		membreSyndic.setNom("MBA");
		membreSyndic.setPrenom("Arsène");
		membreSyndic.setFonction("Admin");

		Residence residence = new Residence();
		residence.setAdresse("rue general Lizé");
		residence.setNom("Puy Garnier");
		residence.setNombreLogements(1);

		Copropriete copropriete = new Copropriete();
		copropriete.setResidence(residence);
		entityManager.persist(copropriete);

	}
}
