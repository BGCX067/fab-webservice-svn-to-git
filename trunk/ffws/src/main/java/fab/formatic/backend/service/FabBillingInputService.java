package fab.formatic.backend.service;

import java.util.Date;
import java.util.List;

import fab.formatic.backend.domain.FabService;
import fab.formatic.backend.domain.FabServiceUsed;
import fab.formatic.backend.domain.FabTariff;
import fab.formatic.web.dto.ServiceDataList;

public interface FabBillingInputService {

	FabService getServiceOutput(String serviceID, String sessionID);

	List<FabTariff> getTariffOutput(String serviceID, String sessionID,
			Date viewDate);

	List<FabServiceUsed> getServiceUsedsOutput(String accountID,
			String sessionID, String transID);

	List<FabTariff> getBillingData(String accountID, String period,
			int serviceID);

	FabServiceUsed updateServiceUsed(String accountID, int serviceUsedId,String sessionID, String transID);
	
	void persistServiceUsed(String accountID,ServiceDataList serviceDataList, String transID);
	
	List<FabTariff> findAllTariffs();

	List<FabServiceUsed> findAllFabServiceUseds();

}
