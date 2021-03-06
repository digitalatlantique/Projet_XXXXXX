package org.oc.escalade.service.topoService;

import java.util.List;

import org.oc.escalade.service.escaladeService.EscaladeService;

public interface TopoService<T> extends EscaladeService<T> {

	List<T> listerTout();
	void ajouterSiteAuTopo(int topoId, int siteId);
	void retirerSiteAuTopo(int topoId, int siteId);
}
