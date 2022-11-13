package fr.isika.cda.projetfinal.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda.projetfinal.entity.copropriete.Copropriete;
import fr.isika.cda.projetfinal.entity.copropriete.Residence;
import fr.isika.cda.projetfinal.entity.user.Compte;
import fr.isika.cda.projetfinal.entity.user.InfosPerso;
import fr.isika.cda.projetfinal.entity.user.Role;
import fr.isika.cda.projetfinal.entity.user.Utilisateur;
import fr.isika.cda.projetfinal.repositories.copropriete.CoproRepository;
import fr.isika.cda.projetfinal.repositories.user.UtilisateurRepository;
import fr.isika.cda.projetfinal.tools.UserUtils;
import fr.isika.cda.projetfinal.viewmodel.FormCopro;

@Stateless
public class CoproService {

	@Inject
	private CoproRepository coproRepository;
	
	@Inject
	private UtilisateurRepository utilisateurRepository;

	public CoproService() {
	}

	public CoproService(CoproRepository coproRepository) {
		this.coproRepository = coproRepository;
	}

	public Copropriete create(FormCopro formCopro) {
		Copropriete copropriete = new Copropriete();

		Residence residence = new Residence();
		residence.setRue(formCopro.getRue());
		residence.setCodePostal(formCopro.getCodePostal());
		residence.setVille(formCopro.getVille());
		residence.setNom(formCopro.getNom());
		residence.setNombreLogements(formCopro.getNombreLogements());

		copropriete.setResidence(residence);
		copropriete.setPathToBlason(formCopro.getPathToBlason());
		
		Utilisateur admin = new Utilisateur();
		Compte compteAdmin = new Compte();
		InfosPerso infosAdmin = new InfosPerso();
		
		compteAdmin.setEmail(formCopro.getEmailAdmin());
		compteAdmin.setMotDePasse(formCopro.getMotDePasseAdmin());
		compteAdmin.setRole(Role.Admin);
		
		infosAdmin.setNom(formCopro.getNomAdmin());
		infosAdmin.setPrenom(formCopro.getPrenomAdmin());
		
		coproRepository.create(copropriete);
		
		admin.setCompte(compteAdmin);
		admin.setInfosPerso(infosAdmin);
		admin.setCopropriete(copropriete);
		this.utilisateurRepository.create(admin);
		return copropriete;
		
	}

	// Methodes afficher la liste des copropriétés

	public Optional<Copropriete> findById(Long id) {
		return coproRepository.findById(id);
	}

	public List<Copropriete> findAll() {
		return coproRepository.findAll();
	}

	public void delete(long id) {
		coproRepository.delete(id);	
	}

}
