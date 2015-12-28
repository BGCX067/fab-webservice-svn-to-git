package fab.formatic.backend.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fab.formatic.backend.dao.FabCustomerDao;
import fab.formatic.backend.dao.FabOrderDao;
import fab.formatic.backend.dao.FabServiceDao;
import fab.formatic.backend.dao.FabServiceUsedDao;
import fab.formatic.backend.dao.FabTariffDao;
import fab.formatic.backend.domain.FabCustomer;
import fab.formatic.backend.domain.FabOrder;
import fab.formatic.backend.domain.FabService;
import fab.formatic.backend.domain.FabServiceUsed;
import fab.formatic.backend.domain.FabTariff;
import fab.formatic.web.dto.ServiceDataList;
import fab.formatic.web.util.FabWSConstant;

@Service(FabWSConstant.FAB_BILLING_SERVICE)
public class FabBillingInputServiceImpl implements FabBillingInputService {

	@Autowired
	private FabServiceDao serviceDao;

	@Autowired
	private FabServiceUsedDao serviceUsedDao;

	@Autowired
	private FabTariffDao tariffDao;

	@Autowired
	private FabOrderDao orderDao;

	private FabCustomerDao customerDao;

	public FabService getServiceOutput(String serviceID, String sessionID) {
		return serviceDao.findByServiceId(serviceID);
	}

	public List<FabTariff> getTariffOutput(String serviceID, String sessionID,Date viewDate){
		List<FabTariff> tariffs = tariffDao.findByDate(viewDate);
		return tariffs;
	}

	public List<FabServiceUsed> getServiceUsedsOutput(String accountID,
			String sessionID, String transID) {
		FabOrder order = orderDao.findByIdTrans(transID);
		FabCustomer customer = customerDao.findByAccountId(accountID);
		List<FabServiceUsed> fabServiceUseds = new ArrayList<FabServiceUsed>();
		for (FabServiceUsed used : serviceUsedDao.findAll()) {
			if (used.getFabCustomer().equals(customer)
					&& used.getFabService().equals(order.getFabService())) {
				fabServiceUseds.add(used);
			}
		}

		return fabServiceUseds;
	}

	public List<FabTariff> getBillingData(String accountID, String period,
			int serviceID) {
		List<FabTariff> tariffs = tariffDao.findByPeriod(period);

		return tariffs;
	}

	public FabServiceUsed updateServiceUsed(String accountID,
			int serviceUsedId, String sessionID, String transID) {

		FabServiceUsed used = serviceUsedDao.find(Integer
				.valueOf(serviceUsedId));
		if (used.getBillStatus() == 1) {
			used.setBillStatus(2);
		} else if (used.getBillStatus() == 2) {
			used.setBillStatus(3);
		} else if (used.getBillStatus() == 3) {
			used.setBillStatus(4);
		}else{
			
		}
		
		if (used.getServiceEnd().after(new Date())) {
			used.setBillStatus(0);
		}
		return serviceUsedDao.merge(used);

	}

	public void persistServiceUsed(String accountID, ServiceDataList serviceDataList, String transID) {
		FabCustomer customer = customerDao.findByAccountId(accountID);
		FabOrder order = orderDao.findByIdTrans(transID);
		
		FabService service = customer.getFabService();		
		
		FabServiceUsed serviceUsed = new FabServiceUsed();
		serviceUsed.setTransAmount(serviceDataList.getTransAmt().getIntValue());
		serviceUsed.setBillStatus(1);
		serviceUsed.setDiscountAmount(serviceDataList.getDiscAmount().getDoubleValue());
		serviceUsed.setFabCustomer(customer);
		serviceUsed.setIsExceed(false);
		serviceUsed.setPaymentAmount(0);
		serviceUsed.setPaymentDate(new Date());
		serviceUsed.setPaymentDiscount(0);
		serviceUsed.setPaymentPeriod(null);
		serviceUsed.setRevCode(null);
		serviceUsed.setServiceAmount(0);
		serviceUsed.setServiceCount(0);
		serviceUsed.setServiceStart(new Date());
		serviceUsed.setServiceEnd(new Date());		
		serviceUsed.setTransDate(order.getOrderDate());	
		
		serviceUsed.setFabService(service);
		order.setTransType(serviceDataList.getTransName());
		
		serviceUsedDao.persist(serviceUsed);
		orderDao.merge(order);
	}
	
	public List<FabTariff> findAllTariffs()
	{
		return tariffDao.findAll();
	}

	public List<FabServiceUsed> findAllFabServiceUseds() {
		return serviceUsedDao.findAll();
	}

	

}
