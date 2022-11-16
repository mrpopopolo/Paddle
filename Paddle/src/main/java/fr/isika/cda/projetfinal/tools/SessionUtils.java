package fr.isika.cda.projetfinal.tools;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class SessionUtils {

	private static final String CONNECTED_USER_EMAIL = "connectedUserEmail",
								CONNECTED_USER_NAME = "connectedUserName",
								CONNECTED_USER_COPRO = "connectedUserCopro",
								CONNECTED_USER_ROLE = "connectedUserRole",
								CONNECTED_USER_BLASON = "connectedUserBlason";

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
	
	public static void setConnectedUserName(String connectedUserName) {
		HttpSession session = getSession();
		session.setAttribute(CONNECTED_USER_NAME, connectedUserName);
	}
	
	public static String getConnectedUserName() {
		HttpSession session = getSession();
		return (String) session.getAttribute(CONNECTED_USER_NAME);
	}

	public static void setConnectedUserCopro(String connectedUserCopro) {
		HttpSession session = getSession();
		session.setAttribute(CONNECTED_USER_COPRO, connectedUserCopro);
	}
	
	public static String getConnectedUserCopro() {
		HttpSession session = getSession();
		return (String) session.getAttribute(CONNECTED_USER_COPRO);
	}

	public static void setConnectedUserRole(String connectedUserRole) {
		HttpSession session = getSession();
		session.setAttribute(CONNECTED_USER_ROLE, connectedUserRole);
	}
	
	public static String getConnectedUserRole() {
		HttpSession session = getSession();
		return (String) session.getAttribute(CONNECTED_USER_ROLE);
	}
	
	public static void setConnectedUserBlason(String connectedUserBlason) {
		HttpSession session = getSession();
		session.setAttribute(CONNECTED_USER_BLASON, connectedUserBlason);
	}
	
	public static String getConnectedUserBlason() {
		HttpSession session = getSession();
		return (String) session.getAttribute(CONNECTED_USER_BLASON);
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
