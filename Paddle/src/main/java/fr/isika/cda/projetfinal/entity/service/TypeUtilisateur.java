package fr.isika.cda.projetfinal.entity.service;

public enum TypeUtilisateur {
	FOURNISSEUR ("Fournisseur"),
	DEMANDEUR ("Demandeur");
	
	private String libelle;

	private TypeUtilisateur(String libelle) {
		this.libelle = libelle;
	}

	public String getLibelle() {
		return libelle;
	}
	

}
