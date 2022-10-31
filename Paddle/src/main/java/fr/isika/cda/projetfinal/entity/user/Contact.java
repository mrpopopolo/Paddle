package fr.isika.cda.projetfinal.entity.user;

public class Contact {

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
