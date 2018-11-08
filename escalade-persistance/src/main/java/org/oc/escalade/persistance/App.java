package org.oc.escalade.persistance;


import java.util.List;

import org.oc.escalade.modele.Commentaire;
import org.oc.escalade.modele.Membre;
import org.oc.escalade.modele.Secteur;
import org.oc.escalade.modele.Site;
import org.oc.escalade.modele.Topo;
import org.oc.escalade.modele.Voie;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Hello world!
 *
 */
@Component
public class App{	
	
    public static void main( String[] args ){
    	
		// Point d'entré du framework
		ApplicationContext contexte = new ClassPathXmlApplicationContext("spring_conf_persistance.xml");
		
		// Le contexte fournie le composant
		
		MembreDAOImpl mDAO = contexte.getBean(MembreDAOImpl.class);
		
		Membre membre = mDAO.chercher(1);
		
		VoieDAOImpl vDAO = contexte.getBean(VoieDAOImpl.class);
		List<Voie> voies = vDAO.lister(1);
		
		SecteurDAOImpl sDAO = contexte.getBean(SecteurDAOImpl.class);
		List<Secteur> secteurs = sDAO.lister(1);
		
		SiteDAOImpl siteDAO = contexte.getBean(SiteDAOImpl.class);
		List<Site> sites = siteDAO.lister(1);
		
		CommentaireDAOImpl cDAO = contexte.getBean(CommentaireDAOImpl.class);
		List<Commentaire> commentaires = cDAO.lister(1);
		
		TopoDAOImpl tDAO = contexte.getBean(TopoDAOImpl.class);
		List<Topo> topos = tDAO.lister(1);
		
		System.out.println(membre.getNom() + " " + membre.getPrenom());
		
		System.out.println("Les voies secteur 1 -------------------------");
		for (Voie voie2 : voies) {
			System.out.println(voie2.getNumero() + " " + voie2.getNom() + " " + voie2.getSecteur().getId());
		}
		
		System.out.println("Les secteurs site 1 ----------------------");
		for (Secteur s : secteurs) {
			System.out.println(s.getNom() + " " + s.getHauteur());
		}		
		System.out.println("Les sites membre 1 ----------------------");
		for (Site s : sites) {
			System.out.println(s.getNom());
			System.out.println(s.getPresentation());
		}	
		System.out.println("Les commentaires du site 1 ----------------------");
		for (Commentaire c : commentaires) {
			System.out.println("Commentaire de : " + c.getMembre().getNom());
			System.out.println(c.getCommentaire());
			System.out.println("Du site : " + c.getSite().getNom());
		}
		
		System.out.println("Les topos du membre 1 ----------------------");
		for (Topo c: topos) {
			System.out.println("Commentaire de : " + c.getMembre().getNom());
			System.out.println(c.getInformation());

		}	
		
    }
}
