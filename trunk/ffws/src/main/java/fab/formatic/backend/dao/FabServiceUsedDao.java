package fab.formatic.backend.dao;

import java.util.List;

import fab.formatic.backend.domain.FabServiceUsed;

public interface FabServiceUsedDao extends BaseDao<FabServiceUsed, Integer> {
	
	List<FabServiceUsed> findByCustomerId(String customerID);

}
