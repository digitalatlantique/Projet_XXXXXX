package org.oc.escalade.persistance;

import org.hibernate.SessionFactory;

public class AbstractEscaladeDAO {

	protected SessionFactory sessionFactory;	


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
