package fr.isika.cda.projetfinal.repositories.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

//import fr.isika.cda.javaee.login.model.User;
import fr.isika.cda.projetfinal.entity.service.Service;
import fr.isika.cda.projetfinal.entity.service.TypeService;
import fr.isika.cda.projetfinal.viewmodel.FormService;

@Stateless
public class ServiceRepository {

	@PersistenceContext
	private EntityManager entityManager;

	
	public Service creer(Service service) {
		// On persiste l'objet
		entityManager.persist(service);
		return service;
	}

//	public void initData() {
//
//		Service service = new Service();
//		service.setTypeService(TypeService.SERVICE);
//		service.setTitre("Cours de soutien ");
//		service.setDescription("Je propose des cours de soutien en Maths");
//
//		// Exemples :
//		//service.setPrix(new BigDecimal(25.00));
//
//		// best way
//		service.setPrix(BigDecimal.valueOf(25.00));
//
//		// bigdecimal n'ets pas modifiable donc il faut "copier" à chaque fois
//		// Opération
//		// BigDecimal x = BigDecimal.valueOf(10.5).add(BigDecimal.valueOf(10));
//
//		service.setDateDebut(LocalDate.of(2022, 11, 02));
//		service.setDateFin(LocalDate.of(2023, 03, 01));
//		// service.setProposeParLaCopro(true);
//
//		entityManager.persist(service);
//
//	}

	
	public Optional<Service> findById(Long id) {
		try {
			Service service = this.entityManager.createNamedQuery("Service.findById", Service.class)
					.setParameter("id_param", id)
					.getSingleResult();

			return Optional.ofNullable(service);
		} catch (NoResultException ex) {
			System.out.println("ServiceRepository.findById() - not found : " + id);
		}
		return Optional.empty();
	}

	
	public List<Service> findAll() {
		return this.entityManager
				  .createQuery("SELECT acc FROM Service acc", Service.class)
				  .getResultList();
	}
	public void delete(Long id) {
		Service serviceASupprimer = findById(id).get();
		entityManager.remove(serviceASupprimer);
	}

	public void modifier(Service service) {
		entityManager.merge(service);
	}

	public List<Service> findCoproServices(Long coproId) {
		return this.entityManager
				  .createQuery("SELECT ser FROM Service ser where ser.createurService.copropriete.id = "+coproId, Service.class)
				  .getResultList();

	}
	
	public List<Service> findMesServices(Long userId) {
		return this.entityManager
				  .createQuery("SELECT ser FROM Service ser where ser.createurService.id = :user_id_param", Service.class)
				  .setParameter("user_id_param", userId)
				  .getResultList();
	}
	
}
