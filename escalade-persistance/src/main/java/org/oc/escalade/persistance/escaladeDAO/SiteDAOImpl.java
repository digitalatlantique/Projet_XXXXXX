package org.oc.escalade.persistance.escaladeDAO;

import java.util.List;

import org.hibernate.Session;
import org.oc.escalade.modele.Secteur;
import org.oc.escalade.modele.Site;
import org.oc.escalade.modele.Topo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class SiteDAOImpl extends AbstractEscaladeDAO implements SiteDAO<Site> {
	
	public SiteDAOImpl() {

	}

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
		List<Site> sites = session.createQuery(requete).setParameter("mid", identifiant).list();
		return sites;
	}
	/**
	 * Retourne le dernier site créer
	 */
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
	/**
	 * Liste tous les sites d'un topo
	 */
	@Override
	public List<Site> listerSitesTopo(int identifiantTopo) {
		Session session = sessionFactory.getCurrentSession();
		String requete = "SELECT s FROM Site s JOIN s.topos t WHERE t.id = :tid";
		List<Site> sites = session.createQuery(requete).setParameter("tid", identifiantTopo).list();
		return sites;
	}
}
