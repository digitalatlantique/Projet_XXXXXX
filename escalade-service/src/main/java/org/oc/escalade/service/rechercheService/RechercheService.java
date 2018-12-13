package org.oc.escalade.service.rechercheService;

import java.util.List;

import org.oc.escalade.modele.Site;

public interface RechercheService {

	List<Site> parNomSite(String nom);
	List<Site> parLocalite(String localite);
	List<Site> parCodePostal(String codePostal);
	List<Site> parMotCle(String motCle);
	List<Site> multicritere(String nom, String localite, String cotation);	
}
