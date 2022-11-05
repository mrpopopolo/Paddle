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

	@Inject
	private ServiceService serviceService;

	private FormService formService = new FormService();

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
