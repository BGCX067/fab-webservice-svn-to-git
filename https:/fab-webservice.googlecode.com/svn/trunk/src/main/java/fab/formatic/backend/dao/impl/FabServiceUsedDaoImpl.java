package fab.formatic.backend.dao.impl;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fab.formatic.backend.dao.FabBaseDao;
import fab.formatic.backend.dao.FabServiceUsedDao;
import fab.formatic.backend.domain.FabOrder;
import fab.formatic.backend.domain.FabServiceUsed;
import fab.formatic.backend.util.FabBackendHelper;

/**
 * @author gilang
 *
 */
@Repository(FabBackendHelper.SERVICE_USED_DAO)
public class FabServiceUsedDaoImpl extends FabBaseDao<FabServiceUsed, Integer> implements FabServiceUsedDao{
	
	public FabServiceUsedDaoImpl() {
		super();
	}

	
	public FabServiceUsed findByFabOrder(FabOrder order) {
		Query q=entityManager.createQuery("select u from FabServiceUsed u where u.fabOrder=:fabOrder");
		q.setParameter("fabOrder", order);
		return (FabServiceUsed) q.getSingleResult();
	}
	
	
}
