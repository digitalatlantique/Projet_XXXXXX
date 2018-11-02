package org.oc.escalade.persistance;

import java.util.List;

import org.hibernate.Session;
import org.oc.escalade.modele.Secteur;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class SecteurDAOImpl extends AbstractEscaladeDAO implements EscaladeDAO<Secteur> {

	@Override
	public Secteur enregistrer(Secteur secteur) {

		Session session = sessionFactory.getCurrentSession();
		session.save(secteur);		
		return secteur;
	}

	@Override
	public Secteur chercher(int identifiant) {
		
		Session session = sessionFactory.getCurrentSession();
		Secteur secteur = session.get(Secteur.class, identifiant);
		return secteur;
	}

	@Override
	public void modifier(Secteur secteur) {
		
		Session session = sessionFactory.getCurrentSession();
		session.update(secteur);
		
	}

	@Override
	public void supprimer(int identifiant) {
		
		Session session = sessionFactory.getCurrentSession();
		Secteur secteur = session.get(Secteur.class, identifiant);
		session.delete(secteur);
	}

	@Override
	public List<Secteur> lister(int identifiant) {
		
		Session session = sessionFactory.getCurrentSession();
		String requete = "FROM Secteur s WHERE site_id = :sid";
		List<Secteur> secteurs = (List<Secteur>) session.createQuery(requete).setParameter("sid", identifiant).list();
		return secteurs;
	}

}
