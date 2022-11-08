package fr.isika.cda.projetfinal.controllers.service;

import java.io.Serializable;
import java.util.Map;
import java.util.Optional;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import fr.isika.cda.projetfinal.entity.service.Service;
import fr.isika.cda.projetfinal.repositories.service.ServiceRepository;

@ManagedBean
@SessionScoped
public class ModifierService implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9076083639506972969L;

	@Inject
	private ServiceRepository serviceRepo;
	
	private Service service;
	
	public String modifier(Long id) {
		//Map<String,String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		//Long serviceID = Long.valueOf(map.get("serviceId"));
		//System.out.println(serviceID);
		Optional<Service> optional = serviceRepo.findById(id);
		if(optional.isPresent()) {
			service = optional.get();
			return "modifierService.xhtml";
		}
		return "listeService.xhtml";
	}
	
	public String modifier(Service serviceModifie) {
		serviceRepo.modifier(serviceModifie);
		return "listeService.xhtml";
	}

	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
}
