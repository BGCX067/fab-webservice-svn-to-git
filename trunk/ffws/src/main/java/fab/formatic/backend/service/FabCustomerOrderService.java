package fab.formatic.backend.service;

import java.util.List;

import fab.formatic.backend.domain.FabOrder;
import fab.formatic.web.dto.Module;
import fab.formatic.web.dto.Package;
import fab.formatic.web.dto.ServiceAttr;

public interface FabCustomerOrderService {

	FabOrder inputOrder(String accountID, Module module, Package paket,
			List<ServiceAttr> serviceAttrs, String ServiceID, String sessionID, String transType,
			String transID);

	List<FabOrder> getOrder(String accountID, String serviceID,
			String sessionID, String transID);

}
