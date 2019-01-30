package org.oc.escalade.service.escaladeService;

import java.util.List;

public interface SiteService<T> extends EscaladeService<T> {

	T chercherDernier();
	List<T> listerSitesTopo(int identifiantTopo);
}
