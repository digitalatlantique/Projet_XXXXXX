package org.oc.escalade.webapp.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.oc.escalade.modele.Site;
import org.oc.escalade.service.rechercheService.RechercheService;

import com.opensymphony.xwork2.ActionSupport;

public class RechercheMulticritereAction extends ActionSupport implements SessionAware{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private RechercheService rechercheService;
	private List<Site> sites;
	
	private String nom = null;
	private String localite = null;
	private String cotation = null;
	private Map<String, Object> session;
	
	public String doAfficheRechercheMulticritere() {
		
		return SUCCESS;
	}
	
	public String doRechercheMulticritere() {
		
		if(nom.isEmpty() && localite.isEmpty() && cotation.isEmpty()) {
			this.addActionError("Un champ est requis");
			return INPUT;
		}
		else {

			sites = rechercheService.multicritere(nom, localite, cotation);
			session.put("sites", sites);
			return SUCCESS;
		}

	}

	public RechercheService getRechercheService() {
		return rechercheService;
	}

	public void setRechercheService(RechercheService rechercheService) {
		this.rechercheService = rechercheService;
	}

	public List<Site> getSites() {
		return sites;
	}

	public void setSites(List<Site> sites) {
		this.sites = sites;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getLocalite() {
		return localite;
	}

	public void setLocalite(String localite) {
		this.localite = localite;
	}

	public String getCotation() {
		return cotation;
	}

	public void setCotation(String cotation) {
		this.cotation = cotation;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
		
	}
	
}
