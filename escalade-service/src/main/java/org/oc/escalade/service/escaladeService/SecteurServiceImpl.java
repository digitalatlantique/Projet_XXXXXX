package org.oc.escalade.service.escaladeService;

import java.util.List;

import org.oc.escalade.modele.Secteur;
import org.oc.escalade.persistance.escaladeDAO.EscaladeDAO;
import org.oc.escalade.persistance.escaladeDAO.SiteDAO;

public class SecteurServiceImpl implements EscaladeService<Secteur> {
	
	private EscaladeDAO<Secteur> secteurDAO;

	@Override
	public Secteur enregistrer(Secteur secteur) {
		secteurDAO.enregistrer(secteur);
		return secteur;
	}

	@Override
	public Secteur chercher(int identifiant) {
		
		return (Secteur) secteurDAO.chercher(identifiant);
	}

	@Override
	public void modifier(Secteur secteur) {
		
		secteurDAO.modifier(secteur);
		
	}

	@Override
	public void supprimer(int identifiant) {
		
		secteurDAO.supprimer(identifiant);
		
	}

	@Override
	public List<Secteur> lister(int identifiant) {
		
		return secteurDAO.lister(identifiant);
	}

	public void setSecteurDAO(EscaladeDAO<Secteur> secteurDAO) {
		this.secteurDAO = secteurDAO;
	}

}
