package fr.isika.cda.projetfinal.controllers.service;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import fr.isika.cda.projetfinal.service.ServiceService;
import fr.isika.cda.projetfinal.viewmodel.FormService;

@ManagedBean
@ViewScoped
public class CreationServiceBean {
	
	private FormService formService= new FormService();
	
	@Inject
	private ServiceService serviceService;
	
	public String creer() {
		UIComponent formulaire = FacesContext.getCurrentInstance().getViewRoot().findComponent("creerServiceForm");
	
		try {
			serviceService.creer(formService);  
		} catch (Error e) {
		}

		return "index";
	}
	
	public FormService getFormService() {
		return formService;
	}
	public void setFormService(FormService formService) {
		this.formService = formService;
	}

}
