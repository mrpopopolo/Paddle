package fr.isika.cda.projetfinal.service;

import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda.projetfinal.entity.user.Utilisateur;
import fr.isika.cda.projetfinal.repositories.user.UtilisateurRepository;
import fr.isika.cda.projetfinal.tools.UserUtils;
import fr.isika.cda.projetfinal.viewmodel.FormCompte;

@Stateless
public class UtilisateurService {
	
	@Inject
	private UtilisateurRepository utilisateurRepository;
	
	public UtilisateurService() {}

	public Utilisateur create(FormCompte formCompte) {
		String motDePasseCrypte = UserUtils.encodePassword(formCompte.getMotDePasse());
		formCompte.setMotDePasse(motDePasseCrypte);
		return utilisateurRepository.create(formCompte);
	}

	// Methodes afficher la liste des utilisateurs 
	
	public Optional<Utilisateur> findByEmail(String email) {
		return utilisateurRepository.findByEmail(email);
	}

	public List<Utilisateur> findAll() {
		return utilisateurRepository.findAll();
	}

	public void delete(String email) {
		utilisateurRepository.delete(email);
		
	}

	public void modifier(Utilisateur utilisateur) {
		utilisateurRepository.modifier(utilisateur);
		// TODO Auto-generated method stub
		
	}

	
}
