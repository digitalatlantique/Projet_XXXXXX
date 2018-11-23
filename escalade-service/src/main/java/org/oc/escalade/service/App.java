package org.oc.escalade.service;

import org.oc.escalade.modele.Site;
import org.oc.escalade.persistance.escaladeDAO.SiteDAOImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App{
	
	public static void main( String[] args ){

		ApplicationContext context = new ClassPathXmlApplicationContext("serviceContext.xml");
		
		SiteDAOImpl sdi = context.getBean(SiteDAOImpl.class);
		Site dernier = sdi.chercherDernier();
		
		System.out.println(dernier.getNom());
    }
}
