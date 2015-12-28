package fab.formatic.web.util;

import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceContext;

public interface FabSessionHandler {
	
	HttpSession getSessionInstance(WebServiceContext context);
	
	HttpSession newSessionInstance(WebServiceContext context);
	
	boolean isSessionOld();

}
