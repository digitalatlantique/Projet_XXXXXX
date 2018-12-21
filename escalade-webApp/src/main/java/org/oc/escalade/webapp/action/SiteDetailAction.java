package org.oc.escalade.webapp.action;


import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.oc.escalade.modele.Secteur;
import org.oc.escalade.modele.Site;
import org.oc.escalade.modele.Voie;

import com.opensymphony.xwork2.ActionSupport;



public class SiteDetailAction extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Map<String, Object> session;
	private List<Site> sites;
	private Site site;
	private Collection<Secteur> secteurs;
	private int id;
	
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

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
		
	}



}
