package fab.formatic.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fab.formatic.backend.domain.FabLogin;
import fab.formatic.backend.domain.FabModule;
import fab.formatic.backend.domain.FabService;
import fab.formatic.backend.service.FabCustomerService;
import fab.formatic.web.service.FabGeneralService;
import fab.formatic.web.util.FabWSHelper;

@Service(FabWSHelper.GENERAL_SERVICE)
public class FabGeneralServiceImpl implements FabGeneralService {

	@Autowired
	private FabCustomerService customerService;
	
	public String login(String adminEmail, String password, String serviceID) {
		FabLogin login=customerService.login(adminEmail, serviceID);
		return login.getSessionID();
	}

	public String getServiceInfo(String serviceID) {
		FabService service=customerService.getServiceInfo(serviceID);
		return service.getServiceDesc();
	}

	public String getModuleInfo(String serviceID, String moduleID) {
		FabModule module=customerService.getModuleInfo(serviceID, moduleID);
		return module.getModuleDesc();
	}

}
