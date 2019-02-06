package org.oc.escalade.webapp.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.jboss.logging.Logger;
import org.oc.escalade.modele.Membre;
import org.oc.escalade.modele.Site;
import org.oc.escalade.modele.Topo;
import org.oc.escalade.service.escaladeService.SiteService;
import org.oc.escalade.service.topoService.TopoService;

import com.opensymphony.xwork2.ActionSupport;

public class TopoFormulaireAction extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	private static Logger log = Logger.getLogger(TopoFormulaireAction.class);
	private static final long serialVersionUID = 1L;
	private String libelle = null;
	private String information = null;
	private boolean autoriserLocation;
	private TopoService<Topo> topoService;
	private Map<String, Object> session;
	private int topoId;
	private int siteId;
	
	public String doCreerTopo() {
		
		log.debug("Méthode doCreerTopo");
		
		String resultat = INPUT;
		
		if(libelle == null && information == null) {
			
			return resultat;
		}
		else if(libelle.isEmpty() || information.isEmpty()) {

			this.addActionError("Tous les champs sont requis !");
			resultat = ERROR;
		}
		else {
			Membre membre = (Membre) session.get("membre");
			Topo topo = new Topo(libelle, information, autoriserLocation, membre);
			topoService.enregistrer(topo);
			this.addActionMessage("Ajout du topo réussi ! ");
			resultat = SUCCESS;
		}		
		return resultat;
	}
	
	public String doModifierTopo() {
		
		log.debug("Methode pour modifier un topo");
		
		String resultat = INPUT;
		if(libelle == null && information == null) {
			Topo topo = topoService.chercher(topoId);
			libelle = topo.getLibelle();
			information = topo.getInformation();
			autoriserLocation = topo.isAutoriserLocation();
			return resultat;
		}
		else if(libelle.isEmpty() || information.isEmpty()) {
			this.addActionError("Tous les champs sont requis !");
			resultat = ERROR;
		}
		else {
			Topo topo = topoService.chercher(topoId);
			topo.setLibelle(libelle);
			topo.setInformation(information);
			topo.setAutoriserLocation(autoriserLocation);
			topoService.modifier(topo);
			this.addActionMessage("Modification réussie !");
			resultat = SUCCESS;
		}
		return resultat;
	}
	
	public String doSupprimerTopo() {

		topoService.supprimer(topoId);
		this.addActionMessage("Suppression réussie !");
		return SUCCESS;
	}
	
	public String doAjouterSiteAuTopo() {
		
		topoService.ajouterSiteAuTopo(topoId, siteId);		
		return SUCCESS;		
	}
	
	public String doRetirerSiteAuTopo() {
		topoService.retirerSiteAuTopo(topoId, siteId);
		return SUCCESS;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public boolean isAutoriserLocation() {
		return autoriserLocation;
	}

	public void setAutoriserLocation(boolean autoriserLocation) {
		this.autoriserLocation = autoriserLocation;
	}

	public int getTopoId() {
		return topoId;
	}

	public void setTopoId(int topoId) {
		this.topoId = topoId;
	}

	public int getSiteId() {
		return siteId;
	}

	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}

	public void setTopoService(TopoService<Topo> topoService) {
		this.topoService = topoService;
	}

	@Override
	public void setSession(Map<String, Object> session) {

		this.session = session;
		
	}
	

}
