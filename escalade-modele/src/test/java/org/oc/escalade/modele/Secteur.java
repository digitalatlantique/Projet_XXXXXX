package org.oc.escalade.modele;

public class Secteur {
	
	private int id;
	private String nom;
	private int hauteur;
	
	
	public Secteur() {
	}


	public Secteur(String nom) {
		this.nom = nom;
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


	public int getHauteur() {
		return hauteur;
	}


	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}

	

}
