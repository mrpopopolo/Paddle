package fr.isika.cda.projetfinal.controllers.service;

import java.util.Optional;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import fr.isika.cda.projetfinal.entity.service.Service;
import fr.isika.cda.projetfinal.repositories.service.ServiceRepository;

@ManagedBean
@SessionScoped
public class AfficherService {
	
	@Inject
	private ServiceRepository serviceRepo;
	
	private Service service;

	public Service getService() {
		return service;
	}
	
	public String afficher(Long id) {
		Optional<Service> optional = serviceRepo.findById(id);
		if (optional.isPresent()) {
			service = optional.get();
			return "pageAnnonce.xhtml";
		}
		return "index.xhtml";
	}

}
