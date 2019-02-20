package org.oc.escalade.service.locationService;

import java.util.List;

import org.oc.escalade.modele.Location;
import org.oc.escalade.modele.LocationId;
import org.oc.escalade.persistance.locationDAO.LocationDAO;
import org.oc.escalade.service.exception.LocationException;

public class LocationServiceImpl implements LocationService<Location> {
	
	private LocationDAO<Location> locationDAO;

	@Override
	public Location nouvelle(Location location) throws LocationException {
		
		Location locationTest = locationDAO.locationEnCours(location);
		
		if(locationTest == null) {
			locationDAO.nouvelle(location);
			return location;
		}
		else {
			throw new LocationException("Ce topo est déjà réservé à cette date !");
		}
	}

	@Override
	public Location recuperer(int id) {

		return locationDAO.recuperer(id);
	}

	@Override
	public void modifier(Location location) {
		
		locationDAO.modifier(location);
		
	}

	@Override
	public void supprimer(int membreId, int topoId) {

		locationDAO.supprimer(membreId, topoId);
		
	}

	@Override
	public List<Location> listerLocationsTopo(int topoId) {
		
		return locationDAO.listerLocationsTopo(topoId);
	}

	@Override
	public List<Location> listerLocationsMembre(int membreId) {
		
		return this.locationDAO.listerLocationsMembre(membreId);
	}

	public void setLocationDAO(LocationDAO<Location> locationDAO) {
		this.locationDAO = locationDAO;
	}

	@Override
	public void locationDisponible(Location location) throws LocationException {

		Location locationTest = locationDAO.locationEnCours(location);
		
		if(locationTest != null) {
			throw new LocationException("Ce topo est déjà réservé à cette date !");
		}
		
	}

}
