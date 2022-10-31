package fr.isika.cda.projetfinal.test;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

@ManagedBean
@Singleton
@Startup
public class WelcomeBean {

	@Inject
	private TestRepository repository;
	
	private String status;
	
	@PostConstruct
	private void init() {
		status = "Application Paddle is up and running ...";
		repository.test();
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
