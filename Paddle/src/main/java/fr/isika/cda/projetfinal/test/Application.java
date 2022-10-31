package fr.isika.cda.projetfinal.test;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Entité de test, peut être supprimée plus tard ...
 */
@Entity
public class Application {

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	public Application() {
	}
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
