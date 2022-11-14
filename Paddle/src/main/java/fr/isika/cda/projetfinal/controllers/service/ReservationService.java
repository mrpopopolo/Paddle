package fr.isika.cda.projetfinal.controllers.service;

import java.time.LocalDate;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import fr.isika.cda.projetfinal.entity.service.Reservation;
import fr.isika.cda.projetfinal.entity.service.Service;
import fr.isika.cda.projetfinal.entity.user.Utilisateur;
import fr.isika.cda.projetfinal.repositories.service.ServiceRepository;
import fr.isika.cda.projetfinal.repositories.user.UtilisateurRepository;
import fr.isika.cda.projetfinal.service.ServiceService;
import fr.isika.cda.projetfinal.service.UtilisateurService;
import fr.isika.cda.projetfinal.tools.SessionUtils;

@ManagedBean
public class ReservationService {

	// ***** Attributs *****
	@Inject
	private ServiceRepository serviceRepository;
	@Inject
	private UtilisateurRepository utilisateurRepository;
	
	private Service service;
	
	private Utilisateur utilisateur;
	
	
	// ***** Getters / setters *****

	public Service getService() {
		return service;
	}

	public ServiceRepository getServiceRepository() {
		return serviceRepository;
	}

	public void setServiceRepository(ServiceRepository serviceRepository) {
		this.serviceRepository = serviceRepository;
	}

	public UtilisateurRepository getUtilisateurRepository() {
		return utilisateurRepository;
	}

	public void setUtilisateurRepository(UtilisateurRepository utilisateurRepository) {
		this.utilisateurRepository = utilisateurRepository;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public void setService(Service service) {
		this.service = service;
	}
	
	
	public String reserver(Service service) {
		// System.err.println(id);
		// Service serviceAReserver = serviceRepository.findById(id).get();
		Reservation reservation = new Reservation(service, LocalDate.now());
		String userMail = SessionUtils.getConnectedUserEmail();
		Utilisateur utilisateurQuiReserve = this.utilisateurRepository.findByEmail(userMail).get();
		utilisateurQuiReserve.ajouterReservation(reservation);
		utilisateurRepository.modifier(utilisateurQuiReserve);
		return "index";
		
	}
	
	
}
