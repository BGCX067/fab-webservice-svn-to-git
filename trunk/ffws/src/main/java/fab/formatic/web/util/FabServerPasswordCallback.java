package fab.formatic.web.util;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.cxf.interceptor.Fault;
import org.apache.ws.security.WSPasswordCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fab.formatic.backend.dao.FabCustomerDao;
import fab.formatic.backend.domain.FabCustomer;

@Component(FabWSConstant.FAB_SERVER_PASSWORD_CALLBACK)
public class FabServerPasswordCallback implements CallbackHandler {
	
	@Autowired
	private FabCustomerDao customerDao;

	public void handle(Callback[] callbacks) throws IOException,
			UnsupportedCallbackException {
		
		for(Callback c:callbacks)
		{
			if(c instanceof WSPasswordCallback)
			{
				WSPasswordCallback pc=(WSPasswordCallback)c;
				FabCustomer fc=customerDao.findByAdminEmail(pc.getIdentifier());
				if(fc==null){
					throw new Fault(new SecurityException("invalid customer"));
				}else{
					String password=fc.getPassword();
					pc.setPassword(password);
				}
			}
		}
		
	}

}
