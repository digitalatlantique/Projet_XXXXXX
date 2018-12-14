package org.oc.escalade.webapp.action;

import java.util.ArrayList;
import java.util.List;

import org.oc.escalade.modele.Site;
import org.oc.escalade.service.escaladeService.SiteService;
import org.oc.escalade.service.rechercheService.RechercheService;

import com.opensymphony.xwork2.ActionSupport;

public class RechercheAction extends ActionSupport{
	
	private RechercheService rechercheService;
	private List<Site> sites;
	
	private List<String> criteres;
	private String choixCritere;
	private String saisie;
	
	private static final String NOM = "nom";
	private static final String LOCALITE = "localite";
	private static final String CODE_POSTAL = "codePostal ";
	private static final String MOT_CLE = "motCle ";
	
	public RechercheAction() {
		
		criteres = new ArrayList<String>();
		criteres.add(NOM);
		criteres.add(LOCALITE);
		criteres.add(CODE_POSTAL);
		criteres.add(MOT_CLE);
	}
	
	public String getDefaultCritere() {
		return NOM;
	}
	
	public String doRecherche() {
		String resultat = ActionSupport.INPUT;
		
		if(this.choixCritere != null) {
			
			switch(choixCritere) {
				case NOM : {
					sites = rechercheService.parNomSite(saisie);
					break;
				}
				case LOCALITE : {
					sites = rechercheService.parLocalite(saisie);
					break;
				}
				case CODE_POSTAL : {
					sites = rechercheService.parCodePostal(saisie);
					break;
				}
				case MOT_CLE : {
					sites = rechercheService.parMotCle(saisie);
					break;
				}
			}
			resultat = ActionSupport.SUCCESS;
		}
		return resultat;
	}
	public List<String> getCriteres() {
		return criteres;
	}

	public void setCriteres(List<String> criteres) {
		this.criteres = criteres;
	}

	public String getChoixCritere() {
		return choixCritere;
	}

	public void setChoixCritere(String choixCritere) {
		this.choixCritere = choixCritere;
	}

	public String getSaisie() {
		return saisie;
	}

	public void setSaisie(String saisie) {
		this.saisie = saisie;
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
	
}
