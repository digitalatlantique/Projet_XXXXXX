package org.oc.escalade.service.escaladeService;

import java.util.List;


import org.oc.escalade.modele.Site;
import org.oc.escalade.persistance.escaladeDAO.SiteDAO;

public class SiteServiceImpl implements SiteService<Site> {

	private SiteDAO<Site> siteDAO;
	
	public SiteServiceImpl() {

	}
	
	public void setSiteDAO(SiteDAO<Site> siteDAO) {
		this.siteDAO = siteDAO;
	}

	@Override
	public Site enregistrer(Site site) {
		siteDAO.enregistrer(site);
		return site;
	}

	@Override
	public Site chercher(int identifiant) {
		
		return (Site) siteDAO.chercher(identifiant);
	}

	@Override
	public void modifier(Site site) {
		siteDAO.modifier(site);
		
	}

	@Override
	public void supprimer(int identifiant) {
		siteDAO.supprimer(identifiant);		
	}

	@Override
	public List<Site> lister(int identifiant) {
		
		return siteDAO.lister(identifiant);
	}

	@Override
	public Site chercherDernier() {

		return (Site) siteDAO.chercherDernier();
	}
	/**
	 * Liste tous les sites d'un topo
	 */
	@Override
	public List<Site> listerSitesTopo(int identifiantTopo){
		
		return siteDAO.listerSitesTopo(identifiantTopo);
	}

	@Override
	public List<Site> listerTout() {
		
		return siteDAO.listerTout();
	}

}
