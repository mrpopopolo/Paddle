package fr.isika.cda.projetfinal.viewmodel;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import fr.isika.cda.projetfinal.entity.service.TypeService;

public class FormService {

	// @NotEmpty(message = "Ne doit pas être vide")
	// @NotNull(message = "Ne doit pas être null")
	// @Size(min = 1, max = 25, message = "Doit être entre 1 et 25 car.")
	// @Pattern(regexp = "[^0-9]*", message = "Ne doit pas contenir des chiffres")

	// @NotEmpty(message = "Ne doit pas être vide")
	// @NotNull(message = "Ne doit pas être null")
	// @Size(min = 1, max = 25, message = "Doit être entre 1 et 25 car.")
	// @Pattern(regexp = "[^0-9]*", message = "Ne doit pas contenir des chiffres")

	private TypeService typeService;

	@NotEmpty(message = "Ne doit pas être vide")
	@NotNull(message = "Ne doit pas être null")
	private String titre;

	@Digits(fraction = 4, integer = 4)
	private BigDecimal prix;

	private LocalDate dateDebut;

	private LocalDate dateFin;

	@NotEmpty(message = "Ne doit pas être vide")
	@NotNull(message = "Ne doit pas être null")
	@Size(min = 1, max = 250, message = "Doit être entre 1 et 250 car.")
	private String description;
	
	private String imageService;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageService() {
		return imageService;
	}

	public void setImageService(String imageService) {
		this.imageService = imageService;
	}

}
