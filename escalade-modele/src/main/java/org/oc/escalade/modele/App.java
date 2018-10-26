package org.oc.escalade.modele;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        
        try {
        	
        	
        	Membre mb = (Membre) session.load(Membre.class, 2);
        	
        	System.out.println("Membre N°2 : " + mb.getNom() + " " + mb.getPrenom());
        	tx.commit();
        }
        catch(Exception e) {
        	tx.rollback();
        }
        finally {
        	session.close();
        }
       
    }
}
