package fab.formatic.backend.dao.impl;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fab.formatic.backend.dao.FabBaseDao;
import fab.formatic.backend.dao.FabServiceDao;
import fab.formatic.backend.domain.FabService;
import fab.formatic.backend.util.FabBackendHelper;

/**
 * @author gilang
 *
 */
@Repository(FabBackendHelper.SERVICE_DAO)
public class FabServiceDaoImpl extends FabBaseDao<FabService, Integer> implements FabServiceDao{
	
	public FabServiceDaoImpl() {
		super();
	}

	public FabService findByServiceID(String serviceID) {
		Query query=entityManager.createQuery("select s from FabService s where s.serviceID=:serviceID");
		query.setParameter("serviceID", serviceID);
		return (FabService) query.getSingleResult();
	}

	public FabService findByServiceName(String serviceName) {
		Query query=entityManager.createQuery("select s from FabService s where s.serviceName=:serviceName");
		query.setParameter("serviceName", serviceName);
		return (FabService) query.getSingleResult();
	}

}
