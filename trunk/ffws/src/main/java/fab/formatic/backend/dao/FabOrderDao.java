package fab.formatic.backend.dao;

import java.util.List;

import fab.formatic.backend.domain.FabOrder;

public interface FabOrderDao extends BaseDao<FabOrder, Integer> {
	
	public static int ACTIVATION=1;
	
	public static int SUSPENSION=2;
	
	public static int RESUMPTION=3;
	
	public static int TERMINATION=4;
	
	FabOrder findByCustomerId(String customerID);
	
	FabOrder findByIdTrans(String idTrans);
	
	List<FabOrder> findByAccountServiceID(String accountID, String sericeID);

}
