package fab.formatic.rpc.dto;

import java.rmi.Remote;
import java.rmi.RemoteException;

import javax.xml.rpc.holders.StringHolder;

public interface TelkomSpeedyPortType extends Remote{
	
	public void publishProvSpeedy(ProvSpeedy provSpeedy, StringHolder statusCode, StringHolder strMessage) throws RemoteException;
}
