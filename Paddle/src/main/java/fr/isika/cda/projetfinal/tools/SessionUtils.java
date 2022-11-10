package fr.isika.cda.projetfinal.tools;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class SessionUtils {

	private static final String CONNECTED_USER_EMAIL = "connectedUserEmail";

	/*
	 * 
	 */

	public static boolean isUserConnected() {
		return getConnectedUserEmail() != null;
	}
	
	public static void setConnectedUserEmail(String connectedUserEmail) {
		HttpSession session = getSession();
		session.setAttribute(CONNECTED_USER_EMAIL, connectedUserEmail);
	}

	public static String getConnectedUserEmail() {
		HttpSession session = getSession();
		return (String) session.getAttribute(CONNECTED_USER_EMAIL);
	}

	public static void viderSession() {
		HttpSession session = getSession();
		session.invalidate();
	}
	
	/*
	 * 
	 */
	
	private static HttpSession getSession() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		return session;
	}
	
}
