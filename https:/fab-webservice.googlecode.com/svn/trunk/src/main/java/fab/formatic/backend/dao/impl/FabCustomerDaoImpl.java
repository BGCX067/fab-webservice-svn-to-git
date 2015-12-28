package fab.formatic.backend.dao.impl;

import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import fab.formatic.backend.dao.FabBaseDao;
import fab.formatic.backend.dao.FabCustomerDao;
import fab.formatic.backend.domain.FabCustomer;
import fab.formatic.backend.util.FabBackendHelper;

/**
 * @author gilang
 *
 */
@Repository(FabBackendHelper.CUSTOMER_DAO)
public class FabCustomerDaoImpl extends FabBaseDao<FabCustomer, Integer> implements FabCustomerDao{
	
	public FabCustomerDaoImpl() {
		super();
	}

	public FabCustomer findByAccountID(String accountID) throws DataAccessException{
		Query q=entityManager.createQuery("select c from FabCustomer c where c.accountID=:accountID");
		q.setParameter("accountID", accountID);
		return (FabCustomer) q.getSingleResult();
	}

	public FabCustomer findByCustomerID(String customerID) throws DataAccessException{
		Query q=entityManager.createQuery("select c from FabCustomer c where c.customerID=:customerID");
		q.setParameter("customerID", customerID);
		return (FabCustomer) q.getSingleResult();
	}

	public FabCustomer findByAdminEmail(String adminEmail) throws DataAccessException{
		Query q=entityManager.createQuery("select c from FabCustomer c where c.adminEmail=:adminEmail");
		q.setParameter("adminEmail", adminEmail);
		return (FabCustomer) q.getSingleResult();
	}

}
