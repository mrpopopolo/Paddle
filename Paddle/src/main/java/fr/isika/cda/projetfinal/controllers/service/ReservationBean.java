package fr.isika.cda.projetfinal.controllers.service;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import fr.isika.cda.projetfinal.entity.paiement.Paiement;
import fr.isika.cda.projetfinal.entity.service.Reservation;
import fr.isika.cda.projetfinal.entity.service.Service;
import fr.isika.cda.projetfinal.entity.user.Utilisateur;
import fr.isika.cda.projetfinal.repositories.paiement.PaiementRepository;
import fr.isika.cda.projetfinal.repositories.reservation.ReservationRepository;
import fr.isika.cda.projetfinal.repositories.user.UtilisateurRepository;
import fr.isika.cda.projetfinal.service.ServiceService;
import fr.isika.cda.projetfinal.tools.SessionUtils;

@ManagedBean
@SessionScoped
public class ReservationBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 869102829045686245L;
	
	// ***** Attributs *****
	
	
	@Inject
	private UtilisateurRepository utilisateurRepository;
	
	@Inject
	private PaiementRepository paiementRepository;
	
	@Inject
	private ServiceService serviceService;
	
	@Inject
	private ReservationRepository reservationRepository;
	
	private Service service;
	
	private Utilisateur utilisateur;
	
	private List<Reservation> mesReservations;
	
	private List<Paiement> mesPaiements;
	
	
	@PostConstruct
	private void init() {
		mesReservations = mesReservations();
		mesPaiements = mesPaiements();
	}
	
	public void clear() {
		mesReservations = new ArrayList<Reservation>();
		mesPaiements = new ArrayList<Paiement>();
	}
	public void reload() {
		init();
	}
	
	private List<Reservation> mesReservations(){
		return this.serviceService.mesReservations();	
	}
	
	private List<Paiement> mesPaiements(){
		return this.serviceService.mesPaiements();	
	}
	
	// ***** Getters / setters *****

	public Service getService() {
		return service;
	}
	
	public List<Reservation> getMesReservations() {
		return mesReservations;
	}

	public List<Paiement> getMesPaiements() {
		return mesPaiements;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	
	public String reserver(Service serviceAReserver) {
		service = serviceAReserver;
		String userMail = SessionUtils.getConnectedUserEmail();
		utilisateur = this.utilisateurRepository.findByEmail(userMail).get();
		return "paiement";
	}
	
	public String payer() {
		Reservation reservation = new Reservation();
		reservation.setReserveur(utilisateur);
		reservation.setDateExecution(LocalDate.now());
		reservation.setServiceReserve(service);

		Paiement paiement = new Paiement();

		paiement.setMontant(service.getPrix());
		paiement.setBeneficiaire(service.getCreateurService());
		paiement.setPayeur(utilisateur);
		paiement.setDatePaiement(LocalDate.now());
		
		
		this.paiementRepository.creer(paiement);
		this.reservationRepository.creer(reservation);
		
		// recharger les réservations et les paiements (manuellement)
		reload();
		
		return "index";
	}
	
}
