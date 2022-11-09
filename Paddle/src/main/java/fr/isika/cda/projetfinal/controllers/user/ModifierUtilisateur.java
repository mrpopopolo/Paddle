package fr.isika.cda.projetfinal.controllers.user;

import java.io.Serializable;
import java.util.Optional;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import fr.isika.cda.projetfinal.entity.user.Utilisateur;
import fr.isika.cda.projetfinal.repositories.user.UtilisateurRepository;

@ManagedBean
@SessionScoped
public class ModifierUtilisateur implements Serializable{

	private static final long serialVersionUID = -9076083639506972969L;

	@Inject
	private UtilisateurRepository utilisateurRepository;
	
	private Utilisateur utilisateur;
	
	
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public String modifier(String email) {
		//Map<String,String> map = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		//Long serviceID = Long.valueOf(map.get("serviceId"));
		//System.out.println(serviceID);
		Optional<Utilisateur> optional = utilisateurRepository.findByEmail(email);
		if(optional.isPresent()) {
			utilisateur = optional.get();
			return "modifierUtilisateur.xhtml";
		}
		return "listeService.xhtml";
	}
	
	public String modifier(Utilisateur utilisateurModifie) {
		utilisateurRepository.modifier(utilisateurModifie);
		return "listeUtilisateurs.xhtml";
	}
}
