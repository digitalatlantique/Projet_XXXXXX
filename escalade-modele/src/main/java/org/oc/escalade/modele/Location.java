package org.oc.escalade.modele;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="location")
public class Location {
	
	@Id
	LocationId location_id;
	
	@Temporal(TemporalType.DATE)
	@Column(name="debut_location")
	private Date debutLocation;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fin_location")
	private Date finLocation;
	
	public Location() {
	}

	public LocationId getLocationId() {
		return location_id;
	}

	public void setLocationId(LocationId location_id) {
		this.location_id = location_id;
	}

	public Date getDebutLocation() {
		return debutLocation;
	}

	public void setDebutLocation(Date debutLocation) {
		this.debutLocation = debutLocation;
	}

	public Date getFinLocation() {
		return finLocation;
	}

	public void setFinLocation(Date finLocation) {
		this.finLocation = finLocation;
	}
}
