package fab.formatic.backend.dao.impl;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fab.formatic.backend.dao.FabBaseDao;
import fab.formatic.backend.dao.FabPackageDao;
import fab.formatic.backend.domain.FabPackage;
import fab.formatic.backend.util.FabBeansLocator;

@Repository(FabBeansLocator.PACKAGE_DAO)
public class FabPackageDaoImpl extends FabBaseDao<FabPackage, Integer>
		implements FabPackageDao {

	public FabPackageDaoImpl() {
		super();
	}

	public FabPackage findPackageByName(String pname) {
		Query q=entityManager.createQuery("select p from FabPackage p where p.packageName=:packageName");
		q.setParameter("packageName", pname);
		return (FabPackage) q.getSingleResult();
	}

}
