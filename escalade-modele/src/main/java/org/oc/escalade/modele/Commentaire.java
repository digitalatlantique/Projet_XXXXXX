package org.oc.escalade.modele;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="commentaire")
public class Commentaire implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="commentaire_id")
	private int id;
	
	@Column(length=1000, nullable=false)
	private String commentaire;
	
	@ManyToOne
	@JoinColumn(name="site_id", nullable=false)
	private Site site;
	
	@ManyToOne
	@JoinColumn(name="membre_id", nullable=false)
	private Membre membre;
	
	public Commentaire() {
	}
	
	public Commentaire(String commentaire, Membre membre, Site site) {
		this.commentaire = commentaire;
		this.membre = membre;
		this.site = site;
	}

	public Commentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public Membre getMembre() {
		return membre;
	}

	public void setMembre(Membre membre) {
		this.membre = membre;
	}	
	
}
