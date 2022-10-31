package fr.isika.cda.projetfinal.entity.copropriete;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ActualitesCopro {

	// ***** Variables *****

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String actualites;

	private String notification;

	// ***** Constructeur *****

	public ActualitesCopro() {

	}

	// ***** Getters / Setters

	public String getActualites() {
		return actualites;
	}

	public void setActualites(String actualites) {
		this.actualites = actualites;
	}

	public String getNotification() {
		return notification;
	}

	public void setNotification(String notification) {
		this.notification = notification;
	}

	public Long getId() {
		return id;
	}

}
