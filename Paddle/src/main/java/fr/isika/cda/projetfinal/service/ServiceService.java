package fr.isika.cda.projetfinal.service;

import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda.projetfinal.entity.service.Service;
import fr.isika.cda.projetfinal.entity.user.Utilisateur;
import fr.isika.cda.projetfinal.repositories.service.ServiceRepository;
import fr.isika.cda.projetfinal.repositories.user.UtilisateurRepository;
import fr.isika.cda.projetfinal.tools.SessionUtils;
import fr.isika.cda.projetfinal.viewmodel.FormService;

@Stateless
public class ServiceService {

	@Inject
	private ServiceRepository serviceRepository;
	
	@Inject
	private UtilisateurRepository utilisateurRepository;

	public ServiceService() {
	}

	public ServiceService(ServiceRepository serviceRepository) {
		this.serviceRepository = serviceRepository;
	}

	public Service creer(FormService formService) {
		Service service = new Service();
		
		service.setTypeService(formService.getTypeService());
		service.setTitre(formService.getTitre());
		service.setPrix(formService.getPrix());
		service.setDateEvenement(formService.getDateEvenement());
		service.setDescription(formService.getDescription());
		service.setImageService(formService.getImageService());

		String userMail = SessionUtils.getConnectedUserEmail();
		Utilisateur createurService = this.utilisateurRepository.findByEmail(userMail).get();
		createurService.ajouterService(service);
		
		this.utilisateurRepository.modifier(createurService);
		
		service.setCreateurService(createurService);
		return serviceRepository.creer(service);
	}
	

	public List<Service> findAll() {
		return serviceRepository.findAll();
	}
	
	public Optional<Service> findById(Long id){
		return serviceRepository.findById(id);
	}
	
	public void delete(Long id) {
		serviceRepository.delete(id);
	}
	
	public void modifier(Service service) {
		serviceRepository.modifier(service);
	}
	
	public List<Service> servicesDeMaCopro() {
		if(SessionUtils.isUserConnected()) {
			String userMail = SessionUtils.getConnectedUserEmail();
			Utilisateur demandeurService = this.utilisateurRepository.findByEmail(userMail).get();
			return serviceRepository.findCoproServices(demandeurService.getCopropriete().getId());
		}
		return null;
	}
}
