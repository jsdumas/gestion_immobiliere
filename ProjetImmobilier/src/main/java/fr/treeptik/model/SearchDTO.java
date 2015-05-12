package fr.treeptik.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String commune;
	private String quartier;
	private Double prixMin;
	private Double prixMax;
	
	public SearchDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getCommune() {
		return commune;
	}

	public void setCommune(String commune) {
		this.commune = commune;
	}

	public String getQuartier() {
		return quartier;
	}

	public void setQuartier(String quartier) {
		this.quartier = quartier;
	}

	public Double getPrixMin() {
		return prixMin;
	}

	public void setPrixMin(Double prixMin) {
		this.prixMin = prixMin;
	}

	public Double getPrixMax() {
		return prixMax;
	}

	public void setPrixMax(Double prixMax) {
		this.prixMax = prixMax;
	}
	
}
