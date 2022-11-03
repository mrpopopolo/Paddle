package fr.isika.cda.projetfinal.repositories.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda.projetfinal.entity.service.Service;
import fr.isika.cda.projetfinal.entity.service.TypeService;
import fr.isika.cda.projetfinal.viewmodel.FormService;

@Stateless
public class ServiceRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public Service creer(FormService formService) {

		Service service = new Service();

		service.setTypeService(formService.getTypeService());
		service.setTitre(formService.getTitre());
		service.setPrix(formService.getPrix());
		service.setDateDebut(formService.getDateDebut());
		service.setDateFin(formService.getDateFin());
		service.setDescription(formService.getDescription());
		entityManager.persist(service);
		return service;
	}

	public void initData() {

		Service service = new Service();
		service.setTypeService(TypeService.SERVICE);
		service.setTitre("Cours de soutien ");
		service.setDescription("Je propose des cours de soutien en Maths");

		// Exemples :
		service.setPrix(new BigDecimal(25.00));

		// best way
		service.setPrix(BigDecimal.valueOf(25.00));

		// bigdecimal n'ets pas modifiable donc il faut "copier" à chaque fois
		// Opération
		// BigDecimal x = BigDecimal.valueOf(10.5).add(BigDecimal.valueOf(10));

		service.setDateDebut(LocalDate.of(2022, 11, 02));
		service.setDateFin(LocalDate.of(2023, 03, 01));
		service.setProposeParLaCopro(true);

		entityManager.persist(service);

	}

}
