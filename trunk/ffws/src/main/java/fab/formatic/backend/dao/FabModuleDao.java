package fab.formatic.backend.dao;

import fab.formatic.backend.domain.FabModule;

public interface FabModuleDao extends BaseDao<FabModule, Integer> {
	
	FabModule getModuleByName(String moduleName);
	
	FabModule findByServiceIdModuleName(String modulId, String serviceId);

}
