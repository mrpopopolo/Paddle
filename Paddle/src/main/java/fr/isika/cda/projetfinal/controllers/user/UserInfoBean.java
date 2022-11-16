package fr.isika.cda.projetfinal.controllers.user;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.isika.cda.projetfinal.tools.SessionUtils;

@ManagedBean
@SessionScoped
public class UserInfoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3887454863290541064L;

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
	
	public String getBlason() {
		String blason = SessionUtils.getConnectedUserBlason();
		if(blason == null) {
			blason = "resources/images/copro2.jpeg";
		}
		return blason;
	}
}
