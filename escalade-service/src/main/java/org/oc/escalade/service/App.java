package org.oc.escalade.service;

import org.oc.escalade.modele.Site;
import org.oc.escalade.persistance.escaladeDAO.SiteDAOImpl;
import org.oc.escalade.service.escaladeService.SiteService;
import org.oc.escalade.service.escaladeService.SiteServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App{
	
	public static void main( String[] args ){

		ApplicationContext context = new ClassPathXmlApplicationContext("serviceContext.xml");
		
		SiteService sdi = context.getBean(SiteServiceImpl.class);
		Site dernier = (Site) sdi.chercherDernier();
		
		System.out.println(dernier.getNom());
    }
}
