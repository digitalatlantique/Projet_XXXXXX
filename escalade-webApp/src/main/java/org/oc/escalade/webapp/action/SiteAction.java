package org.oc.escalade.webapp.action;

import java.util.List;

import org.oc.escalade.modele.Site;

import com.opensymphony.xwork2.ActionSupport;

public class SiteAction extends ActionSupport{
	
	private List<Site> sites;
	
	public String doSite() {
		
		return SUCCESS;
	}

	public List<Site> getSites() {
		return sites;
	}

	public void setSites(List<Site> sites) {
		this.sites = sites;
	}
	
	

}
