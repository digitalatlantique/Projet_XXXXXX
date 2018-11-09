package org.oc.escalade.persistance.rechercheDAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.oc.escalade.modele.Site;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class RechercheDAOImpl implements RechercheDAO {
	
	protected SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<Site> parNomSite(String nom) {

		Session session = sessionFactory.getCurrentSession();
		String req = "FROM Site s WHERE lower(s.nom) like '%"+ nom.toLowerCase() +"%'";
		List<Site> sites = session.createQuery(req).list();		
		return sites;
	}

	public List<Site> parLocalite(String localite) {
		Session session = sessionFactory.getCurrentSession();
		String req = "FROM Site s WHERE lower(s.localite) like '%"+ localite.toLowerCase() +"%'";
		List<Site> sites = session.createQuery(req).list();		
		return sites;
	}

	public List<Site> parCodePostal(String codePostal) {
		Session session = sessionFactory.getCurrentSession();
		String req = "FROM Site s WHERE s.codePostal = :cp";
		List<Site> sites = session.createQuery(req).setParameter("cp", codePostal).list();		
		return sites;
	}

	public List<Site> parMotCle(String motCle) {
		Session session = sessionFactory.getCurrentSession();
		String req = "FROM Site s WHERE lower(s.presentation) like '%"+ motCle.toLowerCase() +"%'";
		List<Site> sites = session.createQuery(req).list();		
		return sites;
	}

}
