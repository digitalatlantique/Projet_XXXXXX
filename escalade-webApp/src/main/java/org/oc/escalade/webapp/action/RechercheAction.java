package org.oc.escalade.webapp.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.oc.escalade.modele.Site;
import org.oc.escalade.service.escaladeService.SiteService;
import org.oc.escalade.service.rechercheService.RechercheService;

import com.opensymphony.xwork2.ActionSupport;

public class RechercheAction extends ActionSupport implements SessionAware{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private RechercheService rechercheService;
	private List<Site> sites;
	
	private List<String> criteres;
	private String choixCritere;
	private String saisie;
	private Map<String, Object> session;
	
	private static final String NOM = "nom";
	private static final String LOCALITE = "localité";
	private static final String CODE_POSTAL = "code postal";
	private static final String MOT_CLE = "mot clé";
	
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
		
		if(choixCritere == null) {
			return resultat;
		}
		
		else if(!saisie.isEmpty()) {
			
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
					try {
						sites = rechercheService.parCodePostal(saisie);
					}
					catch(IllegalArgumentException e) {
						this.addActionError(e.getMessage());
						return resultat;
					}
					
					break;
				}
				case MOT_CLE : {
					sites = rechercheService.parMotCle(saisie);
					break;
				}
			}
			session.put("sites", sites);
			resultat = ActionSupport.SUCCESS;
		}
		else {
			this.addActionError("Champ requis !");
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

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
		
	}
	
}
