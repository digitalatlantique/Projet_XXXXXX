package org.oc.escalade.webapp.action;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.jboss.logging.Logger;
import org.oc.escalade.modele.Location;
import org.oc.escalade.modele.LocationId;
import org.oc.escalade.modele.Membre;
import org.oc.escalade.modele.Topo;
import org.oc.escalade.service.escaladeService.MembreService;
import org.oc.escalade.service.exception.LocationException;
import org.oc.escalade.service.locationService.LocationService;
import org.oc.escalade.service.topoService.TopoService;

import com.opensymphony.xwork2.ActionSupport;

public class ReserverAction extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, Object> session;
	private int topoId;
	private String dateFormulaire = null;
	private Logger log = Logger.getLogger(ReserverAction.class);
	private TopoService<Topo> topoService;
	private LocationService<Location> locationService;
	private LocationId locationId;
	
	public String doVerifierAuthentification() {
		
		Membre membre = (Membre) session.get("membre");
		if(membre == null) {
			
			this.addActionError("Merci de vous authentifier pour réserver un topo !");
			return LOGIN;
		}
		else return SUCCESS;
	}
	
	public String doReserverTopo() {
		
		String resultat = INPUT;
		
		List<Location> locations = locationService.listerLocationsTopo(topoId);
		Topo topo = topoService.chercher(topoId);
		
		session.put("locations", locations);
		session.put("topo", topo);
		
		if(dateFormulaire == null ) {
			return resultat;
		}
		else if(dateFormulaire.isEmpty() || topoId == 0) {
			this.addActionError("Veuillez renseigner une date de location !");
			resultat = ERROR;
		}
		else {
			
			Calendar date = creerDate(dateFormulaire);
			
			Membre membre = (Membre) session.get("membre");		

			Location location = new Location();
			location.setMembre(membre);
			location.setTopo(topo);
			location.setDate(date);
			
			try {
				locationService.locationDisponible(location);
				topo.getLocations().add(location);				
				topoService.modifier(topo);
				resultat = SUCCESS;
			}
			catch(LocationException e) {
				this.addActionError(e.getMessage());
				resultat = ERROR;
			}
		}		
		return resultat;
	}
	
	public String doMesReservations() {
		Membre membre = (Membre) session.get("membre");
		List<Location> mesLocations = locationService.listerLocationsMembre(membre.getId());
		session.put("mesLocations", mesLocations);
		return SUCCESS;
	}
	
	public String doSupprimerReservation() {
		
		Membre membre = (Membre) session.get("membre");
		
		locationService.supprimer(membre.getId(), topoId);
		return SUCCESS;
	}

	private static Calendar creerDate(String date) {
		
		String[] tab = date.split("-");
		
		int annee = Integer.parseInt(tab[0]);
		int mois = Integer.parseInt(tab[1]) - 1;
		int jour = Integer.parseInt(tab[2]);	
		
		return new GregorianCalendar(annee, mois, jour);
	}

	public int getTopoId() {
		return topoId;
	}

	public void setTopoId(int topoId) {
		this.topoId = topoId;
	}

	public String getDateFormulaire() {
		return dateFormulaire;
	}

	public void setDateFormulaire(String dateFormulaire) {
		this.dateFormulaire = dateFormulaire;
	}

	public LocationId getLocationId() {
		return locationId;
	}

	public void setLocationId(LocationId locationId) {
		this.locationId = locationId;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		
		this.session = session;
		
	}

	public void setTopoService(TopoService<Topo> topoService) {
		this.topoService = topoService;
	}

	public void setLocationService(LocationService<Location> locationService) {
		this.locationService = locationService;
	}

}
