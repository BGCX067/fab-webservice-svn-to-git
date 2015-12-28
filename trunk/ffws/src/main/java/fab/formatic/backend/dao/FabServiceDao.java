package fab.formatic.backend.dao;

import fab.formatic.backend.domain.FabService;

public interface FabServiceDao extends BaseDao<FabService, Integer> {
	
	FabService findByServiceName(String serviceName);
	
	FabService findByServiceId(String serviceID);

}
