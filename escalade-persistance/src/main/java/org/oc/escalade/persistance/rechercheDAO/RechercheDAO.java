package org.oc.escalade.persistance.rechercheDAO;

import java.util.List;

import org.oc.escalade.modele.Site;

public interface RechercheDAO {
	
	List<Site> parNomSite(String nom);
	List<Site> parLocalite(String localite);
	List<Site> parCodePostal(String codePostal);
	List<Site> parMotCle(String motCle);
	

}
