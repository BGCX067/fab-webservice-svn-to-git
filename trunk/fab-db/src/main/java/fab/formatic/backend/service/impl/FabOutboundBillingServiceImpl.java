package fab.formatic.backend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fab.formatic.backend.dao.FabOrderDao;
import fab.formatic.backend.dao.FabServiceDao;
import fab.formatic.backend.dao.FabServiceUsedDao;
import fab.formatic.backend.domain.FabOrder;
import fab.formatic.backend.domain.FabService;
import fab.formatic.backend.domain.FabServiceUsed;
import fab.formatic.backend.service.FabOutboundBillingService;
import fab.formatic.backend.util.FabBackendHelper;

@Service(FabBackendHelper.OUTBOUND_BILLING_SERVICE)
public class FabOutboundBillingServiceImpl implements FabOutboundBillingService {
	
	@Autowired
	private FabOrderDao orderDao;
	
	@Autowired
	private FabServiceUsedDao serviceUsedDao;
	
	@Autowired
	private FabServiceDao serviceDao;

	public FabServiceUsed billTransaction(String transID, String accountID,
			Integer serviceUsedID, Integer transAmount, double discAmount,
			boolean charged) {
		List<FabOrder> orders = orderDao.findByAccountID(accountID);
		FabOrder od = orderDao.findByTransID(transID);
		FabOrder diolah = null;
		for (FabOrder o : orders) {
			if (o.getId() == od.getId()) {
				diolah = o;
			}
		}
		FabServiceUsed fsu = serviceUsedDao.find(serviceUsedID);
		
		if (!(fsu.getFabOrder().getId() == diolah.getId())) {
			return null;
		}
		
		if (charged == true) {
			if (fsu.getBillStatus() == 1) {
				fsu.setBillStatus(2);
				fsu.setDiscountAmount(discAmount);
				fsu.setTransAmount(transAmount);
				fsu = serviceUsedDao.merge(fsu);
			} else {

			}
		} else {
			fsu.setBillStatus(0);
			fsu = serviceUsedDao.merge(fsu);
		}

		return fsu;
	}

	public FabServiceUsed getBillingData(String accountID, String period,
			int serviceID) {
		FabService service = serviceDao.find(serviceID);
		List<FabOrder> orders = orderDao.findByAccountID(accountID);
		
		FabOrder order = null;
		for (FabOrder o : orders) {
			if (o.getFabService().getId() == service.getId()) {
				order = o;
			}
		}
		return serviceUsedDao.findByFabOrder(order);
	}

}
