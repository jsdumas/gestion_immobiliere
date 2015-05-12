package fr.treeptik.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Logement implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;
	private String numeroRue;
	private String nomRue;
	private Integer superficie;
	private boolean estDispo;
	private Double loyer;
	@ManyToOne
	private Individu proprietaire;
	@ManyToOne
	private TypeLogement typeLogement;
	@ManyToOne
	private Quartier quartier;

	@ElementCollection
	private Set<Date> datesAnnonce;
	@ElementCollection
	private Set<Date> datesDebutLocation;

	public Logement() {
		// TODO Auto-generated constructor stub
	}

	public Logement(Integer id, String numeroRue, String nomRue,
			Integer superficie, boolean estDispo, Double loyer,
			Individu proprietaire, TypeLogement typeLogement, Quartier quartier) {
		super();
		this.id = id;
		this.numeroRue = numeroRue;
		this.nomRue = nomRue;
		this.superficie = superficie;
		this.estDispo = estDispo;
		this.loyer = loyer;
		this.proprietaire = proprietaire;
		this.typeLogement = typeLogement;
		this.quartier = quartier;
	}

	@Override
	public String toString() {
		return "Logement [id=" + id + ", numeroRue=" + numeroRue + ", nomRue="
				+ nomRue + ", superficie=" + superficie + ", estDispo="
				+ estDispo + ", loyer=" + loyer + ", proprietaire="
				+ proprietaire + ", typeLogement=" + typeLogement
				+ ", quartier=" + quartier + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nomRue == null) ? 0 : nomRue.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Logement other = (Logement) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nomRue == null) {
			if (other.nomRue != null)
				return false;
		} else if (!nomRue.equals(other.nomRue))
			return false;
		return true;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumeroRue() {
		return numeroRue;
	}

	public void setNumeroRue(String numeroRue) {
		this.numeroRue = numeroRue;
	}

	public String getNomRue() {
		return nomRue;
	}

	public void setNomRue(String nomRue) {
		this.nomRue = nomRue;
	}

	public Integer getSuperficie() {
		return superficie;
	}

	public void setSuperficie(Integer superficie) {
		this.superficie = superficie;
	}

	public boolean isEstDispo() {
		return estDispo;
	}

	public void setEstDispo(boolean estDispo) {
		this.estDispo = estDispo;
	}

	public Double getLoyer() {
		return loyer;
	}

	public void setLoyer(Double loyer) {
		this.loyer = loyer;
	}

	public Individu getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Individu proprietaire) {
		this.proprietaire = proprietaire;
	}

	public TypeLogement getTypeLogement() {
		return typeLogement;
	}

	public void setTypeLogement(TypeLogement typeLogement) {
		this.typeLogement = typeLogement;
	}

	public Quartier getQuartier() {
		return quartier;
	}

	public void setQuartier(Quartier quartier) {
		this.quartier = quartier;
	}

	public Set<Date> getDatesAnnonce() {
		return datesAnnonce;
	}

	public void setDatesAnnonce(Set<Date> datesAnnonce) {
		this.datesAnnonce = datesAnnonce;
	}

	public Set<Date> getDatesDebutLocation() {
		return datesDebutLocation;
	}

	public void setDatesDebutLocation(Set<Date> datesDebutLocation) {
		this.datesDebutLocation = datesDebutLocation;
	}

}
