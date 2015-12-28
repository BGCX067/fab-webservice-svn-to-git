package fab.formatic.backend.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fab.formatic.backend.dao.FabCustomerDao;
import fab.formatic.backend.dao.FabModuleDao;
import fab.formatic.backend.dao.FabOrderDao;
import fab.formatic.backend.dao.FabPackageDao;
import fab.formatic.backend.dao.FabServiceUsedDao;
import fab.formatic.backend.dao.FabStatusOrderDao;
import fab.formatic.backend.domain.FabCustomer;
import fab.formatic.backend.domain.FabModule;
import fab.formatic.backend.domain.FabOrder;
import fab.formatic.backend.domain.FabOrderModule;
import fab.formatic.backend.domain.FabService;
import fab.formatic.backend.domain.FabServiceUsed;
import fab.formatic.web.dto.Module;
import fab.formatic.web.dto.Package;
import fab.formatic.web.dto.ServiceAttr;
import fab.formatic.web.util.FabWSConstant;

@Service(FabWSConstant.FAB_CUSTOMER_ORDER_SERVICE)
public class FabCustomerOrderServiceImpl implements FabCustomerOrderService {

	@Autowired
	private FabServiceUsedDao serviceUsedDao;

	@Autowired
	private FabOrderDao orderDao;

	@Autowired
	private FabCustomerDao customerDao;

	@Autowired
	private FabModuleDao moduleDao;

	@Autowired
	private FabPackageDao packageDao;

	@Autowired
	private FabStatusOrderDao statusOrderDao;

	public FabOrder inputOrder(String accountID, Module module, Package paket,
			List<ServiceAttr> serviceAttrs, String serviceID, String sessionID, String transType, String transID) {
		if (sessionID == null || StringUtils.isEmpty(sessionID)) {
			throw new RuntimeException("no session, try to login first");
		}

		FabModule fm = moduleDao.getModuleByName(module.getName());
		FabService fs = packageDao.findPackageByName(paket.getName())
				.getFabService();
		if (fs != null || fm != null) {
			FabCustomer customer = customerDao.findByAccountId(accountID);
			if (customer == null) {
				throw new RuntimeException("invalid customer id");
			}
			FabOrder order = new FabOrder();
			FabOrderModule orderModule = new FabOrderModule();
			order.setFabCustomer(customer);
			order.setFabService(fs);
			order.setFabStatusOrder(statusOrderDao.find(1));
			order.setTransType(transType);
			order.setTransID(transID);
			order.setOrderDate(new Date());
			orderModule.setFabOrder(order);
			orderModule.setFabModule(fm);

			orderDao.persist(order);
			insertServiceUsed(order);

			FabOrder created= orderDao.find(order.getId());
			if(created==null)
				throw new RuntimeException("failed to persist new order, database error");
			return created;
		} else {
			throw new RuntimeException("failed to persist new order, parameters are invalid");
		}

	}

	public List<FabOrder> getOrder(String accountID, String serviceID,
			String sessionID, String transID) {
		if (sessionID == null || StringUtils.isEmpty(sessionID)) {
			throw new RuntimeException("no session, try to login first");
		}

		List<FabOrder> orders = orderDao.findByAccountServiceID(accountID,
				serviceID);

		if (orders == null) {
			throw new RuntimeException("no order");
		}
		
		List<FabOrder> ordersTransFiltered=new ArrayList<FabOrder>();
		for(FabOrder order:orders){
			if(order.getTransID().equals(transID))
				ordersTransFiltered.add(order);
		}
		return ordersTransFiltered;
	}

	protected void insertServiceUsed(FabOrder order) {
		FabServiceUsed serviceUsed = new FabServiceUsed();
		serviceUsed.setBillStatus(1);
		serviceUsed.setFabCustomer(order.getFabCustomer());
		serviceUsed.setServiceStart(order.getOrderDate());
		serviceUsed.setFabService(order.getFabService());

		serviceUsedDao.persist(serviceUsed);

	}

}
