package fab.formatic.backend.dao;

import java.util.List;

import fab.formatic.backend.domain.FabOrder;
import fab.formatic.backend.domain.FabServiceUsed;

/**
 * @author gilang
 *
 */
public interface FabServiceUsedDao extends FabDao<FabServiceUsed, Integer> {

	List<FabServiceUsed> findByFabOrder(FabOrder order);

}
