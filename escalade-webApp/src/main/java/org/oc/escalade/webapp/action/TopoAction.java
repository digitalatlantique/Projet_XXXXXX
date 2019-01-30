package org.oc.escalade.webapp.action;

import java.util.List;

import org.oc.escalade.modele.Topo;
import org.oc.escalade.service.escaladeService.EscaladeService;
import org.oc.escalade.service.topoService.TopoService;

import com.opensymphony.xwork2.ActionSupport;

public class TopoAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Topo> topos;
	private String libelle;
	private String information;
	private TopoService<Topo> topoService;
	private int topoId;
	
	public String doTopo() {
		
		topos = topoService.listerTout();
		
		return SUCCESS;
	}

	public List<Topo> getTopos() {
		return topos;
	}

	public void setTopos(List<Topo> topos) {
		this.topos = topos;
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

	public void setTopoService(TopoService<Topo> topoService) {
		this.topoService = topoService;
	}

	public int getTopoId() {
		return topoId;
	}

	public void setTopoId(int topoId) {
		this.topoId = topoId;
	}

}
