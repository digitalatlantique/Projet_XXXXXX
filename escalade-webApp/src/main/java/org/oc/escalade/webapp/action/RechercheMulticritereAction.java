package org.oc.escalade.webapp.action;

import java.util.List;

import org.oc.escalade.modele.Site;
import org.oc.escalade.service.rechercheService.RechercheService;

import com.opensymphony.xwork2.ActionSupport;

public class RechercheMulticritereAction extends ActionSupport{
	
	private RechercheService rechercheService;
	private List<Site> sites;
	
	private String nom;
	private String localite;
	private String cotation;
	
	public String doAfficheRechercheMulticritere() {
		
		return SUCCESS;
	}
	
	public String doRechercheMulticritere() {
		
		sites = rechercheService.multicritere(nom, localite, cotation);
		return SUCCESS;
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
	
}
