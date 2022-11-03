package fr.isika.cda.projetfinal.controllers.copropriete;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import fr.isika.cda.projetfinal.service.CoproService;
import fr.isika.cda.projetfinal.viewmodel.FormCopro;

@ManagedBean
@ViewScoped
public class CreationCoproBean {

	private FormCopro formCopro = new FormCopro();

	@Inject
	private CoproService coproService;

	public String create() {
		UIComponent formulaire = FacesContext.getCurrentInstance().getViewRoot().findComponent("createAccountForm");

		try {
			coproService.create(formCopro);
		} catch (Error e) {
		}

		return "index";

	}

	public FormCopro getFormCopro() {
		return formCopro;
	}

	public void setFormCopro(FormCopro formCopro) {
		this.formCopro = formCopro;
	}
}
