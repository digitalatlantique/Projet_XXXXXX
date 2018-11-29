package org.oc.escalade.modele;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="secteur")
public class Secteur {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="secteur_id")
	private int id;
	
	@Column(length=250, nullable=false)
	private String nom;
	
	private int hauteur;
	
	@Column(name="image_path", length=250)
	private String imagePath;
	
	@ManyToOne
	@JoinColumn(name="site_id", nullable=false)
	private Site site;
	
	@OneToMany(mappedBy="secteur") //  
	private Collection<Voie> voies = new HashSet<Voie>();
	
	
	public Secteur() {
	}

	public Secteur(String nom) {
		this.nom = nom;
	}
	
	public Collection<Voie> recupererVoies(){
		return voies;
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

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Collection<Voie> getVoies() {
		return voies;
	}

	public void setVoies(Collection<Voie> voies) {
		this.voies = voies;
	}	

}
