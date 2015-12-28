package fab.formatic.backend.service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fab.formatic.backend.dao.FabOrderDao;
import fab.formatic.backend.dao.FabServiceDao;
import fab.formatic.backend.dao.FabServiceUsedDao;
import fab.formatic.backend.dao.FabTariffDao;
import fab.formatic.backend.domain.FabOrder;
import fab.formatic.backend.domain.FabService;
import fab.formatic.backend.domain.FabServiceUsed;
import fab.formatic.backend.domain.FabTariff;
import fab.formatic.backend.util.FabBackendHelper;

/**
 * @author gilang
 *
 */
@Service(FabBackendHelper.INBOUND_BILLING_SERVICE)
public class FabInboundBillingServiceImpl implements FabInboundBillingService {
	
	@Autowired
	private FabServiceDao serviceDao;
	
	@Autowired
	private FabTariffDao tariffDao;
	
	@Autowired
	private FabOrderDao orderDao;
	
	@Autowired
	private FabServiceUsedDao serviceUsedDao; 

	public FabService getService(String sessionID, String serviceID) {
		return serviceDao.findByServiceID(serviceID);
	}

	public List<FabTariff> getTariff(String serviceID, String sessionID,
			Date viewDate) {
		FabService fs=serviceDao.findByServiceID(serviceID);
		List<FabTariff> tariffs=tariffDao.findByFabService(fs);
		return tariffs;
	}

	public List<FabServiceUsed> getServiceList(String sessionID, String transID,
			String accountID, Date viewDate) {
		FabOrder order=orderDao.findByTransID(transID);
		List<FabServiceUsed> useds=serviceUsedDao.findByFabOrder(order);
		return useds;
	}

	public FabOrder getOrderServiceData(String accountID,String transID) {
		List<FabOrder> orders=orderDao.findByAccountID(accountID);
		FabOrder order=orderDao.findByTransID(transID);
		FabOrder result=null;
		Iterator<FabOrder> iter=orders.iterator();
		while(iter.hasNext()){
			FabOrder next=iter.next();
			if(next.getId()==order.getId()){
				result=next;
				break;
			}
		}
		return result;
	}

	public List<FabServiceUsed> getServiceUsedServiceData(FabOrder order) {
		return serviceUsedDao.findByFabOrder(order);
	}

	@Transactional
	public FabServiceUsed updateBillStatus(String transID, String accountID,
			Integer serviceUsedID) {
		List<FabOrder> orders=orderDao.findByAccountID(accountID);
		FabOrder order=orderDao.findByTransID(transID);
		FabOrder result=null;
		for(FabOrder o:orders)
		{
			if(o.getId()==order.getId()){
				result=o;
			}
		}
		List<FabServiceUsed> useds=serviceUsedDao.findByFabOrder(result);
		FabServiceUsed us=null;
		for(FabServiceUsed fsu:useds){
			if(fsu.getId()==serviceUsedID){
				us=fsu;
			}
		}
		if(us.getBillStatus()==2){
			us.setBillStatus(3);
		}else{
			us.setBillStatus(us.getBillStatus());
		}		
		return serviceUsedDao.merge(us);
	}

}
