package fr.isika.cda.projetfinal.entity.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contact {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String adresseContact;
	private String numeroDeTelephone;

	public Contact() {

	}

	public String getAdresseContact() {
		return adresseContact;
	}

	public void setAdresseContact(String adresseContact) {
		this.adresseContact = adresseContact;
	}

	public String getNumeroDeTelephone() {
		return numeroDeTelephone;
	}

	public void setNumeroDeTelephone(String numeroDeTelephone) {
		this.numeroDeTelephone = numeroDeTelephone;
	}

	public Long getId() {
		return id;
	}

}
