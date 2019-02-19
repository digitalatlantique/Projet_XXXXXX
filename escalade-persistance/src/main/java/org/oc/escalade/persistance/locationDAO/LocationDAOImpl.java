package org.oc.escalade.persistance.locationDAO;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.oc.escalade.modele.Location;
import org.oc.escalade.modele.LocationId;
import org.oc.escalade.modele.Membre;
import org.oc.escalade.modele.Topo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class LocationDAOImpl implements LocationDAO<Location> {
	
	private SessionFactory sessionFactory;	


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Location nouvelle(Location location) {

		Session session = sessionFactory.getCurrentSession();
		session.save(location);
		return location;
	}

	@Override
	public Location recuperer(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		Location location = session.get(Location.class, id);
		return location;
	}

	@Override
	public void modifier(Location location) {
		
		Session session = sessionFactory.getCurrentSession();

		session.update(location);
		
	}

	@Override
	public void supprimer(int membreId, int topoId) {
		
		Session session = sessionFactory.getCurrentSession();
		
		String requete = "SELECT l FROM Location l WHERE l.location_id.topo.id = :tid AND l.location_id.membre.id = :mid";
		Location location = (Location) session.createQuery(requete)
							.setParameter("mid", membreId)
							.setParameter("tid", topoId)
							.getSingleResult();
		
		Membre membre = session.get(Membre.class, membreId);
		Topo topo = session.get(Topo.class, topoId);
		
		membre.getLocations().remove(location);
		topo.getLocations().remove(location);
		
		session.update(topo);
		session.update(membre);
		
	}

	@Override
	public List<Location> listerLocationsSite(int siteId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Location> listerLocationsMembre(int membreId) {

		Session session = sessionFactory.getCurrentSession();
		String requete = "SELECT m.locations FROM Membre m "										
										+ "WHERE m.id = :mid";	
		
		List<Location> locations = session.createQuery(requete).setParameter("mid", membreId).list();
		return locations;
	}

	@Override
	public Location locationEnCours(Location location) {
		
		Session session = sessionFactory.getCurrentSession();
		Calendar date = location.getDate();
		
		String requete = "SELECT l FROM Location l "
						+ "WHERE date = :date "
						+ "AND l.location_id.topo.id = :tid ";
		
		return (Location) session.createQuery(requete)
						.setParameter("date", date)
						.setParameter("tid", location.getTopo().getId())
						.uniqueResult();
	}

}
