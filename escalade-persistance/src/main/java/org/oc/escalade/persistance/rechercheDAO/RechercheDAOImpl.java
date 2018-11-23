package org.oc.escalade.persistance.rechercheDAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.oc.escalade.modele.Secteur;
import org.oc.escalade.modele.Site;
import org.oc.escalade.modele.Voie;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;

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

	@Override
	public List<Site> multicritere(String nom, String localite, String cotationMin, String cotationMax) {
		
		Session session = sessionFactory.getCurrentSession();
	
		boolean premierArg = true;
		String req = 	"SELECT DISTINCT si From Site AS si JOIN si.secteurs AS se JOIN  se.voies AS v "; 

		
		if(nom != null) {		
			req += "WHERE lower(si.nom) like '%"+ nom.toLowerCase() +"%' ";
			premierArg = false;
		}
		if(localite != null) {
			if(premierArg) {
				req += "WHERE lower(si.localite) like '%"+ localite.toLowerCase() +"%' ";
				premierArg = false;
			}
			else {
				req += "AND lower(si.localite) like '%"+ localite.toLowerCase() +"%' ";
			}
		}

		if(cotationMin != null && cotationMax != null) {
			if(premierArg) {
				req += "WHERE v.cotation BETWEEN '" + cotationMin + "' AND '" + cotationMax + "' ";
				premierArg = false;
			}
			else {
				req += "AND v.cotation BETWEEN '" + cotationMin + "' AND '" + cotationMax + "' ";
			}
		}
		
		return (List<Site>) session.createQuery(req).getResultList();		

	}

}















