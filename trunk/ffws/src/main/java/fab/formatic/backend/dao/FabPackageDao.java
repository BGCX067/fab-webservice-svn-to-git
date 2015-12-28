package fab.formatic.backend.dao;

import fab.formatic.backend.domain.FabPackage;

public interface FabPackageDao extends BaseDao<FabPackage, Integer> {
	
	FabPackage findPackageByName(String pname);

}
