package org.oc.escalade.webapp.action;

import org.jboss.logging.Logger;
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
	private Logger log = Logger.getLogger(IndexEscaladeAction.class);
	
	
	public IndexEscaladeAction() {

	}

	public String doSite() {
		log.debug("Action index");
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
