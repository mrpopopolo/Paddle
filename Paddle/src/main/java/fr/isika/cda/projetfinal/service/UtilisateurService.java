package fr.isika.cda.projetfinal.service;

import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda.projetfinal.entity.copropriete.Copropriete;
import fr.isika.cda.projetfinal.entity.service.Service;
import fr.isika.cda.projetfinal.entity.user.Compte;
import fr.isika.cda.projetfinal.entity.user.Contact;
import fr.isika.cda.projetfinal.entity.user.InfosLogement;
import fr.isika.cda.projetfinal.entity.user.InfosPerso;
import fr.isika.cda.projetfinal.entity.user.Role;
import fr.isika.cda.projetfinal.entity.user.Utilisateur;
import fr.isika.cda.projetfinal.repositories.user.UtilisateurRepository;
import fr.isika.cda.projetfinal.tools.SessionUtils;
import fr.isika.cda.projetfinal.viewmodel.FormCompte;

@Stateless
public class UtilisateurService {
	
	@Inject
	private UtilisateurRepository utilisateurRepository;
	
	public UtilisateurService() {}

	public Utilisateur create(FormCompte formCompte) {
		Utilisateur utilisateur = new Utilisateur();

		InfosPerso infosPerso = new InfosPerso();
		infosPerso.setPrenom(formCompte.getPrenom());
		infosPerso.setNom(formCompte.getNom());

		Compte compte = new Compte();
		compte.setEmail(formCompte.getEmail());
		//String motDePasseCrypte = UserUtils.encodePassword(formCompte.getMotDePasse());
		compte.setMotDePasse(formCompte.getMotDePasse());
		compte.setRole(Role.User);

		Contact contact = new Contact();
		InfosLogement infosLogement = new InfosLogement();
		utilisateur.setCompte(compte);
		utilisateur.setInfosPerso(infosPerso);
		utilisateur.setContact(contact);
		utilisateur.setInfosLogement(infosLogement);
		
		String adminMail = SessionUtils.getConnectedUserEmail();
		if(adminMail != null) {
			Optional<Utilisateur> optional = findByEmail(adminMail);
			if(optional.isPresent()) {
				Utilisateur admin = optional.get();
				Copropriete copropriete = admin.getCopropriete();
				utilisateur.setCopropriete(copropriete);
			}
		}
		return utilisateurRepository.create(utilisateur);
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

	public List<Utilisateur> utilisateursDeMaCopro() {
		if(SessionUtils.isUserConnected()) {
			String userMail = SessionUtils.getConnectedUserEmail();
			Optional<Utilisateur> optional = this.utilisateurRepository.findByEmail(userMail);
			if(optional.isPresent()) {
				Utilisateur demandeurService = optional.get();
				if(demandeurService.getCopropriete() != null) {
					return utilisateurRepository.findUsersCopro(demandeurService.getCopropriete().getId());
				}
			}
		}
		return null;
	}
	
}
