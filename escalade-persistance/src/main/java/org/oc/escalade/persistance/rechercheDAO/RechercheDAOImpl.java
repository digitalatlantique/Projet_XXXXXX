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
	public List<Site> multicritere(String nom, String localite, String cotation) {
		
		Session session = sessionFactory.getCurrentSession();
		
		CriteriaBuilder cb = session.getCriteriaBuilder();
		
		CriteriaQuery<Site> cq = cb.createQuery(Site.class);

		Root<Site> site = cq.from(Site.class);
		Join<Site, Secteur> secteurs = site.join("secteurs");
		Join<Secteur, Voie> voies = secteurs.join("voies");
		
		Predicate[] predicates = new Predicate[1];
		/*-
		predicates[0] = cb.or(cb.like(site.<String> get("nom"), "%"+nom+"%"),
								cb.like(site.<String> get("localite"), "%"+localite+"%"));
		*/
		predicates[0] = cb.equal(voies.<String> get("cotation"), cotation);

		cq.select(site).where(predicates).distinct(true); 
		TypedQuery<Site> resultat= session.createQuery(cq);
		
		List<Site> sites = resultat.getResultList();
		return sites;		

	}

}















