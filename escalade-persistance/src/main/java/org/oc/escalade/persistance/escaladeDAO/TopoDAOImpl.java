package org.oc.escalade.persistance.escaladeDAO;

import java.util.List;

import org.hibernate.Session;
import org.oc.escalade.modele.Topo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class TopoDAOImpl extends AbstractEscaladeDAO implements TopoDAO<Topo> {

	@Override
	public Topo enregistrer(Topo topo) {
		
		Session session = sessionFactory.getCurrentSession();
		session.save(topo);
		return topo;
	}

	@Override
	public Topo chercher(int identifiant) {
		
		Session session = sessionFactory.getCurrentSession();
		Topo topo = session.get(Topo.class, identifiant);
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
		Topo topo = session.get(Topo.class, identifiant);
		session.delete(topo);
		
	}

	/**
	 * Liste les topos d'un membre
	 */
	@Override
	public List<Topo> lister(int identifiant) {
		
		Session session = sessionFactory.getCurrentSession();
		String requete = "FROM Topo WHERE membre_id = :mid";
		List<Topo> topos = (List<Topo>) session.createQuery(requete).setParameter("mid", identifiant).list();
		return topos;
	}
	/**
	 * Liste tous les topos
	 */
	@Override
	public List<Topo> listerTout() {
		
		Session session = sessionFactory.getCurrentSession();
		String requete = "SELECT t FROM Topo t ORDER BY t.id DESC";
		List<Topo> topos = session.createQuery(requete).list();			
		return topos;
	}


}
