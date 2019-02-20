package org.oc.escalade.webapp.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.jboss.logging.Logger;
import org.oc.escalade.modele.Site;
import org.oc.escalade.service.escaladeService.SiteService;
import com.opensymphony.xwork2.ActionSupport;

public class IndexEscaladeAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SiteService<Site> siteService;
	private Site dernierSite;
	private Map<String, Object> session;
	private Logger log = Logger.getLogger(IndexEscaladeAction.class);
	
	
	public IndexEscaladeAction() {

	}

	public String doSite() {
		log.debug("Action index");
		dernierSite = (Site) siteService.chercherDernier();
		List<Site> sites = siteService.listerTout();
		session.put("sites", sites);
		return ActionSupport.SUCCESS;
	}

	public SiteService<Site> getSiteService() {
		return siteService;
	}

	public void setSiteService(SiteService<Site> siteService) {
		this.siteService = siteService;
	}

	public Site getDernierSite() {
		return dernierSite;
	}

	public void setDernierSite(Site dernierSite) {
		this.dernierSite = dernierSite;
	}

	@Override
	public void setSession(Map<String, Object> session) {


		this.session = session;
		
	}
	

}
