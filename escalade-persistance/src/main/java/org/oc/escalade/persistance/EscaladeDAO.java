package org.oc.escalade.persistance;

import java.util.List;

public interface EscaladeDAO<T> {
	
	T enregistrer(T objet);
	T chercher(int identifiant);
	void modifier(T objet);
	void supprimer(int identifiant);
	List<T> lister(int identifiant);

}
