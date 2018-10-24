package org.oc.escalade.modele;

import javax.persistence.*;

@Entity
@Table(name="voie")
public class Voie {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="voie_id")
	private int id;
	
	@Column(nullable=false)
	private int numero;
	
	@Column(length=250, nullable=false)
	private String nom;
	
	@Column(length=100)
	private String cotation;
	
	@ManyToOne
	@JoinColumn(name="secteur_id", nullable=false)
	private Secteur secteur;
	
	public Voie() {
	}

	public Voie(int numero, String nom, String cotation) {
		this.numero = numero;
		this.nom = nom;
		this.cotation = cotation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}	

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
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

	public Secteur getSecteur() {
		return secteur;
	}

	public void setSecteur(Secteur secteur) {
		this.secteur = secteur;
	}
	
		

}
