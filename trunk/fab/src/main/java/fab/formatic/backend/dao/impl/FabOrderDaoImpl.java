package fab.formatic.backend.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fab.formatic.backend.dao.FabBaseDao;
import fab.formatic.backend.dao.FabOrderDao;
import fab.formatic.backend.domain.FabOrder;
import fab.formatic.backend.util.FabBackendHelper;

/**
 * @author gilang
 *
 */
@Repository(FabBackendHelper.ORDER_DAO)
public class FabOrderDaoImpl extends FabBaseDao<FabOrder, Integer> implements
		FabOrderDao {

	public FabOrderDaoImpl() {
		super();
	}

	@SuppressWarnings("unchecked")
	public List<FabOrder> findActivationOrder() {
		Query q = entityManager
				.createQuery("select o from FabOrder o where o.transactionType="
						+ FabBackendHelper.ACTIVATION_ORDER);
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<FabOrder> findSuspensionOrder() {
		Query q = entityManager
				.createQuery("select o from FabOrder o where o.transactionType="
						+ FabBackendHelper.SUSPENSION_ORDER);
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<FabOrder> findResumptionOrder() {
		Query q = entityManager
				.createQuery("select o from FabOrder o where o.transactionType="
						+ FabBackendHelper.RESUMPTION_ORDER);
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<FabOrder> findTerminationOrder() {
		Query q = entityManager
				.createQuery("select o from FabOrder o where o.transactionType="
						+ FabBackendHelper.TERMINATION_ORDER);
		return q.getResultList();
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

	public FabOrder findByTransID(String transID) {
		Query q = entityManager
				.createQuery("select o from FabOrder o where o.transID=:transID");
		q.setParameter("transID", transID);
		FabOrder fo = (FabOrder) q.getSingleResult();
		return fo;
	}

	@SuppressWarnings("unchecked")
	public List<FabOrder> findByAccountID(String accountID) {
		Query q=entityManager.createQuery("select o from FabOrder o where o.fabCustomer.accountID=:accountID");
		q.setParameter("accountID", accountID);
		return q.getResultList();
	}

}
