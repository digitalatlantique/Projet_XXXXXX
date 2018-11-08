package org.oc.escalade.modele;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name="location")
public class Location {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int location_id;
	
	private boolean libre;
	
	@Temporal(TemporalType.DATE)
	@Column(name="debut_location")
	private Date debutLocation;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fin_location")
	private Date finLocation;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="topo_id", nullable=false)
	private Topo topo;
	
	@ManyToOne
	@JoinColumn(name="membre_id", nullable=false)
	private Membre membre;
	
	public Location() {
	}
	
	

}
