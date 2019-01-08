package org.oc.escalade.webapp.action;

import org.oc.escalade.modele.Membre;
import org.oc.escalade.service.escaladeService.MembreService;

import com.opensymphony.xwork2.ActionSupport;

public class InscriptionAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MembreService membreService;
	
	private String nom = null;
	private String prenom = null;
	private String email = null;
	private String password = null;
	private boolean compteValide = false;
	
	public String doInscription() {
		
		String resultat = INPUT;
		
		if(nom == null && prenom == null && email== null) {
			return resultat;
		}
		else if(nom.isEmpty() || prenom.isEmpty() || email.isEmpty() || password.isEmpty()) {
			this.addActionError("Tous les champs sont requis !");
			return resultat;
		}
		else {
			Membre membre = new Membre(nom, prenom, email, password);
			
			try {
				membreService.enregistrer(membre);
				this.addActionMessage("Inscription réussi !");
				resultat = SUCCESS;
				return resultat;
			}
			catch(IllegalArgumentException e){
				this.addActionError(e.getMessage());
				return resultat;
			}

		}
		
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setMembreService(MembreService membreService) {
		this.membreService = membreService;
	}

}
