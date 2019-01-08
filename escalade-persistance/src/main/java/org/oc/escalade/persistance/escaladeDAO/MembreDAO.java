package org.oc.escalade.persistance.escaladeDAO;

import org.oc.escalade.modele.Membre;

public interface MembreDAO extends EscaladeDAO<Membre> {
	
	Membre authentifier(String email, String password);
	Membre verifierDoublon(Membre membre);
}
