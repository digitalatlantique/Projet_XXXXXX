package org.oc.escalade.modele;

public class Voie {
	
	private int id;
	private String nom;
	private String cotation;
	
	public Voie() {
	}

	public Voie(String nom, String cotation) {
		this.nom = nom;
		this.cotation = cotation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCotation() {
		return cotation;
	}

	public void setCotation(String cotation) {
		this.cotation = cotation;
	}
	
		

}
