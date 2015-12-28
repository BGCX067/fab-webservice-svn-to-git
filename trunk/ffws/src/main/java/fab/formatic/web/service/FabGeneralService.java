package fab.formatic.web.service;

public interface FabGeneralService {
	
	String login(String adminEmail, String password, String serviceId);
	
	String getModuleInfo(String moduleId, String serviceId);
	
	String getServiceInfo(String serviceId);

}
