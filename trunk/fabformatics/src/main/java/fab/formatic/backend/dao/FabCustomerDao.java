package fab.formatic.backend.dao;

import fab.formatic.backend.domain.FabCustomer;

/**
 * @author gilang
 *
 */
public interface FabCustomerDao extends FabDao<FabCustomer, Integer>{
	
	FabCustomer findByAdminEmail(String adminEmail);
	
	FabCustomer findByAccountID(String accountID);
	
	FabCustomer findByCustomerID(String customerID);

}
