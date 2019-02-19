package org.oc.escalade.service.locationService;

import java.util.List;

import org.oc.escalade.modele.LocationId;
import org.oc.escalade.service.exception.LocationException;

public interface LocationService<T> {

	T nouvelle(T objet) throws LocationException;
	T recuperer(int id);
	void modifier(T objet);
	void supprimer(int membreId, int topoId);
	List<T> listerLocationsSite(int siteId);
	List<T> listerLocationsMembre(int membreId);
	void locationDisponible(T objet) throws LocationException;
}
