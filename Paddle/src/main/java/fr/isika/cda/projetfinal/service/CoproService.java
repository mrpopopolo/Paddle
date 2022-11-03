package fr.isika.cda.projetfinal.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda.projetfinal.entity.copropriete.Copropriete;

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

}
