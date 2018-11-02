package org.oc.escalade.persistance;

import java.util.List;

import org.hibernate.Session;
import org.oc.escalade.modele.Commentaire;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CommentaireDAOImpl extends AbstractEscaladeDAO implements EscaladeDAO<Commentaire> {

	@Override
	public Commentaire enregistrer(Commentaire commentaire) {
		
		Session session = sessionFactory.getCurrentSession();
		session.save(commentaire);
		return commentaire;
	}

	@Override
	public Commentaire chercher(int identifiant) {
		
		Session session = sessionFactory.getCurrentSession();
		Commentaire commentaire = session.get(Commentaire.class, identifiant);
		return commentaire;
	}

	@Override
	public void modifier(Commentaire commentaire) {
		
		Session session = sessionFactory.getCurrentSession();
		session.update(commentaire);
		
	}

	@Override
	public void supprimer(int identifiant) {
		
		Session session = sessionFactory.getCurrentSession();
		Commentaire commentaire = session.get(Commentaire.class, identifiant);
		session.delete(commentaire);
		
	}

	@Override
	public List<Commentaire> lister(int identifiant) {
		
		Session session = sessionFactory.getCurrentSession();
		String requete = "FROM Commentaire WHERE site_id = :sid";
		List<Commentaire> commentaires = session.createQuery(requete).setParameter("sid", identifiant).list();
		return commentaires;
	}

}
