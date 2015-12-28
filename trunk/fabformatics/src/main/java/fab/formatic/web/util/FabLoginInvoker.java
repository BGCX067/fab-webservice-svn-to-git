package fab.formatic.web.util;

import org.apache.cxf.message.Exchange;
import org.apache.cxf.service.invoker.Invoker;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

public class FabLoginInvoker implements Invoker {
	
	private final Invoker target;
	
	public FabLoginInvoker(Invoker target) {
		this.target=target;
	}

	public Object invoke(Exchange exchange, Object object) {
		Authentication authentication=exchange.get(Authentication.class);
		SecurityContext context=SecurityContextHolder.getContext();
		context.setAuthentication(authentication);
		try{
			return target.invoke(exchange, object);
		}finally{
			context.setAuthentication(null);
		}
		
	}

}
