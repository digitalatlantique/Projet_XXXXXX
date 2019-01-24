package org.oc.escalade.service.escaladeService;

import java.util.List;

import org.oc.escalade.modele.Voie;
import org.oc.escalade.persistance.escaladeDAO.EscaladeDAO;

public class VoieServiceImpl implements EscaladeService<Voie> {
	
	private EscaladeDAO<Voie> voieDAO;

	@Override
	public Voie enregistrer(Voie voie) {
		
		voieDAO.enregistrer(voie);
		return voie;
	}

	@Override
	public Voie chercher(int identifiant) {
		
		return voieDAO.chercher(identifiant);
	}

	@Override
	public void modifier(Voie voie) {
		
		voieDAO.modifier(voie);
		
	}

	@Override
	public void supprimer(int identifiant) {
		
		voieDAO.supprimer(identifiant);
		
	}

	@Override
	public List<Voie> lister(int identifiant) {
		
		return voieDAO.lister(identifiant);
	}

	public void setVoieDAO(EscaladeDAO<Voie> voieDAO) {
		this.voieDAO = voieDAO;
	}

}
