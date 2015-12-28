package fab.formatic.backend.service;

import java.util.List;

import fab.formatic.backend.domain.FabIncident;

/**
 * @author gilang
 *
 */
public interface FabIncidentService {
	
	FabIncident incidentInput(String accountID, String contactPerson, String incidentDesc, String serviceID,
			String sessionID, String transID);
	
	List<FabIncident> incidentTrack(String accountID,String serviceID, String sessionID);

}
