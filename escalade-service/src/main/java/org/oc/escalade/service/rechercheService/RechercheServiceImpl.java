package org.oc.escalade.service.rechercheService;

import java.util.List;

import org.oc.escalade.modele.Site;
import org.oc.escalade.persistance.rechercheDAO.RechercheDAO;

public class RechercheServiceImpl implements RechercheService {
	
	private RechercheDAO rechercheDAO;
	
	public void setRechercheDAO(RechercheDAO rechercheDAO) {
		this.rechercheDAO = rechercheDAO;
	}

	@Override
	public List<Site> parNomSite(String nom) {
		
		return rechercheDAO.parNomSite(nom);
	}

	@Override
	public List<Site> parLocalite(String localite) {
		
		return rechercheDAO.parLocalite(localite);
	}

	@Override
	public List<Site> parCodePostal(String codePostal) {
		
		return rechercheDAO.parCodePostal(codePostal);
	}

	@Override
	public List<Site> parMotCle(String motCle) {
		
		return rechercheDAO.parMotCle(motCle);
	}

	@Override
	public List<Site> multicritere(String nom, String localite, String cotation) {
		
		return rechercheDAO.multicritere(nom, localite, cotation);
	}
	
}
