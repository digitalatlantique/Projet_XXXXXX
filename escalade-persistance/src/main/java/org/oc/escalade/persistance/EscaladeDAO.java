package org.oc.escalade.persistance;

public interface EscaladeDAO<T> {
	
	T enregistrer(T objet);
	T chercher(int identifiant);
	void modifier(T objet);
	void supprimer(int identifiant);

}
