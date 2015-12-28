package fab.formatic.backend.dao;

import java.util.List;

import fab.formatic.backend.domain.FabOrder;
import fab.formatic.backend.domain.FabServiceStatus;

/**
 * @author gilang
 *
 */
public interface FabServiceStatusDao extends FabDao<FabServiceStatus, Integer>{
	
	List<FabServiceStatus> findByFabOrder(FabOrder order);

}
