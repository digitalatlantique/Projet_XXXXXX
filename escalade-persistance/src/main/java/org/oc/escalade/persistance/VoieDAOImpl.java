package org.oc.escalade.persistance;

import java.util.List;

import org.hibernate.Session;
import org.oc.escalade.modele.Voie;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class VoieDAOImpl extends AbstractEscaladeDAO implements EscaladeDAO<Voie> {

	@Override
	public Voie enregistrer(Voie voie) {
		
		Session session = sessionFactory.getCurrentSession();
		session.save(voie);
		return voie;
	}

	@Override
	public Voie chercher(int identifiant) {
		
		Session session = sessionFactory.getCurrentSession();
		Voie voie = (Voie) session.get(Voie.class, identifiant);
		return voie;
	}

	@Override
	public void modifier(Voie voie) {
		
		Session session = sessionFactory.getCurrentSession();
		session.update(voie);
	}

	@Override
	public void supprimer(int identifiant) {
		
		Session session = sessionFactory.getCurrentSession();
		Voie voie = session.get(Voie.class, identifiant);
		session.delete(voie);
		
	}

	@Override
	public List<Voie> lister(int identifiant) {

		Session session = sessionFactory.getCurrentSession();
		String requete = "FROM Voie v WHERE secteur_id = :sid";
		List<Voie> voies = (List<Voie>) session.createQuery(requete).setParameter("sid", identifiant).list();
		return voies;
	}
	
	

}
