package fab.formatic.backend.dao;

import java.util.List;

import fab.formatic.backend.domain.FabOrder;

/**
 * @author gilang
 *
 */
public interface FabOrderDao extends FabDao<FabOrder, Integer>{
	
	List<FabOrder> findActivationOrder();
	
	List<FabOrder> findSuspensionOrder();
	
	List<FabOrder> findResumptionOrder();
	
	List<FabOrder> findTerminationOrder();
	
	List<FabOrder> findByAccountServiceID(String accountID, String serviceID);
	
	List<FabOrder> findByAccountID(String accountID);
	
	FabOrder findByTransID(String transID);

}
