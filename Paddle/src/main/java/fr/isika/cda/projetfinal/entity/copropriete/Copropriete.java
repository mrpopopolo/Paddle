package fr.isika.cda.projetfinal.entity.copropriete;

import java.io.File;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Copropriete {

	// ***** Variables *****

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	
	private File blason;

	@OneToOne(cascade = CascadeType.ALL)
	private MembreSyndic membreSyndic;

	@OneToOne
	private IdentiteVisuelle identiteVisuelle;

	@OneToOne
	private ActualitesCopro actualitesCopro;

	@OneToOne(cascade = CascadeType.ALL)
	private Residence residence;

	@OneToOne
	private Package packageChoisi;

	// ***** Constructeur *****

	public Copropriete() {

	}

	// ***** Getters / Setters *****

	public File getBlason() {
		return blason;
	}

	public void setBlason(File blason) {
		this.blason = blason;
	}

	public MembreSyndic getMembreSyndic() {
		return membreSyndic;
	}

	public void setMembreSyndic(MembreSyndic membreSyndic) {
		this.membreSyndic = membreSyndic;
	}

	public IdentiteVisuelle getIdentiteVisuelle() {
		return identiteVisuelle;
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

	public Package getPackageChoisi() {
		return packageChoisi;
	}

	public void setPackageChoisi(Package packageChoisi) {
		this.packageChoisi = packageChoisi;
	}

	public Long getId() {
		return id;
	}

}
