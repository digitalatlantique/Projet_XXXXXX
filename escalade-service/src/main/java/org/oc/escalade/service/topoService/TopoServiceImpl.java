package org.oc.escalade.service.topoService;

import java.util.List;

import org.oc.escalade.modele.Topo;
import org.oc.escalade.persistance.escaladeDAO.TopoDAO;

public class TopoServiceImpl implements TopoService<Topo> {
	
	private TopoDAO<Topo> topoDAO;

	@Override
	public Topo enregistrer(Topo topo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Topo chercher(int identifiant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifier(Topo topo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimer(int identifiant) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Topo> lister(int identifiant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Topo> listerTout() {
		
		return topoDAO.listerTout();
	}

	public void setTopoDAO(TopoDAO<Topo> topoDAO) {
		this.topoDAO = topoDAO;
	}

}
