package fr.isika.cda.projetfinal.repositories.copropriete;

import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import fr.isika.cda.projetfinal.entity.copropriete.Copropriete;
import fr.isika.cda.projetfinal.entity.copropriete.MembreSyndic;
import fr.isika.cda.projetfinal.entity.copropriete.Residence;
import fr.isika.cda.projetfinal.entity.user.Utilisateur;
import fr.isika.cda.projetfinal.viewmodel.FormCopro;

@Stateless
public class CoproRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public Copropriete create(Copropriete copropriete) {
		entityManager.persist(copropriete);
		return copropriete;
	}

//	public void initData() {
//		MembreSyndic membreSyndic = new MembreSyndic();
//		membreSyndic.setNom("MBA");
//		membreSyndic.setPrenom("Arsène");
//		membreSyndic.setFonction("Admin");
//
//		Residence residence = new Residence();
//		residence.setRue("rue general Lizé");
//		residence.setCodePostal(75000);
//		residence.setVille("Paris");
//		residence.setNom("Puy Garnier");
//		residence.setNombreLogements(1);
//
//		Copropriete copropriete = new Copropriete();
//		copropriete.setResidence(residence);
//		entityManager.persist(copropriete);
//
//	}

	// Methodes afficher liste

	public Optional<Copropriete> findById(final Long id) {
		try {
			Copropriete copropriete = this.entityManager.createNamedQuery("Copropriete.findById", Copropriete.class)
					.setParameter("id_param", id).getSingleResult();

			return Optional.ofNullable(copropriete);
		} catch (NoResultException ex) {
			System.out.println("CoproRepository.findById() - not found : " + id);
		}
		return Optional.empty();
	}

	public List<Copropriete> findAll() {
		return this.entityManager.createQuery("SELECT copro FROM Copropriete copro", Copropriete.class).getResultList();
	}

	// Methode supprimer
	public void delete(long id) {
		Copropriete coproprieteASupprimer = findById(id).get();
		entityManager.remove(coproprieteASupprimer);
	}

}
