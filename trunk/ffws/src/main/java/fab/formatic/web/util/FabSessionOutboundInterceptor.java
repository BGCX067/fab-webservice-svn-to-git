package fab.formatic.web.util;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.interceptor.Fault;

import fab.formatic.web.dto.LoginResponse;


public class FabSessionOutboundInterceptor extends AbstractSoapInterceptor {
	
	
	@Resource
	WebServiceContext webServiceContext;
	
	public FabSessionOutboundInterceptor(String p) {
		super(p);
	}

	public void handleMessage(SoapMessage message) throws Fault {
		@SuppressWarnings("unchecked")
		List<Object> objects=message.getContent(List.class);
		for(Object o:objects)
		{
			if(o instanceof LoginResponse){
				LoginResponse rp=(LoginResponse)o;
				String sessionID=rp.getReturn();
				HttpSession session = ((HttpServletRequest) webServiceContext
						.getMessageContext()
						.get(MessageContext.SERVLET_REQUEST)).getSession(true);
				session.setAttribute(FabWSConstant.FAB_SESSION_ID, sessionID);
				
			}else{
			
				return;
			}
		}
	}

}
