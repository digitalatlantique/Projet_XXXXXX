package org.oc.escalade.persistance.escaladeDAO;

import java.util.List;


public interface SiteDAO<T> extends EscaladeDAO<T> {
	
	T chercherDernier();
	List<T> listerSitesTopo(int identifiantTopo);
}
