package fr.isika.cda.projetfinal.entity.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import fr.isika.cda.projetfinal.entity.user.Utilisateur;

@Entity
@NamedQuery(name = "Service.findById", query = "SELECT ser FROM Service ser WHERE ser.id = :id_param")
public class Service {
	//******Attributs**********

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String titre;
	private String description;
	private BigDecimal prix;

	private LocalDate dateDebut;
	private LocalDate dateFin;
	private String imageService;
	// private Boolean proposeParLaCopro;// discuter avec les autres pour son
	// implémentation dans creerService


	@ManyToOne
	private Utilisateur createurService;

	@Enumerated(EnumType.STRING)
	private TypeService typeService;
	
	//*****constructeur ********

	public Service() {

	}

		//*******Getter/Setter****************
	
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

	public BigDecimal getPrix() {
		return prix;
	}

	public void setPrix(BigDecimal prix) {
		this.prix = prix;
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

	public Long getId() {
		return id;
	}

	public Utilisateur getCreateurService() {
		return createurService;
	}

	public void setCreateurService(Utilisateur createurService) {
		this.createurService = createurService;
	}
	public String getImageService() {
		return imageService;
	}

	public void setImageService(String imageService) {
		this.imageService = imageService;
	}
}
