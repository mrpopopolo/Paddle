package fr.isika.cda.projetfinal.controllers.copropriete;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import fr.isika.cda.projetfinal.repositories.copropriete.CoproRepository;

@ManagedBean
@Singleton
@Startup
public class CoproBean {
	
	@Inject
	private CoproRepository repository;
	
	private String msg;
	
	@PostConstruct
	private void init() {
		msg="Copropriete est prête";
		repository.initData();
		
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	

}
