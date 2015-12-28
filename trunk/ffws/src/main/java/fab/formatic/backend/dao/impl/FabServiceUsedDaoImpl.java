package fab.formatic.backend.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fab.formatic.backend.dao.FabBaseDao;
import fab.formatic.backend.dao.FabServiceUsedDao;
import fab.formatic.backend.domain.FabServiceUsed;
import fab.formatic.backend.util.FabBeansLocator;

@Repository(FabBeansLocator.SERVICE_USED_DAO)
public class FabServiceUsedDaoImpl extends FabBaseDao<FabServiceUsed, Integer> implements
		FabServiceUsedDao {
	
	public FabServiceUsedDaoImpl() {
		super();
	}

	@SuppressWarnings("unchecked")
	public List<FabServiceUsed> findByCustomerId(String customerID) {
		Query q=entityManager.createQuery("select s from FabServiceUsed s where s.fabCustomer.customerID=:customerID");
		q.setParameter("customerID", customerID);
		return q.getResultList();
	}

}
