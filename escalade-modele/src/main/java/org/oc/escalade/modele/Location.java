package org.oc.escalade.modele;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="location")
public class Location implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	LocationId location_id = new LocationId();
	
	@Temporal(TemporalType.DATE)
	@Column(name="date_location")
	private Calendar date;
	
	public Location() {
	}

	public LocationId getLocationId() {
		return location_id;
	}

	public void setLocationId(LocationId location_id) {
		this.location_id = location_id;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	@Transient
	public Topo getTopo() {
		
		return location_id.getTopo();
	}
	public void setTopo(Topo topo) {
		location_id.setTopo(topo);
	}
	
	@Transient
	public Membre getMembre() {
		return location_id.getMembre();
	}
	public void setMembre(Membre membre) {
		location_id.setMembre(membre);
	}
}
