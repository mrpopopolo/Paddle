package fr.isika.cda.projetfinal.service;

import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.isika.cda.projetfinal.entity.paiement.Paiement;
import fr.isika.cda.projetfinal.entity.service.Reservation;
import fr.isika.cda.projetfinal.entity.service.Service;
import fr.isika.cda.projetfinal.entity.user.Utilisateur;
import fr.isika.cda.projetfinal.repositories.paiement.PaiementRepository;
import fr.isika.cda.projetfinal.repositories.reservation.ReservationRepository;
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
	
	@Inject
	private ReservationRepository reservationRepository;
	
	@Inject
	private PaiementRepository paiementRepository;

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
		service.setEstUneDemande(formService.getEstUneDemande());

		String userMail = SessionUtils.getConnectedUserEmail();
		Optional<Utilisateur> optional = this.utilisateurRepository.findByEmail(userMail);
		if(optional.isPresent()) {
			Utilisateur createurService = optional.get();
			createurService.ajouterService(service);
			this.utilisateurRepository.modifier(createurService);
			service.setCreateurService(createurService);
		}
		return serviceRepository.creer(service);
	}
	

	public List<Service> findAll() {
		return serviceRepository.findAll();
	}
	
	public Optional<Service> findById(Long id){
		return serviceRepository.findById(id);
	}
	
	public void delete(Long id) {
		List<Reservation> reservations = reservationRepository.findAll();
		for(Reservation reservation: reservations) {
			if(reservation.getServiceReserve().getId() == id) {
				reservation.setServiceReserve(null);
				reservationRepository.modifier(reservation);
			}
		}
		serviceRepository.delete(id);
	}
	
	public void modifier(Service service) {
		serviceRepository.modifier(service);
	}
	
	public List<Service> servicesDeMaCopro() {
		if(SessionUtils.isUserConnected()) {
			String userMail = SessionUtils.getConnectedUserEmail();
			Optional<Utilisateur> optional = this.utilisateurRepository.findByEmail(userMail);
			if(optional.isPresent()) {
				Utilisateur demandeurService = optional.get();
				if(demandeurService.getCopropriete() != null) {
					return serviceRepository.findCoproServices(demandeurService.getCopropriete().getId());
				}
			}
		}
		return null;
	}
	
	public List<Service> mesServices() {
		if(SessionUtils.isUserConnected()) {
			String userMail = SessionUtils.getConnectedUserEmail();
			Optional<Utilisateur> optional = this.utilisateurRepository.findByEmail(userMail);
			if(optional.isPresent()) {
				Utilisateur utilisateurConnect = optional.get();
				return serviceRepository.findMesServices(utilisateurConnect.getId());  
			}
		}
		return null;
	}
	
	public List<Reservation> mesReservations() {
		if(SessionUtils.isUserConnected()) {
			String userMail = SessionUtils.getConnectedUserEmail();
			Optional<Utilisateur> optional = this.utilisateurRepository.findByEmail(userMail);
			if(optional.isPresent()) {
				Utilisateur utilisateurConnect = optional.get();
				return reservationRepository.findMesReservations(utilisateurConnect.getId());  
			}
		}
		return null;
	}
	
	public List<Paiement> mesPaiements() {
		if(SessionUtils.isUserConnected()) {
			String userMail = SessionUtils.getConnectedUserEmail();
			Optional<Utilisateur> optional = this.utilisateurRepository.findByEmail(userMail);
			if(optional.isPresent()) {
				Utilisateur utilisateurConnect = optional.get();
				return paiementRepository.findMesPaiements(utilisateurConnect.getId());  
			}
		}
		return null;
	}
}
