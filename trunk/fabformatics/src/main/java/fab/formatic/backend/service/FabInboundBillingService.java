package fab.formatic.backend.service;

import java.util.Date;
import java.util.List;

import fab.formatic.backend.domain.FabOrder;
import fab.formatic.backend.domain.FabService;
import fab.formatic.backend.domain.FabServiceUsed;
import fab.formatic.backend.domain.FabTariff;

/**
 * @author gilang
 *
 */
public interface FabInboundBillingService {
	
	FabService getService(String sessionID, String serviceID);
	
	List<FabTariff> getTariff(String serviceID, String sessionID, Date viewDate);
	
	List<FabServiceUsed> getServiceList(String sessionID, String transID, String accountID, Date viewDate);
	
	FabOrder getOrderServiceData(String accountID, String transID);
	
	List<FabServiceUsed> getServiceUsedServiceData(FabOrder order);
	
	FabServiceUsed updateBillStatus(String transID, String accountID, Integer serviceUsedID);
	

}
