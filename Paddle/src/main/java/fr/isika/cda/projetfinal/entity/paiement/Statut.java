package fr.isika.cda.projetfinal.entity.paiement;

public enum Statut {
	
	CREE ("Crée"), 
	PAYE ("Payé"), 
	RETARD ("Retard"), 
	IMPAYE ("Impayé"), 
	ANNULE ("Annulé"), 
	REMBOURSE ("Remboursé")
	;
	
	private String libelle;
	
	private Statut(String libelle) {
		this.libelle = libelle;
	}
	
	public String getLibelle() {
		return libelle;
	}
}
