package fab.formatic.backend.dao.impl;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fab.formatic.backend.dao.FabBaseDao;
import fab.formatic.backend.dao.FabCustomerDao;
import fab.formatic.backend.domain.FabCustomer;
import fab.formatic.backend.util.FabBeansLocator;

@Repository(FabBeansLocator.CUSTOMER_DAO)
public class FabCustomerDaoImpl extends FabBaseDao<FabCustomer, Integer> implements
		FabCustomerDao {
	
	public FabCustomerDaoImpl() {
		super();
	}

	public FabCustomer findByAdminEmail(String adminEmail) {
		Query q=entityManager.createQuery("select c from FabCustomer c where c.adminEmail=:adminEmail");
		q.setParameter("adminEmail", adminEmail);
		return (FabCustomer) q.getSingleResult();
	}

	public FabCustomer findByUsername(String username) {
		Query q=entityManager.createQuery("select c from FabCustomer c where c.customerName=:customerName");
		q.setParameter("customerName", username);
		return (FabCustomer) q.getResultList().get(0);
	}

	public FabCustomer findByAccountId(String accountID) {
		Query q=entityManager.createQuery("select c from FabCustomer c where c.accountID=:accountID");
		q.setParameter("accountID", accountID);
		return (FabCustomer) q.getSingleResult();
	}

	

}
