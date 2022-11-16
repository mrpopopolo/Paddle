package fr.isika.cda.projetfinal.repositories.user;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import fr.isika.cda.projetfinal.entity.service.Reservation;
import fr.isika.cda.projetfinal.entity.service.Service;
import fr.isika.cda.projetfinal.entity.user.Compte;
import fr.isika.cda.projetfinal.entity.user.Contact;
import fr.isika.cda.projetfinal.entity.user.InfosLogement;
import fr.isika.cda.projetfinal.entity.user.InfosPerso;
import fr.isika.cda.projetfinal.entity.user.Role;
import fr.isika.cda.projetfinal.entity.user.Utilisateur;
import fr.isika.cda.projetfinal.tools.SessionUtils;
import fr.isika.cda.projetfinal.viewmodel.FormCompte;

@Stateless
public class UtilisateurRepository {

	@PersistenceContext
	private EntityManager entityManager;


	public Utilisateur create(Utilisateur utilisateur) {
		entityManager.persist(utilisateur);
		return utilisateur;
	}

//	public void initData() {
//
//		Compte compte = new Compte();
//		compte.setEmail("compte@gmail.com");
//		compte.setMotDePasse("password");
//		compte.setRole(Role.Admin); // Trouver un moyen de set plusieurs rôles
//
//		InfosLogement infosLogement = new InfosLogement();
//		infosLogement.setAdresseLogement("8 rue de la Paix");
//		infosLogement.setTailleLogement(55);
//		infosLogement.setNbrePlaceParking(2);
//		infosLogement.setNbreHabitants(4);
//		infosLogement.setMontantLoyer(BigDecimal.valueOf(600.00));
//		infosLogement.setMontantCharges(BigDecimal.valueOf(60.0));
//
//		InfosPerso infosPerso = new InfosPerso();
//		infosPerso.setNom("Dupont");
//		infosPerso.setPrenom("Jean");
//		infosPerso.setSexe("Homme");
//		infosPerso.setDateDeNaissance(LocalDate.of(1965, 10, 22));
//		infosPerso.setLieuDeNaissance("Paris");
//
//		Contact contact = new Contact();
//		contact.setAdresseContact(infosLogement.getAdresseLogement());
//		contact.setNumeroDeTelephone("012345678");
//
//		ArrayList<Service> services = new ArrayList<>();
//
//		ArrayList<Reservation> reservations = new ArrayList<>();
//
//		Utilisateur utilisateur = new Utilisateur();
//		utilisateur.setCompte(compte);
//		utilisateur.setInfosLogement(infosLogement);
//		utilisateur.setInfosPerso(infosPerso);
//		utilisateur.setContact(contact);
//
//		entityManager.persist(compte);
//
//		entityManager.persist(utilisateur);
//		
//	
//
//	}
	
	// Methodes afficher liste 
	
	public Optional<Utilisateur> findByEmail(final String email) {
		try {
			Utilisateur utilisateur = this.entityManager.createNamedQuery("Utilisateur.findByEmail", Utilisateur.class) 
					.setParameter("email_param", email)
					.getSingleResult();
			
			return Optional.ofNullable(utilisateur);
		} catch (NoResultException ex) {
			System.out.println("AccountRepository.findByEmail() - not found : " + email);
		}
		return Optional.empty();
	}

	public List<Utilisateur> findAll() {
		return this.entityManager
				.createQuery("SELECT acc FROM Utilisateur acc", Utilisateur.class)
				.getResultList();
	}

	public void delete(String email) {
		Utilisateur utilisateurASupprimer = findByEmail(email).get();
		entityManager.remove(utilisateurASupprimer);
		
	}
	
	public void modifier(Utilisateur utilisateur) {
		entityManager.merge(utilisateur);
	}

	public List<Utilisateur> findUsersCopro(Long coproId) {
		return this.entityManager
				.createQuery("SELECT usr FROM Utilisateur usr where usr.copropriete.id  = :copro_id_param", Utilisateur.class)
				.setParameter("copro_id_param", coproId)
				.getResultList();
	}

}
