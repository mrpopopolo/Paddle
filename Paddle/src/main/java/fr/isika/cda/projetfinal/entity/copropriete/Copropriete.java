package fr.isika.cda.projetfinal.entity.copropriete;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import fr.isika.cda.projetfinal.entity.user.Utilisateur;

@Entity
@NamedQuery(name = "Copropriete.findById", query = "SELECT copro FROM Copropriete copro WHERE copro.id = :id_param")
public class Copropriete {

	// ***** Variables *****

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Lob
	private String pathToBlason;

	@OneToMany
	private List<MembreSyndic> membreSyndic;

	@OneToOne
	private IdentiteVisuelle identiteVisuelle;

	@OneToOne
	private ActualitesCopro actualitesCopro;

	@OneToOne(cascade = CascadeType.ALL)
	private Residence residence;

	@OneToOne
	private PackageCopro packageChoisi;
	
	@OneToMany (mappedBy = "copropriete")
	private List<Utilisateur> utilisateurs;
	
	@OneToOne
	private Utilisateur adminCopro;

	// ***** Constructeur *****

	public Copropriete() {
	}

	// ***** Getters / Setters *****

	public IdentiteVisuelle getIdentiteVisuelle() {
		return identiteVisuelle;
	}

	public String getPathToBlason() {
		return pathToBlason;
	}

	public void setPathToBlason(String pathToBlason) {
		this.pathToBlason = pathToBlason;
	}

	public List<MembreSyndic> getMembreSyndic() {
		return membreSyndic;
	}

	public void setMembreSyndic(List<MembreSyndic> membreSyndic) {
		this.membreSyndic = membreSyndic;
	}

	public void setIdentiteVisuelle(IdentiteVisuelle identiteVisuelle) {
		this.identiteVisuelle = identiteVisuelle;
	}

	public ActualitesCopro getActualitesCopro() {
		return actualitesCopro;
	}

	public void setActualitesCopro(ActualitesCopro actualitesCopro) {
		this.actualitesCopro = actualitesCopro;
	}

	public Residence getResidence() {
		return residence;
	}

	public void setResidence(Residence residence) {
		this.residence = residence;
	}

	public PackageCopro getPackageChoisi() {
		return packageChoisi;
	}

	public void setPackageChoisi(PackageCopro packageChoisi) {
		this.packageChoisi = packageChoisi;
	}

	public List<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	public Utilisateur getAdminCopro() {
		return adminCopro;
	}

	public void setAdminCopro(Utilisateur adminCopro) {
		this.adminCopro = adminCopro;
	}

	public Long getId() {
		return id;
	}
	
	public void ajouterUtilisateur(Utilisateur utilisateur) {
		this.utilisateurs.add(utilisateur);
	}

}
