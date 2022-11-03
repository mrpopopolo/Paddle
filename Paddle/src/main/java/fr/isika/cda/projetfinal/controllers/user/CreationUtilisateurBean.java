package fr.isika.cda.projetfinal.controllers.user;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import fr.isika.cda.projetfinal.service.UtilisateurService;
import fr.isika.cda.projetfinal.viewmodel.FormCompte;

@ManagedBean
@ViewScoped
public class CreationUtilisateurBean {

	private FormCompte formCompte = new FormCompte();

	@Inject
	private UtilisateurService utilisateurService;

	public String create() {
		UIComponent formulaire = FacesContext.getCurrentInstance().getViewRoot().findComponent("createAccountForm");

		try {
			utilisateurService.create(formCompte);
		} catch (Error e) {
		}

		return "index";

	}

	public FormCompte getFormCompte() {
		return formCompte;
	}

	public void setFormCompte(FormCompte formCompte) {
		this.formCompte = formCompte;
	}

}
