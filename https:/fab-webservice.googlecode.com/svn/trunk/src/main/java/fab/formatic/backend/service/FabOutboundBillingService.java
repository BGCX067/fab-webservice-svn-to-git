package fab.formatic.backend.service;

import fab.formatic.backend.domain.FabServiceUsed;

/**
 * @author gilang
 *
 */
public interface FabOutboundBillingService {
	
	FabServiceUsed billTransaction(String transID,String accountID, Integer serviceUsedID, 
			Integer transAmount, double discAmount, boolean charged);
	
	FabServiceUsed getBillingData(String accountID, String period, int serviceID);
	
	

}
