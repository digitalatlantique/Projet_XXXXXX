package org.oc.escalade.persistance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.oc.escalade.modele.Membre;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class MembreDAOImpl implements EscaladeDAO<Membre> {
	
	private SessionFactory sessionFactory;

	@Override
	public Membre enregistrer(Membre membre) {
		Session session = sessionFactory.getCurrentSession();
		session.save(membre);
		return membre;
	}

	@Override
	public Membre chercher(int identifiant) {
		Session session = sessionFactory.getCurrentSession();
		Membre membre = (Membre) session.get(Membre.class, identifiant);		
		return membre;
	}

	@Override
	public void modifier(Membre membre) {
		Session session = sessionFactory.getCurrentSession();
		session.update(membre);
		
	}

	@Override
	public void supprimer(int identifiant) {
		Session session = sessionFactory.getCurrentSession();
		Membre membre = session.get(Membre.class, identifiant);
		session.delete(membre);
		
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
