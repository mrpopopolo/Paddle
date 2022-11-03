package fr.isika.cda.projetfinal.entity.service;

public enum TypeService {
	SERVICE ("Service"),
	MATERIEL ("Matériel en prêt"),
	HEBERGEMENT ("Hébergement temporaire"),
	PARKING ("Place de parking"),
	EVENEMENT ("Évènement");
	
	private String libelle;

	private TypeService(String libelle) {
		this.libelle = libelle;
	}

	public String getLibelle() {
		return libelle;
	}
	

}
