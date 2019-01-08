package org.oc.escalade.service.escaladeService;

import org.oc.escalade.modele.Membre;

public interface MembreService extends EscaladeService<Membre> {
	
	Membre authentifier(String email, String password);

}
