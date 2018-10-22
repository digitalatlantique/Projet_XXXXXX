package org.oc.escalade.modele;

public class Site {
	
	private int id;
	private String nom;
	private String presentation;
	private String localite;
	private String codePostal;
	private int hauteurMin;
	private int hauteurMax;
	private String imagePath;
	
	public Site() {
		
	}

	public Site(String nom, String presentation, String localite, String codePostal) {
		super();
		this.nom = nom;
		this.presentation = presentation;
		this.localite = localite;
		this.codePostal = codePostal;
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
	
	
	
	

}
