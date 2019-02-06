package org.oc.escalade.service.topoService;

import java.util.List;

import org.oc.escalade.modele.Topo;
import org.oc.escalade.persistance.escaladeDAO.TopoDAO;

public class TopoServiceImpl implements TopoService<Topo> {
	
	private TopoDAO<Topo> topoDAO;

	@Override
	public Topo enregistrer(Topo topo) {
		
		return topoDAO.enregistrer(topo);
	}

	@Override
	public Topo chercher(int identifiant) {
		
		return topoDAO.chercher(identifiant);
	}

	@Override
	public void modifier(Topo topo) {
		
		topoDAO.modifier(topo);
	}

	@Override
	public void supprimer(int identifiant) {
		
		topoDAO.supprimer(identifiant);
		
	}

	@Override
	public List<Topo> lister(int identifiant) {
		
		return topoDAO.lister(identifiant);
	}

	@Override
	public List<Topo> listerTout() {
		
		return topoDAO.listerTout();
	}

	public void setTopoDAO(TopoDAO<Topo> topoDAO) {
		this.topoDAO = topoDAO;
	}

	@Override
	public void ajouterSiteAuTopo(int topoId, int siteId) {
		
		topoDAO.ajouterSiteAuTopo(topoId, siteId);
		
	}

	@Override
	public void retirerSiteAuTopo(int topoId, int siteId) {
		
		topoDAO.retirerSiteAuTopo(topoId, siteId);
				
	}

}
