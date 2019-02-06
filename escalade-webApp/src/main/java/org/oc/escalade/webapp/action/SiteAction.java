package org.oc.escalade.webapp.action;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.jboss.logging.Logger;
import org.oc.escalade.modele.Membre;
import org.oc.escalade.modele.Secteur;
import org.oc.escalade.modele.Site;
import org.oc.escalade.service.escaladeService.SiteService;

import com.opensymphony.xwork2.ActionSupport;


public class SiteAction extends ActionSupport implements SessionAware{
	
	/**
	 * 
	 */
	private static Logger log = Logger.getLogger(SiteAction.class);
	private static final long serialVersionUID = 1L;
	private Map<String, Object> session;
	private List<Site> sites;
	private Site site;
	private Collection<Secteur> secteurs;
	private int id;
	private int topoId;
	private Membre membre;
	private SiteService<Site> siteService;

	public String doSite() {
		
		return SUCCESS;
	}
	
	public String doSiteTopo() {
		
		sites = siteService.listerSitesTopo(topoId);
		session.put("sites", sites);
		return SUCCESS;
		
	}
	public String doMesSiteTopo() {
		
		Membre membre = (Membre) session.get("membre");
		List<Site> mesSites = siteService.lister(membre.getId());
		List<Site> sitesTopo = siteService.listerSitesTopo(topoId);
		session.put("sites", mesSites);
		session.put("sitesTopo", sitesTopo);
		return SUCCESS;
		
	}
	public String doDetail() {
		sites = (List<Site>) session.get("sites");
		
		for (Site site : sites) {
			if(site.getId() == id) {
				this.site = site;
				break;
			}
		}
		secteurs = site.getSecteurs();
		return SUCCESS;
	}
	public String doMesSites() {
		membre = (Membre) session.get("membre");
		sites = siteService.lister(membre.getId());
		session.put("sites", sites);
		return SUCCESS;
	}
	public String doMesSecteurs() {
		//site = (Site) siteService.chercher(id);
		membre = (Membre) session.get("membre");
		sites = siteService.lister(membre.getId());
		
		for (Site site : sites) {
			if(site.getId() == id) {
				this.site = site;
				break;
			}
		}
		secteurs = site.getSecteurs();
		session.put("site", site);
		return SUCCESS;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getTopoId() {
		return topoId;
	}

	public void setTopoId(int topoId) {
		this.topoId = topoId;
	}

	public Collection<Secteur> getSecteurs() {
		return secteurs;
	}
	public void setSecteurs(Collection<Secteur> secteurs) {
		this.secteurs = secteurs;
	}
	public void setSiteService(SiteService<Site> siteService) {

		this.siteService = siteService;
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
		
	}
	

}
