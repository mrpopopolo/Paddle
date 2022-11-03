package fr.isika.cda.projetfinal.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda.projetfinal.entity.user.Utilisateur;
import fr.isika.cda.projetfinal.repositories.user.UtilisateurRepository;
import fr.isika.cda.projetfinal.viewmodel.FormCompte;

@Stateless
public class UtilisateurService {
	
	@Inject
	private UtilisateurRepository utilisateurRepository;
	
	public UtilisateurService() {}

	public UtilisateurService(UtilisateurRepository utilisateurRepository) {
		this.utilisateurRepository = utilisateurRepository;
	}



	public Utilisateur create(FormCompte formCompte) {
		return utilisateurRepository.create(formCompte);
	}

}
