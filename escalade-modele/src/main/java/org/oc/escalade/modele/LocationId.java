package org.oc.escalade.modele;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class LocationId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name="topo_id")
	private Topo topo;
	
	@ManyToOne
	@JoinColumn(name="membre_id")
	private Membre membre;

	public Topo getTopo() {
		return topo;
	}

	public void setTopo(Topo topo) {
		this.topo = topo;
	}

	public Membre getMembre() {
		return membre;
	}

	public void setMembre(Membre membre) {
		this.membre = membre;
	}
	
	public boolean equals(Object o) {
		
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LocationId locationId = (LocationId) o;

        if (topo != null ? !topo.equals(locationId.topo) : locationId.topo != null) {
        	return false;
        
        }
        if (membre != null ? !membre.equals(locationId.membre) : locationId.membre != null)
            return false;

        return true;
    }

    public int hashCode() {
        int result;
        result = (topo != null ? topo.hashCode() : 0);
        result = 31 * result + (membre != null ? membre.hashCode() : 0);
        return result;
    }
}
