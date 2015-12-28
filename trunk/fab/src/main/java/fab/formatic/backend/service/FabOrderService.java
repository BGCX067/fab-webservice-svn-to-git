package fab.formatic.backend.service;

import java.util.List;

import fab.formatic.backend.domain.FabOrder;
import fab.formatic.web.dto.Module;
import fab.formatic.web.dto.ServiceAttr;
import fab.formatic.web.dto.Package;

/**
 * @author gilang
 *
 */
public interface FabOrderService {

	FabOrder orderInput(String accountID, Module module, Package paket,
			List<ServiceAttr> serviceAttr, String serviceID, String sessionID,
			String transType, String transID);

	FabOrder trackOrder(String accountID, String serviceID, String transID);

}
