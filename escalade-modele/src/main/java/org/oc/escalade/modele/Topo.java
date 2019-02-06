package org.oc.escalade.modele;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

@Entity
@Table(name="topo")
public class Topo implements Serializable {
	
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
	private Collection<Site> sites = new ArrayList<Site>();
	
	@OneToMany(mappedBy="location_id.topo", cascade=CascadeType.ALL)
	private Collection<Location> locations = new ArrayList<Location>();


	public Topo() {
	}	

	public Topo(String libelle, String information, boolean autoriserLocation, Membre membre) {
		this.libelle = libelle;
		this.information = information;
		this.autoriserLocation = autoriserLocation;
		this.membre = membre;
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

	public Collection<Site> getSites() {
		return sites;
	}

	public void setSites(Collection<Site> sites) {
		this.sites = sites;
	}

	public Collection<Location> getLocations() {
		return locations;
	}

	public void setLocations(Collection<Location> locations) {
		this.locations = locations;
	}	
	
}
