package fr.isika.cda.projetfinal.entity.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ServiceRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	public void initData() {
		
		Service service= new Service();
		service.setTypeService(TypeService.Service);
		service.setTitre("Cours de soutien ");
		service.setDescription("Je propose des cours de soutien en Maths");
		service.setPrix(25.00);
		service.setDateDebut(LocalDate.of(2022, 11, 02));
		service.setDateFin(LocalDate.of(2023, 03, 01));
		service.setProposeParLaCopro(true);
		entityManager.persist(service);
		
		
	}

}
