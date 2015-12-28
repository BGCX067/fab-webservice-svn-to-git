package fab.formatic.web.service;

import java.util.List;

import fab.formatic.web.dto.Module;
import fab.formatic.web.dto.OrderInputOutput;
import fab.formatic.web.dto.Package;
import fab.formatic.web.dto.ServiceAttr;
import fab.formatic.web.dto.Trans;
import fab.formatic.web.dto.exception.OrderringException;

public interface FabFullfillmentService {

	OrderInputOutput orderInput(String accountID, Module module,
			Package _package, List<ServiceAttr> serviceAttr, String serviceID,
			String sessionID, String transType) throws OrderringException;
	
	Trans orderTracking(String accountID, String serviceID, String sessionID, String transID) throws OrderringException;

}
