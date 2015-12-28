package fab.formatic.backend.dao.impl;

import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import fab.formatic.backend.dao.FabBaseDao;
import fab.formatic.backend.dao.FabPackageDao;
import fab.formatic.backend.domain.FabPackage;
import fab.formatic.backend.util.FabBackendHelper;

@Repository(FabBackendHelper.PACKAGE_DAO)
public class FabPackageDaoImpl extends FabBaseDao<FabPackage, Integer> implements FabPackageDao{

	public FabPackageDaoImpl(){
		super();
	}

	public FabPackage findByPackageID(String packageID)
			throws DataAccessException {
		Query q=entityManager.createQuery("select p from FabPackage p where p.packageID=:packageID");
		q.setParameter("packageID", packageID);
		return (FabPackage) q.getSingleResult();
	}	
}
