package fr.isika.cda.projetfinal.controllers.copropriete;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import fr.isika.cda.projetfinal.entity.copropriete.Copropriete;
import fr.isika.cda.projetfinal.service.CoproService;

@ManagedBean
public class ListeCoproManagedBean {

	@Inject
	private CoproService coproService;

	private List<Copropriete> listeCopros;

	@PostConstruct
	private void init() {
		listeCopros = getAllCopros();
	}

	private List<Copropriete> getAllCopros() {
		return this.coproService.findAll();
	}

	public List<Copropriete> getListeCopros() {
		return listeCopros;
	}
	
	public String delete(long id) {
		coproService.delete(id);
		return "listeCopro?faces-redirect=true";
	}

}
