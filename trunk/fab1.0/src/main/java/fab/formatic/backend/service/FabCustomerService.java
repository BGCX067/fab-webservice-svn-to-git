package fab.formatic.backend.service;

import fab.formatic.backend.domain.FabLogin;
import fab.formatic.backend.domain.FabModule;
import fab.formatic.backend.domain.FabService;

/**
 * @author gilang
 *
 */
public interface FabCustomerService {
	

	FabLogin login(String adminEmail, String serviceID);
	
	FabService getServiceInfo(String serviceID);
	
	FabModule getModuleInfo(String serviceID, String moduleName);

}
