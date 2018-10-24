package org.oc.escalade.modele;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="site")
public class Site {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="site_id")
	private int id;
	
	@Column(length=250, nullable=false)
	private String nom;
	
	@Column(length=1000, nullable=false)
	private String presentation;
	
	@Column(length=250, nullable=false)
	private String localite;
	
	@Column(name="code_postal", length=50, nullable=false)
	private String codePostal;
	
	@Column(name="hauteur_min")
	private int hauteurMin;
	
	@Column(name="hauteur_max")
	private int hauteurMax;
	
	@Column(name="image_path", length=250)
	private String imagePath;
	
	@OneToMany(mappedBy="site", cascade = CascadeType.ALL)
	private Collection<Commentaire> commentaires = new ArrayList<Commentaire>();
	
	@OneToMany(mappedBy="site", cascade = CascadeType.ALL)
	private Collection<Secteur> secteurs = new HashSet<Secteur>();
	
	@ManyToOne
	@JoinColumn(name="membre_id", nullable=false)
	private Membre membre;
	
	@ManyToMany(mappedBy="sites", cascade = CascadeType.ALL)
	private Collection<Topo> topos = new ArrayList<Topo>();
	
	public Site() {
		
	}

	public Site(String nom, String presentation, String localite, String codePostal) {
		super();
		this.nom = nom;
		this.presentation = presentation;
		this.localite = localite;
		this.codePostal = codePostal;
	}
	
	public void ajouterCommentaire(Commentaire com, Membre membre) {
		com.setMembre(membre);
		com.setSite(this);
		commentaires.add(com);
	}
	public Collection<Commentaire> recupererCommentaires(){
		return commentaires;
	}
	
	public void ajouterSecteur(Secteur secteur) {
		secteur.setSite(this);
		secteurs.add(secteur);
	}
	
	public Collection<Secteur> recupererSecteurs(){
		return secteurs;
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

	public String getPresentation() {
		return presentation;
	}

	public void setPresentation(String presentation) {
		this.presentation = presentation;
	}

	public String getLocalite() {
		return localite;
	}

	public void setLocalite(String localite) {
		this.localite = localite;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public int getHauteurMin() {
		return hauteurMin;
	}

	public void setHauteurMin(int hauteurMin) {
		this.hauteurMin = hauteurMin;
	}

	public int getHauteurMax() {
		return hauteurMax;
	}

	public void setHauteurMax(int hauteurMax) {
		this.hauteurMax = hauteurMax;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Membre getMembre() {
		return membre;
	}

	public void setMembre(Membre membre) {
		this.membre = membre;
	}
	
	
	
	

}
