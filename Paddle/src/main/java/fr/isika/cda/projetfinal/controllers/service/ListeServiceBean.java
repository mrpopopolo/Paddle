package fr.isika.cda.projetfinal.controllers.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import fr.isika.cda.projetfinal.entity.service.Service;
import fr.isika.cda.projetfinal.service.ServiceService;

@ManagedBean
public class ListeServiceBean {
	
	@Inject
	private ServiceService serviceService;
	
	private List<Service> listeService;
	
	//méthode pour charger la liste automatiquement lorsqu'un service est créé
	
	@PostConstruct
	private void init() {
		listeService= getAllServices();
	}
	
	private List<Service> getAllServices(){
		return this.serviceService.findAll();
		
	}

	public List<Service> getListeService() {
		return listeService;
	}
	
	public String delete(Long id) {
		serviceService.delete(id);
		return "listeService?faces-redirect=true";
	}
	
}
