package fr.isika.cda.projetfinal.controllers.copropriete;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import fr.isika.cda.projetfinal.service.CoproService;
import fr.isika.cda.projetfinal.tools.OutilsImage;
import fr.isika.cda.projetfinal.viewmodel.FormCopro;

@ManagedBean
@ViewScoped
public class CreationCoproBean {

	private FormCopro formCopro = new FormCopro();
	
	private Part uploadedFile;

	@Inject
	private CoproService coproService;

	@PostConstruct
	public void init() {
		this.formCopro.setPrenomAdmin("Roger");
		this.formCopro.setNomAdmin("Dubois");
		this.formCopro.setEmailAdmin("roger@gmail.com");
		this.formCopro.setNom("Les Amaryllis");
		this.formCopro.setRue("30 rue de la République");
		this.formCopro.setCodePostal(12345);
		this.formCopro.setVille("Paddle-sur-Mer");
		this.formCopro.setNombreLogements(50);
	}
	
	public String create() throws IOException {
		//UIComponent formulaire = FacesContext.getCurrentInstance().getViewRoot().findComponent("createAccountForm");
		String cheminImage;
		if(uploadedFile != null) {
			cheminImage = OutilsImage.sauvegarderImage(uploadedFile);
			formCopro.setPathToBlason(cheminImage);
		}
		
		coproService.create(formCopro);

		return "connexion";
	}

	public FormCopro getFormCopro() {
		return formCopro;
	}

	public void setFormCopro(FormCopro formCopro) {
		this.formCopro = formCopro;
	}

	public Part getUploadedFile() {
		return uploadedFile;
	}

	public void setUploadedFile(Part uploadedFile) {
		this.uploadedFile = uploadedFile;
	}
}
