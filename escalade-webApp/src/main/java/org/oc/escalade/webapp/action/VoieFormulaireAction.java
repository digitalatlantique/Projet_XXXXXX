package org.oc.escalade.webapp.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.oc.escalade.modele.Secteur;
import org.oc.escalade.modele.Site;
import org.oc.escalade.modele.Voie;
import org.oc.escalade.service.escaladeService.EscaladeService;

import com.opensymphony.xwork2.ActionSupport;

public class VoieFormulaireAction extends ActionSupport implements SessionAware{
	
	private Map<String, Object> session;
	private EscaladeService<Secteur> secteurService;
	private EscaladeService<Voie> voieService;
    private String nom = null;
    private String numero = null;
    private String cotation = null;
    private int id;
    private int idSecteur;
    private int idVoie;
    
    public String doCreerVoie() {
    	
    	String resultat = INPUT;
    	
    	if(nom == null && numero == null && cotation == null) {
    		return resultat;
    	}
    	else if(nom.isEmpty() || numero.isEmpty() || cotation.isEmpty()) {
    		this.addActionError("Tous les champs sont requis !");
    	}
    	else {
			Site site = (Site) session.get("site");
			id = site.getId();
			
			Secteur secteur = secteurService.chercher(idSecteur);
			Voie voie = new Voie(numero, nom, cotation, secteur);
			voieService.enregistrer(voie);
			
			this.addActionMessage("Ajout de la nouvelle voie !");
    		resultat = SUCCESS;
    	}
    	return resultat;    	
    }
    
    public String doModifierVoie() {
    	
    	String resultat = INPUT;
    	if(nom == null && numero == null && cotation == null) {
    		Voie voie = voieService.chercher(idVoie);
    		nom = voie.getNom();
    		numero = voie.getNumero();
    		cotation = voie.getCotation();
    		
    		return resultat;
    	}
    	else if(nom.isEmpty() || numero.isEmpty() || cotation.isEmpty()) {
    		this.addActionError("Tous les champs sont requis !");
    	}
    	else {
			Site site = (Site) session.get("site");
			id = site.getId();
    		Voie voie = voieService.chercher(idVoie);
    		voie.setNom(nom);
    		voie.setNumero(numero);
    		voie.setCotation(cotation);
    		voieService.modifier(voie);
    		this.addActionMessage("Modification réussie !");
    		resultat = SUCCESS;
    	}    	
    	return resultat;    	
    }
    public String doSupprimerVoie() {
		Site site = (Site) session.get("site");
		id = site.getId();
    	voieService.supprimer(idVoie);
    	this.addActionMessage("Suppression réussie !");
    	return SUCCESS;
    }
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCotation() {
		return cotation;
	}

	public void setCotation(String cotation) {
		this.cotation = cotation;
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

	public int getIdVoie() {
		return idVoie;
	}

	public void setIdVoie(int idVoie) {
		this.idVoie = idVoie;
	}

	public void setSecteurService(EscaladeService<Secteur> secteurService) {
		this.secteurService = secteurService;
	}

	public void setVoieService(EscaladeService<Voie> voieService) {
		this.voieService = voieService;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		
		this.session = session;		
	}

}
