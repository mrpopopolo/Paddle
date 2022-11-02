package fr.isika.cda.projetfinal.entity.copropriete;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class TestCoproRepository {
	
		@PersistenceContext
		private EntityManager entityManager;
		
		public void test() {
			MembreSyndic membreSyndic= new MembreSyndic();
			membreSyndic.setNom("MBA");
			membreSyndic.setPrenom("Arsène");
			membreSyndic.setFonction("Admin");
			//entityManager.persist(membreSyndic);
			
			Residence residence= new Residence();
			residence.setAdresse("rue general Lizé");
			residence.setNom("Puy Garnier");
			residence.setNombreLogements(1);
			//entityManager.persist(residence);
			
			Copropriete copropriete= new Copropriete();
			copropriete.setMembreSyndic(membreSyndic);
			copropriete.setResidence(residence);
			entityManager.persist(copropriete);
			
		}
}
