package fab.formatic.backend.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fab.formatic.backend.dao.FabCustomerDao;
import fab.formatic.backend.dao.FabLoginDao;
import fab.formatic.backend.dao.FabModuleDao;
import fab.formatic.backend.dao.FabServiceDao;
import fab.formatic.backend.domain.FabCustomer;
import fab.formatic.backend.domain.FabLogin;
import fab.formatic.backend.domain.FabModule;
import fab.formatic.backend.domain.FabService;
import fab.formatic.backend.service.FabCustomerService;
import fab.formatic.backend.util.FabBackendHelper;
import fab.formatic.backend.util.FabSessionAttacher;

@Service(FabBackendHelper.CUSTOMER_SERVICE)
public class FabCustomerServiceImpl implements FabCustomerService {

	@Autowired
	private FabCustomerDao customerDao;

	@Autowired
	private FabLoginDao loginDao;

	@Autowired
	private FabServiceDao serviceDao;

	@Autowired
	private FabModuleDao moduleDao;

	public FabLogin login(String adminEmail, String serviceID) {
		if (customerDao.findByAdminEmail(adminEmail) == null
				|| serviceDao.findByServiceID(serviceID) == null) {
			throw new RuntimeException();
		}

		FabCustomer fc = customerDao.findByAdminEmail(adminEmail);
		FabService fs = serviceDao.findByServiceID(serviceID);

		FabLogin login = new FabLogin();
		login.setLoginEmail(fc.getAdminEmail());
		login.setLoginService(fs.getServiceID());
		login.setLoginTime(new Date());
		login.setSessionID(FabSessionAttacher.attachSession(new String[] {
				login.getFabCustomer().getAccountID(),
				login.getLoginTime().toString() }));

		loginDao.persist(login);

		return loginDao.findByAdminEmail(adminEmail);
	}

	public FabService getServiceInfo(String serviceID) {
		return serviceDao.findByServiceID(serviceID);
	}

	public FabModule getModuleInfo(String serviceID, String moduleName) {
		return moduleDao.findByModuleName(moduleName);
	}

}
