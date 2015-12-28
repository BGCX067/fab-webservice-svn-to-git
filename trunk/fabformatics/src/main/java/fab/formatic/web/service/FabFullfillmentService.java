package fab.formatic.web.service;

import java.util.List;

import fab.formatic.web.dto.Module;
import fab.formatic.web.dto.OrderInputOutput;
import fab.formatic.web.dto.Package;
import fab.formatic.web.dto.ServiceAttr;
import fab.formatic.web.dto.Trans;

/**
 * @author gilang
 *
 */
public interface FabFullfillmentService {
	
	OrderInputOutput orderInput(String accountID, Module module, Package paket, List<ServiceAttr> serviceAttr,
			 String serviceID, String sessionID, String transType,String transID);
	       
	List<Trans> orderTracking(String accountID, String serviceID, String sessionID, String transID);       
	       
	       
	       
	       
	       
	       
	     

}
