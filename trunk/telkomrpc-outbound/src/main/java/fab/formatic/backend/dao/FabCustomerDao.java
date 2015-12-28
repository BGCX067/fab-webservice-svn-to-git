package fab.formatic.backend.dao;

import org.springframework.dao.DataAccessException;

import fab.formatic.backend.domain.FabCustomer;

/**
 * @author gilang
 *
 */
public interface FabCustomerDao extends FabDao<FabCustomer, Integer>{
		
	FabCustomer findByAccountID(String accountID) throws DataAccessException;
	
	FabCustomer findByCustomerID(String customerID) throws DataAccessException;

}
