package fab.formatic.backend.service;

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
import fab.formatic.backend.util.FabBackendHelper;

/**
 * @author gilang
 * 
 */
@Service(FabBackendHelper.CUSTOMER_SERVICE)
public class FabCustomerServiceImpl implements FabCustomerService {

	@Autowired
	private FabCustomerDao customerDao;

	@Autowired
	private FabServiceDao serviceDao;

	@Autowired
	private FabLoginDao loginDao;

	@Autowired
	private FabModuleDao moduleDao;

	public FabLogin login(String adminEmail, String serviceID) {

		if (customerDao.findByAccountID(adminEmail) == null
				|| serviceDao.findByServiceID(serviceID) == null) {

			throw new RuntimeException("login failed");
		}

		FabCustomer fc = customerDao.findByAccountID(adminEmail);
		FabService fs = serviceDao.findByServiceID(serviceID);

		FabLogin login = new FabLogin();
		login.setLoginEmail(fc.getAdminEmail());
		login.setLoginService(fs.getServiceID());
		login.setLoginTime(new Date());

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
