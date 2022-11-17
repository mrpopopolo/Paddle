package fr.isika.cda.projetfinal.repositories;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda.projetfinal.entity.copropriete.Copropriete;
import fr.isika.cda.projetfinal.entity.copropriete.Residence;
import fr.isika.cda.projetfinal.entity.paiement.Paiement;
import fr.isika.cda.projetfinal.entity.service.Reservation;
import fr.isika.cda.projetfinal.entity.service.Service;
import fr.isika.cda.projetfinal.entity.service.TypeService;
import fr.isika.cda.projetfinal.entity.user.Compte;
import fr.isika.cda.projetfinal.entity.user.Contact;
import fr.isika.cda.projetfinal.entity.user.InfosLogement;
import fr.isika.cda.projetfinal.entity.user.InfosPerso;
import fr.isika.cda.projetfinal.entity.user.Role;
import fr.isika.cda.projetfinal.entity.user.Utilisateur;

@Singleton
@Startup
public class DemoBean {

	@PersistenceContext
	private EntityManager entityManager;
	
	@PostConstruct
	public void initData() {

		Residence residence = new Residence();
		residence.setRue("rue general Lizé");
		residence.setCodePostal(75000);
		residence.setVille("Paris");
		residence.setNom("Puy Garnier");
		residence.setNombreLogements(1);

		Copropriete copropriete = new Copropriete();
		copropriete.setResidence(residence);
		entityManager.persist(copropriete);
		
		Compte compte = new Compte();
		compte.setEmail("jdupond@gmail.com");
		compte.setMotDePasse("password");
		compte.setRole(Role.Admin); // Trouver un moyen de set plusieurs rôles

		InfosLogement infosLogement = new InfosLogement();
		infosLogement.setAdresseLogement("8 rue de la Paix");
		infosLogement.setTailleLogement(55);
		infosLogement.setNbrePlaceParking(2);
		infosLogement.setNbreHabitants(4);
		infosLogement.setMontantLoyer(BigDecimal.valueOf(600.00));
		infosLogement.setMontantCharges(BigDecimal.valueOf(60.0));

		InfosPerso infosPerso = new InfosPerso();
		infosPerso.setNom("Dupond");
		infosPerso.setPrenom("Jean");
		infosPerso.setSexe("Homme");
		infosPerso.setDateDeNaissance(LocalDate.of(1965, 10, 22));
		infosPerso.setLieuDeNaissance("Paris");

		Contact contact = new Contact();
		contact.setAdresseContact(infosLogement.getAdresseLogement());
		contact.setNumeroDeTelephone("012345678");

		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setCompte(compte);
		utilisateur.setInfosLogement(infosLogement);
		utilisateur.setInfosPerso(infosPerso);
		utilisateur.setContact(contact);
		utilisateur.setCopropriete(copropriete);

		entityManager.persist(utilisateur);
		

		Service service = new Service();
		service.setTypeService(TypeService.SERVICE);
		service.setTitre("Cours de soutien ");
		service.setDescription("Je propose des cours de soutien en Maths");
		service.setPrix(BigDecimal.valueOf(25.00));
		service.setDateEvenement(LocalDate.of(2022, 12, 02));
		service.setImageService("resources/images/coursMath.jpeg");
		service.setCreateurService(utilisateur);
		
		entityManager.persist(service);

		
		Service service2 = new Service();
		service2.setTypeService(TypeService.SERVICE);
		service2.setTitre("Cervelo S5 ");
		service2.setDescription("A vendre, CERVELO S5 ULTEGRA DI2 12V, taille 56. ");
		service2.setPrix(BigDecimal.valueOf(5000.00));
		service2.setDateEvenement(LocalDate.of(2022, 12, 02));
		service2.setImageService("resources/images/velo.JPG");
		service2.setCreateurService(utilisateur);

		entityManager.persist(service2);
		
		Service service3 = new Service();
		service3.setTypeService(TypeService.SERVICE);
		service3.setTitre("Télévision ");
		service3.setDescription("Bonjour, je vends ma TV 32cm. ");
		service3.setPrix(BigDecimal.valueOf(90.00));
		service3.setDateEvenement(LocalDate.of(2022, 1, 17));
		service3.setImageService("resources/images/tv.jpg");
		service3.setCreateurService(utilisateur);

		entityManager.persist(service3);
		

		Service service4 = new Service();
		service4.setTypeService(TypeService.SERVICE);
		service4.setTitre("Aston Martin Vantage 4,7l 426Ch ");
		service4.setDescription("Magnifique Aston Martin V8 Vantage 4,7l, 426Ch, Noir Onyx, intérieur Cuir Obsidian Black. ");
		service4.setPrix(BigDecimal.valueOf(58990.00));
		service4.setDateEvenement(LocalDate.of(2022, 1, 17));
		service4.setImageService("resources/images/aston martin.jpg");
		service4.setCreateurService(utilisateur);

		entityManager.persist(service4);

		Reservation reservation = new Reservation();
		reservation.setDateExecution(LocalDate.of(2022, 12, 02));
		reservation.setReserveur(utilisateur);
		reservation.setServiceReserve(service);
		
		entityManager.persist(reservation);

		
		Paiement paiement = new Paiement();
		//paiement.setBeneficiaire(utilisateur);
		paiement.setDatePaiement(LocalDate.of(2022, 11, 1));
		paiement.setMontant(BigDecimal.valueOf(350.00));
		paiement.setPayeur(utilisateur);

		entityManager.persist(paiement);
		
		
	}
	
}
