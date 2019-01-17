package org.oc.escalade.webapp.action;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.oc.escalade.modele.Membre;
import org.oc.escalade.modele.Secteur;
import org.oc.escalade.modele.Site;
import org.oc.escalade.service.escaladeService.SiteService;

import com.opensymphony.xwork2.ActionSupport;

public class SiteAction extends ActionSupport implements SessionAware{
	
	private Map<String, Object> session;
	private List<Site> sites;
	private Site site;
	private Collection<Secteur> secteurs;
	private int id;
	private Membre membre;
	private SiteService siteService;

	public String doSite() {
		
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
		site = (Site) siteService.chercher(id);
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

	public void setSiteService(SiteService siteService) {
		this.siteService = siteService;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
		
	}
	

}
