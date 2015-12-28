package fab.formatic.backend.dao;

import java.util.List;

import fab.formatic.backend.domain.FabIncident;

/**
 * @author gilang
 *
 */
public interface FabIncidentDao extends FabDao<FabIncident, Integer>{

	List<FabIncident> findIncidentFromOrder(String transID);
	
	List<FabIncident> findIncidentByAccountServiceTrans(String accountID, String serviceID, String transID);
}
