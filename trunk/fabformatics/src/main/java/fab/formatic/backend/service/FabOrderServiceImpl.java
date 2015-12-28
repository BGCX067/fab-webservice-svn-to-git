package fab.formatic.backend.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fab.formatic.backend.dao.FabCustomerDao;
import fab.formatic.backend.dao.FabModuleDao;
import fab.formatic.backend.dao.FabOrderDao;
import fab.formatic.backend.dao.FabPackageDao;
import fab.formatic.backend.dao.FabServiceDao;
import fab.formatic.backend.dao.FabServiceStatusDao;
import fab.formatic.backend.dao.FabServiceUsedDao;
import fab.formatic.backend.domain.FabCustomer;
import fab.formatic.backend.domain.FabModule;
import fab.formatic.backend.domain.FabOrder;
import fab.formatic.backend.domain.FabPackage;
import fab.formatic.backend.domain.FabService;
import fab.formatic.backend.domain.FabServiceStatus;
import fab.formatic.backend.domain.FabServiceUsed;
import fab.formatic.backend.util.FabBackendHelper;
import fab.formatic.web.dto.Module;
import fab.formatic.web.dto.Package;
import fab.formatic.web.dto.ServiceAttr;

/**
 * @author gilang
 * 
 */
@Service(FabBackendHelper.ORDER_SERVICE)
public class FabOrderServiceImpl implements FabOrderService {

	@Autowired
	private FabOrderDao orderDao;

	@Autowired
	private FabCustomerDao customerDao;

	@Autowired
	private FabServiceDao serviceDao;

	@Autowired
	private FabPackageDao packageDao;

	@Autowired
	private FabModuleDao moduleDao;

	@Autowired
	private FabServiceStatusDao serviceStatusDao;

	@Autowired
	private FabServiceUsedDao serviceUsedDao;

	@Transactional
	public FabOrder orderInput(String accountID, Module module, Package paket,
			List<ServiceAttr> serviceAttr, String serviceID, String sessionID,
			String transType, String transID) {
		FabCustomer fc = customerDao.findByAccountID(accountID);
		FabService fs = serviceDao.findByServiceID(serviceID);
		if (fc == null && fs == null) {
			return null;
		}
		FabOrder order = new FabOrder();
		order.setFabCustomer(fc);
		order.setFabService(fs);

		if (!StringUtils.isEmpty(module.getName())) {
			FabModule fm = moduleDao.findByModuleName(module.getName());
			if (fm != null)
				order.getFabModules().add(fm);
			else
				order.getFabModules().add(null);
		}
		FabPackage fp = packageDao.findByPackageName(paket.getName());
		if (!fp.getFabService().equals(fs)) {
			fp.setFabService(fs);
			packageDao.merge(fp);

		} else {

		}
		order.setTransDate(new Date());
		order.setTransType(order.getTransType().fromString(transType));
		order.setTransID(transID);
		order.setTransStatus("success");
		order.setTransDesc("success di order");

		orderDao.persist(order);

		FabServiceStatus status = new FabServiceStatus();
		status.setDatabaseName("database master FAB");
		status.setFabOrder(order);
		status.setStatus(order.getTransType().toIntValue());
		serviceStatusDao.persist(status);

		FabServiceUsed used = new FabServiceUsed();
		used.setBillStatus(1);
		used.setFabOrder(order);

		serviceUsedDao.persist(used);

		return orderDao.findByTransID(transID);
	}

	public FabOrder trackOrder(String accountID, String serviceID,
			String transID) {
		FabOrder transOrder = orderDao.findByTransID(transID);
		return transOrder;

	}

	/**
	 * 
	 * 
	 protected void bulkServiceUsedPersist(FabService fs,FabModule
	 * fm,FabPackage fp) {
	 * 
	 * }
	 */

}
