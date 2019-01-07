package org.oc.escalade.webapp.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.oc.escalade.modele.Membre;
import org.oc.escalade.service.escaladeService.MembreService;

import com.opensymphony.xwork2.ActionSupport;

public class MembreAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, Object> session;
	private MembreService membreService;
	private Membre membre = null;
	private String email = null;
	private String password = null;

	public String doAuthentification() {
		
		membre = (Membre) session.get("membre");
		
		if(membre != null) {
			return SUCCESS;
		}
		else if(email == null && password == null) {
			return INPUT;
		}
		else if(email.isEmpty() && password.isEmpty()) {
			this.addActionError("Les champs sont requis !");
			return INPUT;
		}
		else {
			try {
				membre = (Membre) membreService.authentifier(email, password);
				session.put("membre", membre);
				return SUCCESS;
			}
			catch(IllegalArgumentException e) {
				this.addActionError(e.getMessage());
				return INPUT;
			}
		}		
	}
	
	public String doDeconnexion() {
		this.session.remove("membre");
		return SUCCESS;
	}
	
	public void setMembreService(MembreService membreService) {
		this.membreService = membreService;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
		
	}
	
}
