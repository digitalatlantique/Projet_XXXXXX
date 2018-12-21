package org.oc.escalade.service;

import java.util.List;

import org.oc.escalade.modele.Secteur;
import org.oc.escalade.modele.Site;
import org.oc.escalade.modele.Voie;
import org.oc.escalade.persistance.escaladeDAO.SiteDAOImpl;
import org.oc.escalade.service.escaladeService.SiteService;
import org.oc.escalade.service.escaladeService.SiteServiceImpl;
import org.oc.escalade.service.rechercheService.RechercheService;
import org.oc.escalade.service.rechercheService.RechercheServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App{
	
	public static void main( String[] args ){

		ApplicationContext context = new ClassPathXmlApplicationContext("serviceContext.xml");
		
		SiteService sdi = context.getBean(SiteServiceImpl.class);
		Site dernier = (Site) sdi.chercherDernier();		
		System.out.println(dernier.getNom());
		
		RechercheService rs = context.getBean(RechercheServiceImpl.class);
		List<Site> sites = rs.parNomSite("roche");
		for (Site site : sites) {
			System.out.println(site.getNom());
		}
		System.out.println("==========Recherche multi============");
		sites = rs.multicritere("Falaise", "", "");
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
}
