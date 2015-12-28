package fab.formatic.web.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;

import fab.formatic.web.dto.LoginResponse;

public class FabClientLoginResponseInterceptor extends AbstractPhaseInterceptor<Message> {
	
	public FabClientLoginResponseInterceptor() {
		// TODO :test Phase nya dulu kaka..
		super(Phase.RECEIVE);
	}

	public void handleMessage(Message arg0) throws Fault {
		@SuppressWarnings("unchecked")
		List<Object> objects=arg0.getContent(List.class);
		for(Object o:objects){
			if(o instanceof LoginResponse){
				LoginResponse response=(LoginResponse)o;
				saveSessionLogin(response);
			}
		}
	}
	
	protected void saveSessionLogin(LoginResponse response)
	{
		Properties props=new Properties();
		try {
			props.load(new FileInputStream(new File(".")));
			props.put("USER_SESSION", response.getReturn());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
