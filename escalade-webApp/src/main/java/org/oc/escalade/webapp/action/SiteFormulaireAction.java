package org.oc.escalade.webapp.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.oc.escalade.modele.Membre;
import org.oc.escalade.modele.Site;
import org.oc.escalade.service.escaladeService.SiteService;

import com.opensymphony.xwork2.ActionSupport;

public class SiteFormulaireAction extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nom = null;
	private String presentation = null;
	private String localite = null;
	private String codePostal = null;
	private String imagePath;
	private static final String IMAGE_SITE_DEFAUT = "siteDefaut.jpg";
	private Membre membre;
	private Map<String, Object> session;
	private SiteService siteService;
	private int id;
	
	
	public String doNouveauSite() {
		
		if(nom.isEmpty() || presentation.isEmpty() || localite.isEmpty() || codePostal.isEmpty()) {
			this.addActionError("Tous les champs sont requis !");
			return ERROR;
		}
		else {
			membre = (Membre) session.get("membre");
			Site site = new Site(nom, presentation, localite, codePostal, IMAGE_SITE_DEFAUT);
			site.setMembre(membre);
			siteService.enregistrer(site);
			this.addActionMessage("Ajout du nouveau site !");			
			return SUCCESS;
		}

	}
	public String doModifierSite() {
		
		if(nom == null && presentation == null && localite == null && codePostal == null) {
			Site site = (Site) siteService.chercher(id);
			nom = site.getNom();
			presentation = site.getPresentation();
			localite = site.getLocalite();
			codePostal = site.getCodePostal();
			return INPUT;
		}
		else if(nom.isEmpty() || presentation.isEmpty() || localite.isEmpty() || codePostal.isEmpty()) {
			this.addActionError("Tous les champs sont requis !");
			return ERROR;
		}
		else {
			Site site = (Site) siteService.chercher(id);
			site.setNom(nom);
			site.setPresentation(presentation);
			site.setLocalite(localite);
			site.setCodePostal(codePostal);
			siteService.modifier(site);
			
			this.addActionMessage("Modification réussie !");
			
			return SUCCESS;
		}
	}
	public String doSupprimerSite() {
		siteService.supprimer(id);
		this.addActionMessage("Suppression réussie !");
		return SUCCESS;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setSiteService(SiteService siteService) {
		this.siteService = siteService;
	}
	@Override
	public void setSession(Map<String, Object> session) {

		this.session = session;
		
	}	

}
