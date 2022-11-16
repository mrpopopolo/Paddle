package fr.isika.cda.projetfinal.controllers.user;

import java.util.Base64;
import java.util.Optional;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import fr.isika.cda.projetfinal.controllers.service.ReservationBean;
import fr.isika.cda.projetfinal.entity.user.Utilisateur;
import fr.isika.cda.projetfinal.service.UtilisateurService;
import fr.isika.cda.projetfinal.tools.SessionUtils;
import fr.isika.cda.projetfinal.tools.UserUtils;


@ManagedBean
public class LoginBean {

	@Inject
	private UtilisateurService utilisateurService;

	@Inject
	private ReservationBean reservationBean;
	
	@NotEmpty(message = "Ne doit pas être vide")
	@NotNull(message = "Ne doit pas être null")
	@Email
	private String email;

	@NotEmpty(message = "Ne doit pas être vide")
	@NotNull(message = "Ne doit pas être null")
	@Size(min = 1, max = 25, message = "Doit être entre 1 et 25 car.")
	private String motDePasse;

	private String utilisateurConnecte = "";

	public boolean isUserConnected() {
		return SessionUtils.isUserConnected();
	}
	
	public String doLogout() {
		reservationBean.clear();
		SessionUtils.viderSession();
		return "landing";
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getUtilisateurConnecte() {
		return utilisateurConnecte;
	}

	public void setUtilisateurConnecte(String utilisateurConnecte) {
		this.utilisateurConnecte = utilisateurConnecte;
	}

	public String doLogin() {
		Optional<Utilisateur> optional = utilisateurService.findByEmail(email);
		if (optional.isPresent()) {

			Utilisateur utilisateur = optional.get();
			if (utilisateur.getCompte().getEmail().equals(email)
					&& utilisateur.getCompte().getMotDePasse().equals(motDePasse)) {

				// Si même email et mot de passe -> On redirige vers une autre page
				utilisateurConnecte = utilisateur.getCompte().getEmail();
				
				SessionUtils.setConnectedUserEmail(utilisateurConnecte);
				SessionUtils.setConnectedUserCopro(utilisateur.getCopropriete().getResidence().getNom());
				SessionUtils.setConnectedUserName(utilisateur.getInfosPerso().getPrenom());
				SessionUtils.setConnectedUserRole(utilisateur.getCompte().getRole().toString());
				SessionUtils.setConnectedUserBlason(utilisateur.getCopropriete().getPathToBlason());
				
				return "index";
			} else {
				// En cas d'erreur on ajoute des messages au formulaire pour indiquer l'erreur
				// une bonne pratique est de toujours dire identifiants incorrects sans
				// préciser si c'est un login erroné ou password erroné pour
				// des questions de sécurité
				UIComponent formulaire = FacesContext.getCurrentInstance().getViewRoot().findComponent("loginForm");
				FacesContext.getCurrentInstance().addMessage(formulaire.getClientId(),
						new FacesMessage("Identifiants incorrects"));
			}
		} else {
			// Si le user n'existe pas du tout -> on affiche l'erreur dans le formulaire de
			// login
			UIComponent formulaire = FacesContext.getCurrentInstance().getViewRoot().findComponent("loginForm");
			FacesContext.getCurrentInstance().addMessage(formulaire.getClientId(),
					new FacesMessage("Utilisateur non reconnu"));
		}

		// Si erreurs de saisie -> on reste sur la même page
		return "connexion";
	}
}
