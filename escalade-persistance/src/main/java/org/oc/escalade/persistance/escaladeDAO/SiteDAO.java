package org.oc.escalade.persistance.escaladeDAO;

public interface SiteDAO<Site> extends EscaladeDAO<Site> {
	Site chercherDernier();
}
