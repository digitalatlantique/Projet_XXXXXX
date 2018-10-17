package org.oc.escalade.modele;

import javax.persistence.*;

@Entity
@Table(name="membre")
public class Membre  {	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="membre_id")
	private int id;
	
	private String nom;
	private String prenom;
	private String password;
	private String email;
	private boolean compteValide;
	
	public Membre() {
		
	}	
	
	public Membre(String nom, String prenom, String email) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
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
