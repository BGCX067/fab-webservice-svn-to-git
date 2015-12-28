package fab.formatic.backend.dao.impl;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fab.formatic.backend.dao.FabBaseDao;
import fab.formatic.backend.dao.FabModuleDao;
import fab.formatic.backend.domain.FabModule;
import fab.formatic.backend.util.FabBeansLocator;

@Repository(FabBeansLocator.MODULE_DAO)
public class FabModuleDaoImpl extends FabBaseDao<FabModule, Integer> implements FabModuleDao{
	
	public FabModuleDaoImpl() {
		super();
	}

	public FabModule getModuleByName(String moduleName) {
		Query q=entityManager.createQuery("select m from FabModule m where m.moduleName=:moduleName");
		q.setParameter("moduleName", moduleName);
		
		return (FabModule) q.getSingleResult();
	}

	public FabModule findByServiceIdModuleName(String modulId, String serviceId) {
		// TODO Auto-generated method stub
		return null;
	}
}
