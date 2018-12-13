package org.oc.escalade.webapp.action;

import java.util.ArrayList;
import java.util.List;

import org.oc.escalade.modele.Site;
import org.oc.escalade.service.escaladeService.SiteService;

import com.opensymphony.xwork2.ActionSupport;

public class RechercheAction extends ActionSupport{
	
	private SiteService siteService;
	private List<Site> sites;
	
	private List<String> criteres;
	private String choixCritere;
	private String Saisie;
	
	private static final String NOM = "nom ";
	private static final String LOCALITE = "localité ";
	private static final String CODE_POSTAL = "code postal ";
	private static final String MOT_CLE = "mot clé ";
	
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
		return Saisie;
	}

	public void setSaisie(String saisie) {
		Saisie = saisie;
	}
	
	
}
