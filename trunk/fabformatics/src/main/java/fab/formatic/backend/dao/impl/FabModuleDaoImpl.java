package fab.formatic.backend.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fab.formatic.backend.dao.FabBaseDao;
import fab.formatic.backend.dao.FabModuleDao;
import fab.formatic.backend.domain.FabModule;
import fab.formatic.backend.domain.FabService;
import fab.formatic.backend.util.FabBackendHelper;

/**
 * @author gilang
 *
 */
@Repository(FabBackendHelper.MODULE_DAO)
public class FabModuleDaoImpl extends FabBaseDao<FabModule, Integer> implements FabModuleDao{
	
	public FabModuleDaoImpl(){super();}

	public FabModule findByModuleName(String moduleName) {
		Query query=entityManager.createQuery("select s from FabModule s where s.moduleName=:moduleName");
		query.setParameter("moduleName", moduleName);
		return (FabModule) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public List<FabModule> findByService(FabService fabService) {
		Query query=entityManager.createQuery("select m from FabModule m where m.fabService=:fabService");
		query.setParameter("fabService", fabService);
		return query.getResultList();
	}

	

}
