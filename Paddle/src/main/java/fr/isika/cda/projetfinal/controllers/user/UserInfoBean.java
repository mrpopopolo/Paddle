package fr.isika.cda.projetfinal.controllers.user;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.isika.cda.projetfinal.tools.SessionUtils;

@ManagedBean
@SessionScoped
public class UserInfoBean {

	public String getUserMail() {
		return SessionUtils.getConnectedUserEmail();
	}
	
	public String getUserName() {
		return SessionUtils.getConnectedUserName();
	}
	
	public String getUserCopro() {
		return SessionUtils.getConnectedUserCopro();
	}
	
	public String getUserRole() {
		return SessionUtils.getConnectedUserRole();
	}
}
