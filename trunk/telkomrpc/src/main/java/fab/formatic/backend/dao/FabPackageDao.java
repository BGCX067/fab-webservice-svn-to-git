package fab.formatic.backend.dao;

import org.springframework.dao.DataAccessException;

import fab.formatic.backend.domain.FabPackage;

public interface FabPackageDao extends FabDao<FabPackage, Integer>{
	
	FabPackage findByPackageID (String packageID) throws DataAccessException;

}
