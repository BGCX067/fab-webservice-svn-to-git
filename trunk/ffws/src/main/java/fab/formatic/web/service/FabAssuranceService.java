package fab.formatic.web.service;

import java.util.List;

import fab.formatic.web.dto.IncidentInputOutput;
import fab.formatic.web.dto.IncidentTrackingOutput;

public interface FabAssuranceService {
	
	IncidentInputOutput incidentInput(String accountID, String contactPerson,
			String incidentDesc, String serviceID, String sessionID,
			String transID);
	
	List<IncidentTrackingOutput> incidentTracking(String accountID,String serviceID, String sessionID);


}
