package org.oc.escalade.modele;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.*;

@Entity
@Table(name="membre", uniqueConstraints=@UniqueConstraint(columnNames= {"nom", "prenom"}))
public class Membre implements Serializable {	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="membre_id")
	private int id;
	
	@Column(length=250, nullable=false)
	private String nom;
	
	@Column(length=250, nullable=false)
	private String prenom;
	
	@Column(length=250, nullable=false)
	private String password;
	
	@Column(length=250, nullable=false)
	private String email;
	
	@Column(name="compte_valide", nullable=false)
	private boolean compteValide;
	
	@OneToMany(mappedBy="membre")
	private Collection<Site> sites = new HashSet<Site>();
	
	@OneToMany(mappedBy="membre")
	private Collection<Topo> topos = new HashSet<Topo>();
	
	@OneToMany(mappedBy="location_id.membre", cascade = CascadeType.ALL)
	private Collection<Location> locations = new ArrayList<Location>();
	
	public Membre() {
		
	}	
	
	public Membre(String nom, String prenom, String email, String password) {

		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
	}
	
	public void ajouterSite(Site site) {
		site.setMembre(this);
		sites.add(site);
	}
	
	public Collection<Site> recupererSites(){
		return sites;
	}
	
	public void ajouterTopo(Topo topo) {
		topo.setMembre(this);
		topos.add(topo);
	}
	
	public Collection<Topo> recupererTopo(){
		return topos;
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

	public Collection<Site> getSites() {
		return sites;
	}

	public void setSites(Collection<Site> sites) {
		this.sites = sites;
	}

	public Collection<Topo> getTopos() {
		return topos;
	}

	public void setTopos(Collection<Topo> topos) {
		this.topos = topos;
	}

	public Collection<Location> getLocations() {
		return locations;
	}

	public void setLocations(Collection<Location> locations) {
		this.locations = locations;
	}
	
	
}
