package org.oc.escalade.persistance.escaladeDAO;

import java.util.List;

import org.hibernate.Session;
import org.oc.escalade.modele.Secteur;
import org.oc.escalade.modele.Site;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class SiteDAOImpl extends AbstractEscaladeDAO implements SiteDAO<Site> {

	@Override
	public Site enregistrer(Site site) {
		
		Session session = sessionFactory.getCurrentSession();
		session.save(site);		
		return site;
	}

	@Override
	public Site chercher(int identifiant) {
		
		Session session = sessionFactory.getCurrentSession();
		Site site = session.get(Site.class, identifiant);
		return site;
	}

	@Override
	public void modifier(Site site) {
		
		Session session = sessionFactory.getCurrentSession();
		session.update(site);
		
	}

	@Override
	public void supprimer(int identifiant) {
		
		Session session = sessionFactory.getCurrentSession();
		Site site = session.get(Site.class, identifiant);
		session.delete(site);
		
	}

	/**
	 * Liste les sites d'un membre
	 */
	@Override
	public List<Site> lister(int identifiant) {
		
		Session session = sessionFactory.getCurrentSession();
		String requete = "FROM Site s WHERE membre_id = :mid";
		List<Site> sites = (List<Site>) session.createQuery(requete).setParameter("mid", identifiant).list();
		return sites;
	}

	@Override
	public Site chercherDernier() {
		
		Session session = sessionFactory.getCurrentSession();
		String requete = "SELECT max(s.id) FROM Site s ";
		Site site = null;
		int identifiantMax = (int) session.createQuery(requete).getSingleResult();
		
		while(site == null && identifiantMax != 0) {
			 
			site = this.chercher(identifiantMax);
			identifiantMax--;
		}		 
		return site;
	}

}
