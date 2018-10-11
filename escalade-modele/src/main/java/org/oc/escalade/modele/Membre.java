package org.oc.escalade.modele;

import javax.inject.Named;

@Named
public class Membre {
	
	private int id;
	private String nom;
	private String prenom;
	private String password;
	private String email;
	private boolean compteValide;
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
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isCompteValide() {
		return compteValide;
	}
	public void setCompteValide(boolean compteValide) {
		this.compteValide = compteValide;
	}
	
	

}
