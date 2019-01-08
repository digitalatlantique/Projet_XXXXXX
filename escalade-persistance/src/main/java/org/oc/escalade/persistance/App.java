package org.oc.escalade.persistance;


import java.util.Collection;
import java.util.List;

import org.oc.escalade.modele.Commentaire;
import org.oc.escalade.modele.Membre;
import org.oc.escalade.modele.Secteur;
import org.oc.escalade.modele.Site;
import org.oc.escalade.modele.Topo;
import org.oc.escalade.modele.Voie;
import org.oc.escalade.persistance.escaladeDAO.CommentaireDAOImpl;
import org.oc.escalade.persistance.escaladeDAO.MembreDAOImpl;
import org.oc.escalade.persistance.escaladeDAO.SecteurDAOImpl;
import org.oc.escalade.persistance.escaladeDAO.SiteDAOImpl;
import org.oc.escalade.persistance.escaladeDAO.TopoDAOImpl;
import org.oc.escalade.persistance.escaladeDAO.VoieDAOImpl;
import org.oc.escalade.persistance.rechercheDAO.RechercheDAOImpl;
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
		ApplicationContext contexte = new ClassPathXmlApplicationContext("daoContext.xml");
		
		testDesObjetMetier(contexte);
		//testRechercheDAO(contexte);		
    }
	private static void testRechercheDAO(ApplicationContext contexte) {
		
		System.out.println("-----LISTE DES SITES PAR NOM-----");
		RechercheDAOImpl rechercheDAO = contexte.getBean(RechercheDAOImpl.class);
		List<Site> sites = rechercheDAO.parNomSite("falaise");		
		for (Site site : sites) {
			System.out.println(site.getNom());
		}
		System.out.println("-----LISTE DES SITES PAR LOCALITE-----");
		sites = rechercheDAO.parLocalite("i");
		for (Site site : sites) {
			System.out.println(site.getLocalite());
		}
		System.out.println("-----LISTE DES SITES PAR CODE POSTAL-----");
		sites = rechercheDAO.parCodePostal("52150");
		for (Site site : sites) {
			System.out.println(site.getCodePostal());
		}
		System.out.println("-----LISTE DES SITES PAR MOT CLE-----");
		sites = rechercheDAO.parMotCle("vitae");
		for (Site site : sites) {
			System.out.println(site.getPresentation());
		}
		
		System.out.println("----LISTE DES SITES MULTICRITERE------");

		sites = rechercheDAO.multicritere("Falaise", "", "");
		for (Site site : sites) {
			System.out.println("=========================");
			System.out.println("Nom : " + site.getNom() + "  Localité : " + site.getLocalite() );
			
			for (Secteur secteur : site.getSecteurs()) {
				
				System.out.println("SECTEUR : " + secteur.getNom());
				
				for(Voie voie : secteur.getVoies()) {
					System.out.println("Voie Nom : " + voie.getNom() + " Cotation : " + voie.getCotation());
				}
			}
			
		}

		
	}

	private static void testDesObjetMetier(ApplicationContext contexte) {
		// Le contexte fournie le composant
	
		MembreDAOImpl mDAO = contexte.getBean(MembreDAOImpl.class);
		
		System.out.println("----------Identification d'un membre par ID-----------");
		Membre membre = mDAO.chercher(1);
		System.out.println(membre.getNom() + " " + membre.getPrenom());

		System.out.println("----------Identification d'un membre par nom et prenom-----------");
		Membre m = new Membre();
		m.setNom("cordier");
		m.setPrenom("patrick");
		membre= mDAO.verifierDoublon(m);
		System.out.println(membre.getNom() + " " + membre.getPrenom());		
		
		VoieDAOImpl vDAO = contexte.getBean(VoieDAOImpl.class);
		List<Voie> voies = vDAO.lister(1);
		
		SecteurDAOImpl sDAO = contexte.getBean(SecteurDAOImpl.class);
		List<Secteur> secteurs = sDAO.lister(1);
		
		SiteDAOImpl siteDAO = contexte.getBean(SiteDAOImpl.class);
		List<Site> sites = siteDAO.lister(1);
		Site dernierSite = siteDAO.chercherDernier();
		
		CommentaireDAOImpl cDAO = contexte.getBean(CommentaireDAOImpl.class);
		List<Commentaire> commentaires = cDAO.lister(1);
		
		TopoDAOImpl tDAO = contexte.getBean(TopoDAOImpl.class);
		List<Topo> topos = tDAO.lister(1);
		

		
		System.out.println("Les voies secteur 1 -------------------------");
		for (Voie voie2 : voies) {
			System.out.println(voie2.getNumero() + " " + voie2.getNom() + " " + voie2.getSecteur().getId());
		}
		
		System.out.println("Les secteurs site 1 ----------------------");
		for (Secteur s : secteurs) {
			System.out.println(s.getNom() + " " + s.getHauteur());
		}
		System.out.println("Dernier site  ----------------------");
		System.out.println("id : " + dernierSite.getId() + " Nom : " + dernierSite.getNom());
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
