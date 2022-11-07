package fr.isika.cda.projetfinal.controllers.service;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.Part;

import fr.isika.cda.projetfinal.service.ServiceService;
import fr.isika.cda.projetfinal.tools.OutilsImage;
import fr.isika.cda.projetfinal.viewmodel.FormService;

@ManagedBean
@ViewScoped
public class CreationServiceBean {

	@Inject
	private ServiceService serviceService;

	private FormService formService = new FormService();
	
	private Part uploadedFile;

	public String creer() throws IOException {
		UIComponent formulaire = FacesContext.getCurrentInstance().getViewRoot().findComponent("creerServiceForm");
		
		String cheminImage = OutilsImage.sauvegarderImage(uploadedFile);
		formService.setImageService(cheminImage);
		
			serviceService.creer(formService);
		

		return "index";
	}

	public FormService getFormService() {
		return formService;
	}

	public void setFormService(FormService formService) {
		this.formService = formService;
	}

	public Part getUploadedFile() {
		return uploadedFile;
	}

	public void setUploadedFile(Part uploadedFile) {
		this.uploadedFile = uploadedFile;
	}

}
