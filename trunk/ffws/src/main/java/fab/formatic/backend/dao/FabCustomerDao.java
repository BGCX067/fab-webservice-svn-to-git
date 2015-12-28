package fab.formatic.backend.dao;

import fab.formatic.backend.domain.FabCustomer;

public interface FabCustomerDao extends BaseDao<FabCustomer, Integer> {
	
	FabCustomer findByAdminEmail(String adminEmail);
	FabCustomer findByUsername(String username);
	FabCustomer findByAccountId(String accountID);

}
