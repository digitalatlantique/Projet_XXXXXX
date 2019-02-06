package org.oc.escalade.persistance.escaladeDAO;

import java.util.List;

public interface TopoDAO<T> extends EscaladeDAO<T> {
	
	List<T> listerTout();
	void ajouterSiteAuTopo(int topoId, int siteId);
	void retirerSiteAuTopo(int topoId, int siteId);

}
