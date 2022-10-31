package fr.isika.cda.projetfinal.test;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class TestRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void test() {
		Application application = new Application();
		application.setName("Paddle :: 0.0.1-SNAPSHOT");
		entityManager.persist(application);
	}
	
}
