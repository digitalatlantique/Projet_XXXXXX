package org.oc.escalade.persistance.topoDAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.oc.escalade.modele.Site;
import org.oc.escalade.modele.Topo;

public class TopoDAOImpl implements TopoDAO<Topo> {

	protected SessionFactory sessionFactory;	

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public Topo enregistrer(Topo topo) {
		Session session = sessionFactory.getCurrentSession();
		session.save(topo);
		return topo;
	}

	@Override
	public Topo chercher(int identifiant) {
		Session session = sessionFactory.getCurrentSession();
		Topo topo = (Topo) session.get(Topo.class, identifiant);		
		return topo;
	}

	@Override
	public void modifier(Topo topo) {
		Session session = sessionFactory.getCurrentSession();
		session.update(topo);
		
	}

	@Override
	public void supprimer(int identifiant) {
		Session session = sessionFactory.getCurrentSession();
		Topo topo = (Topo) session.get(Topo.class, identifiant);
		session.delete(topo);
		
	}

	@Override
	public List<Topo> lister(int identifiant) {
		
		Session session = sessionFactory.getCurrentSession();
		String requete = "FROM Topo t WHERE membre_id = :mid";
		List<Topo> topos = (List<Topo>) session.createQuery(requete).setParameter("mid", identifiant).list();
		return topos;
	}

}
