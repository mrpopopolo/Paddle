package fr.isika.cda.projetfinal.repositories.user;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda.projetfinal.entity.service.Reservation;
import fr.isika.cda.projetfinal.entity.service.Service;
import fr.isika.cda.projetfinal.entity.user.Compte;
import fr.isika.cda.projetfinal.entity.user.Contact;
import fr.isika.cda.projetfinal.entity.user.InfosLogement;
import fr.isika.cda.projetfinal.entity.user.InfosPerso;
import fr.isika.cda.projetfinal.entity.user.Role;
import fr.isika.cda.projetfinal.entity.user.Utilisateur;
import fr.isika.cda.projetfinal.viewmodel.FormCompte;

@Stateless
public class UtilisateurRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public Utilisateur create(FormCompte formCompte) {

		Utilisateur utilisateur = new Utilisateur();

		InfosPerso infosPerso = new InfosPerso();
		infosPerso.setPrenom(formCompte.getPrenom());
		infosPerso.setNom(formCompte.getNom());

		Compte compte = new Compte();
		compte.setEmail(formCompte.getEmail());
		compte.setMotDePasse(formCompte.getMotDePasse());

		utilisateur.setCompte(compte);
		utilisateur.setInfosPerso(infosPerso);

		entityManager.persist(utilisateur);

		return utilisateur;
	}

	public void initData() {

		Compte compte = new Compte();
		compte.setEmail("compte@gmail.com");
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
		infosPerso.setNom("Dupont");
		infosPerso.setPrenom("Jean");
		infosPerso.setSexe("Homme");
		infosPerso.setDateDeNaissance(LocalDate.of(1965, 10, 22));
		infosPerso.setLieuDeNaissance("Paris");

		Contact contact = new Contact();
		contact.setAdresseContact(infosLogement.getAdresseLogement());
		contact.setNumeroDeTelephone("012345678");

		ArrayList<Service> services = new ArrayList<>();

		ArrayList<Reservation> reservations = new ArrayList<>();

		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setCompte(compte);
		utilisateur.setInfosLogement(infosLogement);
		utilisateur.setInfosPerso(infosPerso);
		utilisateur.setContact(contact);

		entityManager.persist(compte);

		entityManager.persist(utilisateur);

	}

}
