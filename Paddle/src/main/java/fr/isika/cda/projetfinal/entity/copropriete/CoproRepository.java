package fr.isika.cda.projetfinal.entity.copropriete;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CoproRepository {
	
		@PersistenceContext
		private EntityManager entityManager;
		
		public void initData() {
			MembreSyndic membreSyndic= new MembreSyndic();
			membreSyndic.setNom("MBA");
			membreSyndic.setPrenom("Arsène");
			membreSyndic.setFonction("Admin");
			
			Residence residence= new Residence();
			residence.setAdresse("rue general Lizé");
			residence.setNom("Puy Garnier");
			residence.setNombreLogements(1);
			
			Copropriete copropriete= new Copropriete();
			copropriete.setResidence(residence);
			entityManager.persist(copropriete);
			
		}
}
