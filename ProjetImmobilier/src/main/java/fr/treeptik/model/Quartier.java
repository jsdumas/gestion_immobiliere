package fr.treeptik.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Quartier implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue
	private Integer id;
	private String libelleQuartier;
	
	@ManyToOne
	private Commune commune;
	
	public Quartier() {
	}

	
	public Quartier(Integer id, String libelleQuartier, Commune commune) {
		super();
		this.id = id;
		this.libelleQuartier = libelleQuartier;
		this.commune = commune;
	}

	@Override
	public String toString() {
		return "Quartier [id=" + id + ", libelleQuartier=" + libelleQuartier
				+ ", commune=" + commune + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((libelleQuartier == null) ? 0 : libelleQuartier.hashCode());
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
		Quartier other = (Quartier) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (libelleQuartier == null) {
			if (other.libelleQuartier != null)
				return false;
		} else if (!libelleQuartier.equals(other.libelleQuartier))
			return false;
		return true;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getLibelleQuartier() {
		return libelleQuartier;
	}


	public void setLibelleQuartier(String libelleQuartier) {
		this.libelleQuartier = libelleQuartier;
	}


	public Commune getCommune() {
		return commune;
	}


	public void setCommune(Commune commune) {
		this.commune = commune;
	}


}
