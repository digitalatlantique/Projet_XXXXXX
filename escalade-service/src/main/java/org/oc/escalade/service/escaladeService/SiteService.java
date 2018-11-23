package org.oc.escalade.service.escaladeService;

import org.oc.escalade.modele.Site;

public interface SiteService<T> extends EscaladeService<T> {

	Site chercherDernier();
}
