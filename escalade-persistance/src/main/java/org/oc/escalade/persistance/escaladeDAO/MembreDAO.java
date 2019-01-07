package org.oc.escalade.persistance.escaladeDAO;

public interface MembreDAO<T> extends EscaladeDAO<T> {
	
	T authentifier(String email, String password);

}
