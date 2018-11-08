package org.oc.escalade.modele;

import java.util.Collection;

import javax.persistence.*;

@Entity
@Table(name="topo")
public class Topo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="topo_id")
	private int id;
	
	@Column(length=250, nullable=false)
	private String libelle;
	
	@Column(length=1000, nullable=false)
	private String information;
	
	@Column(name="autoriser_location", nullable=false)
	private boolean autoriserLocation;
	
	@ManyToOne
	@JoinColumn(name="membre_id", nullable=false)
	private Membre membre;
	
	@ManyToMany
	@JoinColumn(name="site_id")
	private Collection<Site> sites;
	
	@OneToMany(mappedBy="topo")
	private Collection<Location> locations;


	public Topo() {
	}	

	public Topo(String libelle, String information, boolean autoriserLocation) {
		this.libelle = libelle;
		this.information = information;
		this.autoriserLocation = autoriserLocation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public boolean isAutoriserLocation() {
		return autoriserLocation;
	}

	public void setAutoriserLocation(boolean autoriserLocation) {
		this.autoriserLocation = autoriserLocation;
	}



	public Membre getMembre() {
		return membre;
	}



	public void setMembre(Membre membre) {
		this.membre = membre;
	}
	
	
	
	

}
