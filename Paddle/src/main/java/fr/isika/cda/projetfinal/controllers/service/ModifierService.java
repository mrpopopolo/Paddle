package fr.isika.cda.projetfinal.controllers.service;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;
import java.util.Optional;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.Part;

import fr.isika.cda.projetfinal.entity.service.Service;
import fr.isika.cda.projetfinal.entity.service.TypeService;
import fr.isika.cda.projetfinal.repositories.service.ServiceRepository;
import fr.isika.cda.projetfinal.tools.OutilsImage;

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

	private Part uploadedFile;

	private TypeService[] typesService;

	public String modifier(Long id) {
		Optional<Service> optional = serviceRepo.findById(id);
		if (optional.isPresent()) {
			service = optional.get();
			return "modifierService.xhtml";
		}
		return "listeService.xhtml";
	}

	public String modifier(Service serviceModifie) throws IOException {
		if (uploadedFile != null) {
			String cheminImage = OutilsImage.sauvegarderImage(uploadedFile);
			serviceModifie.setImageService(cheminImage);
		}
		serviceRepo.modifier(serviceModifie);
		return "mesAnnonces.xhtml";
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Part getUploadedFile() {
		return uploadedFile;
	}

	public void setUploadedFile(Part uploadedFile) {
		this.uploadedFile = uploadedFile;
	}

	public void setTypesService(TypeService[] typesService) {
		this.typesService = typesService;
	}

	public TypeService[] getTypesService() {
		return TypeService.values();
	}
}
