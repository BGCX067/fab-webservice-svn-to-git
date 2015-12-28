package fab.formatic.backend.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fab.formatic.backend.dao.FabBaseDao;
import fab.formatic.backend.dao.FabPackageDao;
import fab.formatic.backend.domain.FabPackage;
import fab.formatic.backend.domain.FabService;
import fab.formatic.backend.util.FabBackendHelper;

/**
 * @author gilang
 *
 */
@Repository(FabBackendHelper.PACKAGE_DAO)
public class FabPackageDaoImpl extends FabBaseDao<FabPackage, Integer> implements FabPackageDao{

	public FabPackageDaoImpl() {
		super();
	}
	
	public FabPackage findByPackageName(String packageName) {
		Query query=entityManager.createQuery("select s from FabPackage s where s.packageName=:packageName");
		query.setParameter("packageName", packageName);
		return (FabPackage) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public List<FabPackage> findByService(FabService service) {
		Query query=entityManager.createQuery("select s from FabPackage s where s.fabService=:fabService");
		query.setParameter("fabService", service);
		return query.getResultList();
	}

}
