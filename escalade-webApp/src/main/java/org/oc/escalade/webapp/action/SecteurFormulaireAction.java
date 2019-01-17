package org.oc.escalade.webapp.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.oc.escalade.modele.Secteur;
import org.oc.escalade.modele.Site;
import org.oc.escalade.service.escaladeService.EscaladeService;
import com.opensymphony.xwork2.ActionSupport;

public class SecteurFormulaireAction extends ActionSupport implements SessionAware {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Site site;
	private String nom = null;
	private Integer hauteur = null;
    private EscaladeService secteurService;
    private Map<String, Object> session;
    private int id;
    private int idSecteur;
    
	public String doCreerSecteur() {
		
		String resultat = INPUT;
		if(nom == null && hauteur == null) {
			return resultat;
		}
		else if(nom.isEmpty() || hauteur == null) {
			this.addActionError("Tous les champs sont requis !");
			
		}
		else {
			
			Site site = (Site) session.get("site");
			id = site.getId();
			Secteur secteur = new Secteur(nom, hauteur, site);
			secteurService.enregistrer(secteur);			
			resultat = SUCCESS;
		}
		return resultat;
	}
	
	public String doModifierSecteur() {
		String resultat = INPUT;
		if(nom == null && hauteur == null) {
			Secteur secteur = (Secteur) secteurService.chercher(idSecteur);
			this.nom = secteur.getNom();
			this.hauteur = secteur.getHauteur();
			return resultat;
		}
		else if(nom.isEmpty() || hauteur == null) {
			this.addActionError("Tous les champs sont requis !");
			resultat = ERROR;
		}
		else {
			Secteur secteur = (Secteur) secteurService.chercher(idSecteur);
			secteur.setNom(nom);
			secteur.setHauteur(hauteur);
			secteurService.modifier(secteur);
			
			Site site = (Site) session.get("site");
			this.id = site.getId();
			
			this.addActionMessage("Modification réussie !");			
			return SUCCESS;
		}
		return resultat;
	}
	
	public String doSupprimerSecteur() {
		secteurService.supprimer(idSecteur);
		this.addActionMessage("Suppression réussie !");
		Site site = (Site) session.get("site");
		this.id = site.getId();
		return SUCCESS;
	}

	public Site getSite() {
		return site;
	}
	
	public void setSite(Site site) {
		this.site = site;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getHauteur() {
		return hauteur;
	}

	public void setHauteur(Integer hauteur) {
		this.hauteur = hauteur;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdSecteur() {
		return idSecteur;
	}

	public void setIdSecteur(int idSecteur) {
		this.idSecteur = idSecteur;
	}

	public void setSecteurService(EscaladeService secteurService) {
		this.secteurService = secteurService;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		
		this.session = session;		
		
	}

}
