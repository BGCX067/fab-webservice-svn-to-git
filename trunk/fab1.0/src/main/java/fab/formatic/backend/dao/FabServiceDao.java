package fab.formatic.backend.dao;

import fab.formatic.backend.domain.FabService;

/**
 * @author gilang
 *
 */
public interface FabServiceDao extends FabDao<FabService, Integer>{
	
	FabService findByServiceID(String serviceID);
	
	FabService findByServiceName(String serviceName);

}
