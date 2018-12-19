package org.oc.escalade.persistance.rechercheDAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.oc.escalade.modele.Secteur;
import org.oc.escalade.modele.Site;
import org.oc.escalade.modele.Voie;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Tuple;
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
		
		CriteriaQuery<Tuple> cq = cb.createTupleQuery();

		Root<Site> site = cq.from(Site.class);
		
		Join<Site, Secteur> secteurs = site.join("secteurs");
		Join<Secteur, Voie> voies = secteurs.join("voies");
		
		ArrayList<Predicate> predicate = new ArrayList<Predicate>();
		// Gestion des prédicats avec champs vide.
		if(!nom.isEmpty()) predicate.add(cb.like(cb.lower(site.<String> get("nom")), "%"+nom.toLowerCase()+"%"));
		if(!localite.isEmpty()) predicate.add(cb.like(cb.lower(site.<String> get("localite")), "%"+localite.toLowerCase()+"%"));
		if(!cotation.isEmpty()) predicate.add(cb.equal(cb.lower(voies.<String> get("cotation")), cotation.toLowerCase()));
		Predicate[] predicateTab = new Predicate[1];
		predicate.toArray(predicateTab);
		Predicate predicateFinal = cb.or(predicateTab);

		cq.multiselect(site, secteurs, voies).where(predicateFinal).distinct(true); 
		TypedQuery<Tuple> resultat= session.createQuery(cq);
		
		List<?> temp = resultat.getResultList();
		
		List<Site> sites = new ArrayList<Site>();
		List<Secteur> secteursTemp = null;
		List<Voie> voiesTemp = null;
		Site siteCourant = null;
		Secteur secteurCourant = null;		
		
		for(int i=0; i<temp.size(); i++) {
			
			Site siteTemp =  ((Tuple) temp.get(i)).get(site);
			Secteur secteurTemp = ((Tuple) temp.get(i)).get(secteurs); // un secteur
			Voie voieTemp = ((Tuple) temp.get(i)).get(voies); // une voie

			if(siteCourant == siteTemp && secteurCourant == secteurTemp) {
				voiesTemp.add(voieTemp);
			}
			else if(siteCourant == siteTemp && secteurCourant != secteurTemp) {

				secteurCourant = secteurTemp;				
				voiesTemp = new ArrayList<Voie>();
				voiesTemp.add(voieTemp);
				secteurCourant.setVoies(voiesTemp);
				secteursTemp.add(secteurCourant);
			}
			else {
				siteCourant = siteTemp;
				secteurCourant = secteurTemp;
				
				secteursTemp = new ArrayList<Secteur>();				
				voiesTemp = new ArrayList<Voie>();
				
				voiesTemp.add(voieTemp);
				secteursTemp.add(secteurTemp);
				
				secteurCourant.setVoies(voiesTemp);
				siteCourant.setSecteurs(secteursTemp);
				sites.add(siteCourant);
			}
		}		
		return  sites;
	}
}















