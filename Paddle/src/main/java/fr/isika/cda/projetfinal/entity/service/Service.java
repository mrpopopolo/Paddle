package fr.isika.cda.projetfinal.entity.service;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Service {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String titre;
	private String description;
	private Double prix;
	private Integer fournisseurId;
	private Integer demandeurId;
	private LocalDate dateDebut;
	private LocalDate dateFin;
	private Boolean proposeParLaCopro;

	@Enumerated(EnumType.STRING)
	private TypeService typeService;

	public Service() {

	}

	public TypeService getTypeService() {
		return typeService;
	}

	public void setTypeService(TypeService typeService) {
		this.typeService = typeService;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public Integer getFournisseurId() {
		return fournisseurId;
	}

	public void setFournisseurId(Integer fournisseurId) {
		this.fournisseurId = fournisseurId;
	}

	public Integer getDemandeurId() {
		return demandeurId;
	}

	public void setDemandeurId(Integer demandeurId) {
		this.demandeurId = demandeurId;
	}

	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	public Boolean getProposeParLaCopro() {
		return proposeParLaCopro;
	}

	public void setProposeParLaCopro(Boolean proposeParLaCopro) {
		this.proposeParLaCopro = proposeParLaCopro;
	}

	public Long getId() {
		return id;
	}

}
