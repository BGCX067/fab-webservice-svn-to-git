package fab.formatic.rpc;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;
import javax.xml.rpc.holders.StringHolder;

import org.springframework.remoting.jaxrpc.ServletEndpointSupport;

import fab.formatic.rpc.dto.ProvSpeedy;
import fab.formatic.rpc.dto.TelkomSpeedyPortType;
import fab.formatic.rpc.service.TelkomFullFilmentService;
import fab.formatic.rpc.util.TelkomRPCUtil;

@SuppressWarnings("deprecation")
public class TelkomService extends ServletEndpointSupport implements TelkomSpeedyPortType {
	
	private TelkomFullFilmentService fullFilmentService;
	
	@Override
	protected void onInit() throws ServiceException {
		fullFilmentService=(TelkomFullFilmentService)getApplicationContext().getBean(TelkomRPCUtil.FULLFILMENT);
	}

	public void publishProvSpeedy(ProvSpeedy provSpeedy, StringHolder statusCode, StringHolder strMessage) throws RemoteException {
		fullFilmentService.orderInput(provSpeedy);
		statusCode.value="status Value";
		strMessage.value="message value";
	}

}
