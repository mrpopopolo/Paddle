package fr.isika.cda.projetfinal.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda.projetfinal.entity.service.Service;
import fr.isika.cda.projetfinal.repositories.service.ServiceRepository;
import fr.isika.cda.projetfinal.viewmodel.FormService;

@Stateless
public class ServiceService {

	@Inject
	private ServiceRepository serviceRepository;

	public ServiceService() {
	}

	public ServiceService(ServiceRepository serviceRepository) {
		this.serviceRepository = serviceRepository;
	}

	public Service creer(FormService formService) {
		return serviceRepository.creer(formService);
	}

	public List<Service> findAll() {
		return serviceRepository.findAll();

	}
}
