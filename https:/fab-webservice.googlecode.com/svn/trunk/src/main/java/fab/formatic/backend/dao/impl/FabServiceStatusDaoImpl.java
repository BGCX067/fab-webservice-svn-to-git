package fab.formatic.backend.dao.impl;

import org.springframework.stereotype.Repository;

import fab.formatic.backend.dao.FabBaseDao;
import fab.formatic.backend.dao.FabServiceStatusDao;
import fab.formatic.backend.domain.FabServiceStatus;
import fab.formatic.backend.util.FabBackendHelper;

@Repository(FabBackendHelper.SERVICE_STATUS_DAO)
public class FabServiceStatusDaoImpl extends FabBaseDao<FabServiceStatus, Integer> implements FabServiceStatusDao{

	public FabServiceStatusDaoImpl() {
		super();
	}
}
