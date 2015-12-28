package fab.formatic.backend.dao;

import fab.formatic.backend.domain.FabOrder;
import fab.formatic.backend.domain.FabServiceUsed;

/**
 * @author gilang
 *
 */
public interface FabServiceUsedDao extends FabDao<FabServiceUsed, Integer> {

	FabServiceUsed findByFabOrder(FabOrder order);

}
