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
	
	private List<Service> mesServices;
	
	
	
	//méthode pour charger la liste automatiquement lorsqu'un service est créé
	
	@PostConstruct
	private void init() {
		listeService = getAllServices();
		mesServices = mesServices();
	}
	
	private List<Service> getAllServices(){
		return this.serviceService.servicesDeMaCopro();
		
	}

	private List<Service> mesServices(){
		return this.serviceService.mesServices();	
	}
	
	
	
	public List<Service> getListeService() {
		return listeService;
	}
	public void setListeService(List<Service> listeService) {
		this.listeService = listeService;
	}
	
	public String delete(Long id) {
		serviceService.delete(id);
		return "listeService?faces-redirect=true";
	}
	
	public String modifier(Long id) {
		return "modifierService?serviceId="+id;
	}

	public List<Service> getMesServices() {
		return mesServices;
	}
	
	
 /*	public String reserver(Long id) {
		// récuperer l'utilisateur + utiliser l'attribut listeResevation pour lui ajouter le service 
		listeReservation.add(new Reservation(serviceService.findById(id).get(),LocalDate.now()));
		return "listeService"; // return vers la liste des services réservés pas l'utilisateur 
	}
	*/ 
	
}
