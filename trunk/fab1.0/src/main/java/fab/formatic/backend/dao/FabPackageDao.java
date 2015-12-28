package fab.formatic.backend.dao;

import java.util.List;

import fab.formatic.backend.domain.FabPackage;
import fab.formatic.backend.domain.FabService;

/**
 * @author gilang
 *
 */
public interface FabPackageDao extends FabDao<FabPackage, Integer>{
	
	FabPackage findByPackageName(String packageName);
	
	List<FabPackage> findByService(FabService service);
	
	

}
