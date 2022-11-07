package fr.isika.cda.projetfinal.service;

import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda.projetfinal.entity.copropriete.Copropriete;
import fr.isika.cda.projetfinal.entity.user.Utilisateur;
import fr.isika.cda.projetfinal.repositories.copropriete.CoproRepository;

import fr.isika.cda.projetfinal.viewmodel.FormCopro;

@Stateless
public class CoproService {

	@Inject
	private CoproRepository coproRepository;

	public CoproService() {
	}

	public CoproService(CoproRepository coproRepository) {
		this.coproRepository = coproRepository;
	}

	public Copropriete create(FormCopro formCopro) {
		return coproRepository.create(formCopro);
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
