package fr.isika.cda.projetfinal.controllers.user;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import fr.isika.cda.projetfinal.entity.user.Utilisateur;
import fr.isika.cda.projetfinal.service.UtilisateurService;

@ManagedBean
public class ListeUtilisateursManagedBean {

	@Inject
	private UtilisateurService utilisateurService;

	private List<Utilisateur> listeUtilisateurs;

	@PostConstruct
	private void init() {
		listeUtilisateurs = getAllUtilisateurs();
	}

	private List<Utilisateur> getAllUtilisateurs() {
		return this.utilisateurService.findAll();
	}

	public List<Utilisateur> getListeUtilisateurs() {
		return listeUtilisateurs;
	}
}
