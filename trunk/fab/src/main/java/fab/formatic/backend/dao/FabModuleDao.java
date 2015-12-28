package fab.formatic.backend.dao;

import java.util.List;

import fab.formatic.backend.domain.FabModule;
import fab.formatic.backend.domain.FabService;

/**
 * @author gilang
 *
 */
public interface FabModuleDao extends FabDao<FabModule, Integer>{
	
	FabModule findByModuleName(String moduleName);
	
	List<FabModule> findByService(FabService fabService);

}
