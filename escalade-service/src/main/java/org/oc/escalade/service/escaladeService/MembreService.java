package org.oc.escalade.service.escaladeService;

public interface MembreService<T> extends EscaladeService<T> {
	
	T authentifier(String email, String password);

}
