package fr.isika.cda.projetfinal.entity.copropriete;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@ManagedBean
@Singleton
@Startup
public class CoproBean {
	
	@Inject
	private TestCoproRepository repository;
	
	private String msg;
	
	@PostConstruct
	private void init() {
		msg="Copropriete est prête";
		repository.test();
		
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	

}
