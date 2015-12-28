package fab.formatic.backend.dao.impl;

import org.springframework.stereotype.Repository;

import fab.formatic.backend.dao.FabBaseDao;
import fab.formatic.backend.dao.FabOrderModuleDao;
import fab.formatic.backend.domain.FabOrderModule;
import fab.formatic.backend.util.FabBeansLocator;

@Repository(FabBeansLocator.ORDER_MODULE_DAO)
public class FabOrderModuleDaoImpl extends FabBaseDao<FabOrderModule, Integer> implements
		FabOrderModuleDao {

	public FabOrderModuleDaoImpl() {
		super();
		
	}

	

}
