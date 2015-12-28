package fab.formatic.backend.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fab.formatic.backend.dao.FabBaseDao;
import fab.formatic.backend.dao.FabOrderDao;
import fab.formatic.backend.domain.FabOrder;
import fab.formatic.backend.util.FabBeansLocator;

@Repository(FabBeansLocator.ORDER_DAO)
public class FabOrderDaoImpl extends FabBaseDao<FabOrder, Integer> implements
		FabOrderDao {

	public FabOrderDaoImpl() {
		super();
	}

	public FabOrder findByCustomerId(String customerID) {
		Query q = entityManager
				.createQuery("select o from FabOrder o where o.fabCustomer.customerID=:customerID");
		q.setParameter("customerID", customerID);
		FabOrder fo = (FabOrder) q.getSingleResult();
		return fo;
	}

	public FabOrder findByIdTrans(String transID) {
		Query q = entityManager
				.createQuery("select o from FabOrder o where o.transID=:transID");
		q.setParameter("transID", transID);
		FabOrder fo = (FabOrder) q.getSingleResult();
		return fo;
	}

	@SuppressWarnings("unchecked")
	public List<FabOrder> findByAccountServiceID(String accountID,
			String serviceID) {
		Query q = entityManager
				.createQuery("select o from FabOrder o where o.fabCustomer.accountID=:accountID and o.fabService.serviceID=:serviceID");
		q.setParameter("accountID", accountID);
		q.setParameter("serviceID", serviceID);
		
		return q.getResultList();
	}

}
