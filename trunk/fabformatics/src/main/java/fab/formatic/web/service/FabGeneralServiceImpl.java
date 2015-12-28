package fab.formatic.web.service;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fab.formatic.backend.domain.FabLogin;
import fab.formatic.backend.domain.FabModule;
import fab.formatic.backend.domain.FabService;
import fab.formatic.backend.service.FabCustomerService;
import fab.formatic.web.util.FabWSHelper;

/**
 * @author gilang
 *
 */
@Service(FabWSHelper.GENERAL_SERVICE)
public class FabGeneralServiceImpl implements FabGeneralService {

	
	@Autowired
	private FabCustomerService customerService;

	public String login(String adminEmail, String password, String serviceID) {
		if (password == null || StringUtils.isEmpty(password)) {
			
			throw new RuntimeException("login failed");
		}

		FabLogin login = customerService.login(adminEmail, serviceID);
		;
		return login.getSessionID();
	}

	public String getModuleInfo(String serviceID, String moduleID) {
		String msg="";
		FabModule fm=customerService.getModuleInfo(serviceID, moduleID);
		if(fm==null){
			msg+="unavailable module at "+serviceID;
			;
		}else{
			msg+=fm.getModuleName()+". "+fm.getModuleDesc();
			
		}
		return msg;
	}

	public String getServiceInfo(String serviceID) {
		String msg="";
		FabService fs=customerService.getServiceInfo(serviceID);
		if(fs==null){
			msg+="service not found";
			
		}else{
			msg+=fs.getServiceName()+". Description: "+fs.getServiceDesc();
			
		}
		return msg;
	}

}
