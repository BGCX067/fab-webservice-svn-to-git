package fab.formatic.web.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.ws.security.WSConstants;
import org.apache.ws.security.WSPasswordCallback;
import org.apache.ws.security.handler.WSHandlerConstants;

import fab.formatic.web.dto.GetModuleInfo;

public class FabAnonymousInterceptor extends AbstractSoapInterceptor {
	
	public FabAnonymousInterceptor()
	{
		super(Phase.USER_LOGICAL);
	}

	public void handleMessage(SoapMessage msg) throws Fault {
		@SuppressWarnings("unchecked")
		List<Object> objects=msg.getContent(List.class);
		for(Object o:objects)
		{
			if(o instanceof GetModuleInfo){
				//GetModuleInfo info=(GetModuleInfo)o;
				Map<String, Object> props=new HashMap<String, Object>();
				props.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN);
				props.put(WSHandlerConstants.USER, FabWSConstant.ANONYMOUS);
				props.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PASSWORD_TEXT);
				props.put(WSConstants.PW_TEXT, FabWSConstant.ANONYMOUS_PWD);
				props.put(WSHandlerConstants.PW_CALLBACK_CLASS, AnonymousPasswordCallback.class.getName());
				
				WSS4JInInterceptor inInterceptor=new WSS4JInInterceptor(props);
				
				msg.getInterceptorChain().add(inInterceptor);
				
			}
		}
	}
	
	class AnonymousPasswordCallback implements CallbackHandler{

		public void handle(Callback[] arg0) throws IOException,
				UnsupportedCallbackException {
			
			for(Callback c:arg0)
			{
				if(c instanceof WSPasswordCallback){
					WSPasswordCallback pc=(WSPasswordCallback)c;
					if(pc.getIdentifier().equalsIgnoreCase(FabWSConstant.ANONYMOUS))
						pc.setPassword(FabWSConstant.ANONYMOUS_PWD);
				}
			}
			
		}
		
	}

}
