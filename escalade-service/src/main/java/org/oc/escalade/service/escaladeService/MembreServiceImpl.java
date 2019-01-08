package org.oc.escalade.service.escaladeService;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.oc.escalade.modele.Membre;
import org.oc.escalade.persistance.escaladeDAO.MembreDAO;
import org.oc.escalade.utile.Cryptage;

public class MembreServiceImpl implements MembreService {
	
	MembreDAO membreDAO;	

	public void setMembreDAO(MembreDAO membreDAO) {
		this.membreDAO = membreDAO;
	}

	@Override
	public Membre enregistrer(Membre membre) {
		
		Membre membreTemp = membreDAO.verifierDoublon(membre);
		
		if(!validerEmail(membre.getEmail())) {
			throw new IllegalArgumentException("Email invalide !");
		}
		else if(membreTemp != null) {
			throw new IllegalArgumentException("Membre existant !");
		}
		else {
			String pass = Cryptage.crypter(membre.getPassword());
			membre.setPassword(pass);
			membre.setCompteValide(true);
			membreDAO.enregistrer(membre);
			return membre;
		}
		
	}

	@Override
	public Membre chercher(int identifiant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifier(Membre membre) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimer(int identifiant) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Membre> lister(int identifiant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Membre authentifier(String email, String password) {
		
		String pass = null;
		
		if(!validerEmail(email)) {
			throw new IllegalArgumentException("Email invalide !");
		}
		
		pass = Cryptage.crypter(password);
		Membre membre = (Membre) membreDAO.authentifier(email, pass);
		
		if(membre == null) {
			throw new IllegalArgumentException("Echec authentification");
		}
		return membre;
	}
	
	private static boolean validerEmail(String email) {
		 Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		 Matcher m = p.matcher(email);
		 return m.matches();
		 
	}

}
