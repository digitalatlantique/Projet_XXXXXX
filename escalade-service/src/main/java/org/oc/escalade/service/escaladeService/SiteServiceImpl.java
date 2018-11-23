package org.oc.escalade.service.escaladeService;

import java.util.List;

import org.oc.escalade.modele.Site;
import org.oc.escalade.persistance.escaladeDAO.SiteDAO;

public class SiteServiceImpl implements SiteService<Site> {
	
	private SiteDAO siteDAO;
	
	public void setSiteDAO(SiteDAO siteDAO) {
		this.siteDAO = siteDAO;
	}

	@Override
	public Site enregistrer(Site site) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Site chercher(int identifiant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifier(Site site) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimer(int identifiant) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Site> lister(int identifiant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Site chercherDernier() {
		
		return (Site) siteDAO.chercherDernier();
	}


}
