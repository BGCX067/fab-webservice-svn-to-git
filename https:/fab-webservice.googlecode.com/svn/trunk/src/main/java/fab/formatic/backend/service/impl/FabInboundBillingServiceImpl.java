package fab.formatic.backend.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fab.formatic.backend.dao.FabOrderDao;
import fab.formatic.backend.dao.FabServiceDao;
import fab.formatic.backend.dao.FabServiceUsedDao;
import fab.formatic.backend.dao.FabTariffDao;
import fab.formatic.backend.domain.FabOrder;
import fab.formatic.backend.domain.FabService;
import fab.formatic.backend.domain.FabServiceUsed;
import fab.formatic.backend.domain.FabTariff;
import fab.formatic.backend.service.FabInboundBillingService;
import fab.formatic.backend.util.FabBackendHelper;

@Service(FabBackendHelper.INBOUND_BILLING_SERVICE)
public class FabInboundBillingServiceImpl implements FabInboundBillingService {
	
	@Autowired
	private FabServiceDao serviceDao;
	
	@Autowired
	private FabOrderDao orderDao;
	
	@Autowired
	private FabTariffDao tariffDao;
	
	@Autowired
	private FabServiceUsedDao serviceUsedDao;

	public FabService getService(String sessionID, String serviceID) {
		return serviceDao.findByServiceID(serviceID);
	}

	public List<FabTariff> getTariff(String serviceID, String sessionID,
			Date viewDate) {
		List<FabTariff> fabTariffs=new ArrayList<FabTariff>();
		FabService fabService=serviceDao.findByServiceID(serviceID);
		if(viewDate!=null){
			FabTariff last=tariffDao.findByLastDate(fabService);
			fabTariffs.add(last);
		}else{
			List<FabTariff> found=tariffDao.findByFabService(fabService);
			for(FabTariff ft:found){
				fabTariffs.add(ft);
			}
		}
		return fabTariffs;
	}

	public FabServiceUsed getServiceList(String sessionID, String transID,String accountID) {
		FabOrder order=orderDao.findByTransID(transID);
		FabServiceUsed used=serviceUsedDao.findByFabOrder(order);
		return used;
	}

	public FabOrder getOrderServiceData(String accountID, String transID) {
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
		FabServiceUsed used=serviceUsedDao.findByFabOrder(result);
		if(used.getBillStatus()==2){
			used.setBillStatus(3);
		}else if(used.getBillStatus()==3){
			used.setBillStatus(4);
		}else{
		
		}
		return serviceUsedDao.merge(used);
	}

	public FabServiceUsed getServiceUsedServiceData(FabOrder order) {
		FabServiceUsed used=serviceUsedDao.findByFabOrder(order);
		return used;
	}

}
