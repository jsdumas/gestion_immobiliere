package fr.treeptik.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Commune implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue
	private Integer id;
	private String nomCommune;
	private String distanceAgence;
	private Integer nombreHabitants;
	
	public Commune() {
		// TODO Auto-generated constructor stub
	}

	public Commune(Integer id, String nomCommune, String distanceAgence,
			Integer nombreHabitants) {
		super();
		this.id = id;
		this.nomCommune = nomCommune;
		this.distanceAgence = distanceAgence;
		this.nombreHabitants = nombreHabitants;
	}

	@Override
	public String toString() {
		return "Commune [id=" + id + ", nomCommune=" + nomCommune
				+ ", distanceAgence=" + distanceAgence + ", nombreHabitants="
				+ nombreHabitants + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((nomCommune == null) ? 0 : nomCommune.hashCode());
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
		Commune other = (Commune) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nomCommune == null) {
			if (other.nomCommune != null)
				return false;
		} else if (!nomCommune.equals(other.nomCommune))
			return false;
		return true;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomCommune() {
		return nomCommune;
	}

	public void setNomCommune(String nomCommune) {
		this.nomCommune = nomCommune;
	}

	public String getDistanceAgence() {
		return distanceAgence;
	}

	public void setDistanceAgence(String distanceAgence) {
		this.distanceAgence = distanceAgence;
	}

	public Integer getNombreHabitants() {
		return nombreHabitants;
	}

	public void setNombreHabitants(Integer nombreHabitants) {
		this.nombreHabitants = nombreHabitants;
	}
	

}
