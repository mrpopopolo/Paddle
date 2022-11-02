package fr.isika.cda.projetfinal.entity.service;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@ManagedBean
@Singleton
@Startup
public class ServiceBean {
	
	@Inject
	private ServiceRepository repository;
	
	@PostConstruct
	private void init() {
		
		repository.initData();
		
	}
	

}
