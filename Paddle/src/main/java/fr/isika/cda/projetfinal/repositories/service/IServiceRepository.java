package fr.isika.cda.projetfinal.repositories.service;

import java.util.List;
import java.util.Optional;

import fr.isika.cda.projetfinal.entity.service.Service;
import fr.isika.cda.projetfinal.viewmodel.FormService;

public interface IServiceRepository {

	Service creer(Service service);

	List<Service> findAll();

	Optional<Service> findByTitre(final String titre);

}
