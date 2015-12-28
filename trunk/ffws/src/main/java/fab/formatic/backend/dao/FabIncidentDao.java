package fab.formatic.backend.dao;

import java.util.List;

import fab.formatic.backend.domain.FabIncident;

public interface FabIncidentDao extends BaseDao<FabIncident, Integer> {
	
	FabIncident findByReporterId(String accountID);
	
	List<FabIncident> finIncidentTrack(String accountID, String serviceID);

}
