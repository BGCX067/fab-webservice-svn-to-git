package fab.formatic.web.service;

/**
 * @author gilang
 *
 */
public interface FabGeneralService {
	
	String login(String adminEmail, String password, String serviceID);
	
	String getServiceInfo(String serviceID);
	
	String getModuleInfo(String serviceID, String moduleID);

}
