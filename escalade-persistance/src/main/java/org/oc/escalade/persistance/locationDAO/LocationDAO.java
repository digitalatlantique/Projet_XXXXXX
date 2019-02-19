package org.oc.escalade.persistance.locationDAO;

import java.util.List;

import org.oc.escalade.modele.LocationId;

public interface LocationDAO<T> {
	
	T nouvelle(T objet);
	T recuperer(int id);
	void modifier(T objet);
	void supprimer(int membreId, int topoId);
	List<T> listerLocationsSite(int siteId);
	List<T> listerLocationsMembre(int membreId);
	T locationEnCours(T objet);

}
