package fab.formatic.web.util;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.handler.MessageContext;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.Phase;

import fab.formatic.web.dto.GetModuleInfo;
import fab.formatic.web.dto.Login;


public class FabSessionInboundInterceptor extends AbstractSoapInterceptor {

	@Resource
	WebServiceContext webServiceContext;

	public FabSessionInboundInterceptor() {
		super(Phase.PRE_PROTOCOL);
	}

	public void handleMessage(SoapMessage arg0) throws Fault {
		@SuppressWarnings("unchecked")
		List<Object> objects = arg0.getContent(List.class);
		for (Object obj : objects) {
			if (!(obj instanceof Login) && !(obj instanceof GetModuleInfo)) {
				HttpSession session = ((HttpServletRequest) webServiceContext
						.getMessageContext()
						.get(MessageContext.SERVLET_REQUEST)).getSession();

				if (session == null) {
					throw new Fault(new WebServiceException("no session "));
				}
				String sessionID = (String) session
						.getAttribute(FabWSConstant.FAB_SESSION_ID);
				if (sessionID == null) {
					throw new Fault(new WebServiceException(
							"session id null, login lagi deh "));
				} else {
					return;
				}
			}
		}

	}
}
