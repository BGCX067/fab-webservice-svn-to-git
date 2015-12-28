package fab.formatic.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fab.formatic.backend.domain.FabLogin;
import fab.formatic.backend.domain.FabModule;
import fab.formatic.backend.domain.FabService;
import fab.formatic.backend.service.FabCustomerService;
import fab.formatic.web.dto.LoginResponse;
import fab.formatic.web.service.FabGeneralService;
import fab.formatic.web.util.FabWSConstant;

@Service(FabWSConstant.INBOUND_GENERAL_SERVICE)
public class FabInboundGeneralService implements FabGeneralService {
	
	@Autowired
	private FabCustomerService customerService;
	
	/*
	@Autowired
	private FabCustomerDao customerDao;
	
	@Autowired
	private FabServiceDao fabServiceDao;
	
	@Autowired
	private FabModuleDao fabModuleDao;
	
	@Autowired
	private FabLoginDao fabLoginDao;
	*/

	public String login(String adminEmail, String password, String serviceId) {
		
		FabLogin login=customerService.login(adminEmail, password, serviceId);
		if(login==null)
		{
			throw new RuntimeException("login gagal");
		}else{
			LoginResponse response=new LoginResponse();
			response.setReturn(login.getSessionID());
			return response.getReturn();
		}
		
		/*
		FabLogin login = new FabLogin();
		FabCustomer customer=customerDao.findByAdminEmail(adminEmail);
		if(customer==null || !password.equals(customer.getPassword())){
			login=null;
			throw new RuntimeException("Invalid Customer");
		}else{
			FabService service=fabServiceDao.findByServiceId(serviceId);
			if(service==null){
				login=null;
				throw new RuntimeException("invalid service");
			}
			login.setFabCustomer(customer);
			login.setFabService(service);
			login.setSessionID(customer.getAdminEmail()+service.getServiceID());
			
			fabLoginDao.persist(login);
		}
		LoginResponse response=new LoginResponse();
		response.setReturn(login.getSessionID());
		
		return response.getReturn();
		*/
	}

	public String getModuleInfo(String moduleId, String serviceId) {
		
		FabModule module=customerService.getModule(serviceId, moduleId);
		if(module==null){
			return null;
		}
		return module.getModuleDesc()+", "+module.getModuleName();
		/*
		FabModule module=fabModuleDao.getModuleByName(moduleId);
		FabService service=fabServiceDao.findByServiceId(serviceId);
		
		return module.getModuleDesc()+", "+service.getServiceDesc();
		*/
	}

	public String getServiceInfo(String serviceId) {
		
		FabService service=customerService.getService(serviceId);
		if(service==null){
			return null;
		}
		return service.getServiceName();
		
		/*
		FabService service=fabServiceDao.findByServiceId(serviceId);
		return service.getServiceDesc();
		*/
	}

}
