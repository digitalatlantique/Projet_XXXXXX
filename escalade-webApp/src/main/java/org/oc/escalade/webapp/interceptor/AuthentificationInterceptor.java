package org.oc.escalade.webapp.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AuthentificationInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		if(invocation.getInvocationContext().getSession().get("membre") != null) {
			return invocation.invoke();
		}
		
		else return "authentificationForm";		

	}

}
