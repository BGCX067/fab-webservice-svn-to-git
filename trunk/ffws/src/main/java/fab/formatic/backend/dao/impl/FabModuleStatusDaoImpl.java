package fab.formatic.backend.dao.impl;

import org.springframework.stereotype.Repository;

import fab.formatic.backend.dao.FabBaseDao;
import fab.formatic.backend.dao.FabModuleStatusDao;
import fab.formatic.backend.domain.FabModuleStatus;
import fab.formatic.backend.util.FabBeansLocator;

@Repository(FabBeansLocator.MODULE_STATUS_DAO)
public class FabModuleStatusDaoImpl extends FabBaseDao<FabModuleStatus, Integer> 
					implements FabModuleStatusDao{
	
	public FabModuleStatusDaoImpl() {
		super();
	}

}
