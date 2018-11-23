package org.oc.escalade.service.escaladeService;

import java.util.List;

public interface EscaladeService<T> {
	
	T enregistrer(T objet);
	T chercher(int identifiant);
	void modifier(T objet);
	void supprimer(int identifiant);
	List<T> lister(int identifiant);

}
