package fr.isika.cda.projetfinal.controllers.user;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import fr.isika.cda.projetfinal.repositories.user.UtilisateurRepository;

@ManagedBean
@Singleton
@Startup
public class UtilisateurBean {

	@Inject
	private UtilisateurRepository repository;

	private String msg;

	@PostConstruct
	private void init() {
		msg = "Utilisateur est prêt";
		repository.initData();

	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
