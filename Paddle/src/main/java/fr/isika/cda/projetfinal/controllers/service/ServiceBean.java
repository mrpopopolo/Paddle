package fr.isika.cda.projetfinal.controllers.service;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import fr.isika.cda.projetfinal.repositories.service.ServiceRepository;

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
