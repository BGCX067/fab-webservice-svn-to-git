package fab.formatic.backend.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fab.formatic.backend.dao.FabBaseDao;
import fab.formatic.backend.dao.FabServiceStatusDao;
import fab.formatic.backend.domain.FabOrder;
import fab.formatic.backend.domain.FabServiceStatus;
import fab.formatic.backend.util.FabBackendHelper;

/**
 * @author gilang
 *
 */
@Repository(FabBackendHelper.SERVICE_STATUS_DAO)
public class FabServiceStatusDaoImpl extends FabBaseDao<FabServiceStatus, Integer> implements FabServiceStatusDao{
	
	public FabServiceStatusDaoImpl() {	super(); }

	@SuppressWarnings("unchecked")
	public List<FabServiceStatus> findByFabOrder(FabOrder order) {
		Query q=entityManager.createQuery("select u from FabServiceStatus u where u.fabOrder=:fabOrder");
		q.setParameter("fabOrder", order);
		return q.getResultList();
	}
}
