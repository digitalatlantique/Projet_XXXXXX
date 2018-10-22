package org.oc.escalade.modele;

public class Commentaire {
	
	private int id;
	private String commentaire;
	
	public Commentaire() {
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
	
	

}
