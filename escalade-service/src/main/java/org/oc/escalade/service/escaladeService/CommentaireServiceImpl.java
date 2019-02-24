package org.oc.escalade.service.escaladeService;

import java.util.List;

import org.oc.escalade.modele.Commentaire;
import org.oc.escalade.persistance.escaladeDAO.EscaladeDAO;

public class CommentaireServiceImpl implements EscaladeService<Commentaire> {
	
	private EscaladeDAO<Commentaire> commentaireDAO;

	@Override
	public Commentaire enregistrer(Commentaire commentaire) {
		commentaireDAO.enregistrer(commentaire);
		return commentaire;
	}

	@Override
	public Commentaire chercher(int identifiant) {
		
		return commentaireDAO.chercher(identifiant);
	}

	@Override
	public void modifier(Commentaire commentaire) {

		commentaireDAO.modifier(commentaire);
		
	}

	@Override
	public void supprimer(int identifiant) {
		
		commentaireDAO.supprimer(identifiant);
		
	}

	@Override
	public List<Commentaire> lister(int identifiant) {
		
		return commentaireDAO.lister(identifiant);
	}

	public void setCommentaireDAO(EscaladeDAO<Commentaire> commentaireDAO) {
		this.commentaireDAO = commentaireDAO;
	}

}
