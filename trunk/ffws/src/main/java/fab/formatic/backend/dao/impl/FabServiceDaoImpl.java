package fab.formatic.backend.dao.impl;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fab.formatic.backend.dao.FabBaseDao;
import fab.formatic.backend.dao.FabServiceDao;
import fab.formatic.backend.domain.FabService;
import fab.formatic.backend.util.FabBeansLocator;

@Repository(FabBeansLocator.SERVICE_DAO)
public class FabServiceDaoImpl extends FabBaseDao<FabService, Integer>
		implements FabServiceDao {

	public FabServiceDaoImpl() {
		super();
	}

	public FabService findByServiceName(String serviceName) {
		Query q=entityManager.createQuery("select s from FabService s where s.serviceName=:serviceName");
		q.setParameter("serviceName", serviceName);
		return (FabService) q.getSingleResult();
	}

	public FabService findByServiceId(String serviceID) {
		Query q=entityManager.createQuery("select s from FabService s where s.serviceID=:serviceID");
		q.setParameter("serviceID", serviceID);
		return (FabService) q.getSingleResult();
	}

}
