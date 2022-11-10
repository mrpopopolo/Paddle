package fr.isika.cda.projetfinal.tools;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Authenticator {

	public String check() {
		if (SessionUtils.isUserConnected()) {
			return null;
		} else {
			return "connexion?faces-redirect=true";
		}
	}

}