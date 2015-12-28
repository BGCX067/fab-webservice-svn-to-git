package fab.formatic.web.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

public class FabSessionHandlerFactory implements FabSessionHandler {
	
	private boolean sessionOld=true;
	
	public static FabSessionHandler sessionHandler=new FabSessionHandlerFactory();
	
	private FabSessionHandlerFactory(){}
	
	public static FabSessionHandler getSessionHandlerInstance()
	{
		return sessionHandler;
	}

	public HttpSession getSessionInstance(WebServiceContext context) {
		HttpSession session=((HttpServletRequest)context.getMessageContext().get(MessageContext.SERVLET_REQUEST)).getSession();
		return session;
	}

	public HttpSession newSessionInstance(WebServiceContext context) {
		HttpSession session=((HttpServletRequest)context.getMessageContext().get(MessageContext.SERVLET_REQUEST)).getSession(true);
		sessionOld=false;
		return session;
	}

	public boolean isSessionOld() {
		return sessionOld;
	}

}
