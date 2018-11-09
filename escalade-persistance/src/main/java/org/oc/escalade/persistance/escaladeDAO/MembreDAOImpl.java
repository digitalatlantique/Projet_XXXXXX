package org.oc.escalade.persistance.escaladeDAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.oc.escalade.modele.Membre;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class MembreDAOImpl extends AbstractEscaladeDAO implements EscaladeDAO<Membre> {
	

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

	@Override
	public List<Membre> lister(int identifiant) {
		// TODO Auto-generated method stub
		return null;
	}


}
