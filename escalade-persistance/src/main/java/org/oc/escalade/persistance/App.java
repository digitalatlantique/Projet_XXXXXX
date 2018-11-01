package org.oc.escalade.persistance;


import org.oc.escalade.modele.Membre;
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
		
		System.out.println(membre.getNom() + " " + membre.getPrenom());
		
        
    }
}
