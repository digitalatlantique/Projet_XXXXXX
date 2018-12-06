package org.oc.escalade.webapp.action;

import org.oc.escalade.modele.Site;
import org.oc.escalade.service.escaladeService.SiteService;
import com.opensymphony.xwork2.ActionSupport;

public class IndexEscaladeAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SiteService siteService;
	private Site dernierSite;
	
	public IndexEscaladeAction() {

	}

	public String doSite() {
		System.out.println("SiteService : " + siteService);
		dernierSite = (Site) siteService.chercherDernier();
		return ActionSupport.SUCCESS;
	}

	public SiteService getSiteService() {
		return siteService;
	}

	public void setSiteService(SiteService siteService) {
		this.siteService = siteService;
	}

	public Site getDernierSite() {
		return dernierSite;
	}

	public void setDernierSite(Site dernierSite) {
		this.dernierSite = dernierSite;
	}
	

}
