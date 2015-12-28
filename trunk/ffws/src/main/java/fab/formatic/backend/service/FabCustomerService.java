package fab.formatic.backend.service;

import java.util.List;

import fab.formatic.backend.domain.FabIncident;
import fab.formatic.backend.domain.FabLogin;
import fab.formatic.backend.domain.FabModule;
import fab.formatic.backend.domain.FabService;

public interface FabCustomerService {

	FabLogin login(String adminEmail, String password, String serviceID);

	FabService getService(String serviceID);

	FabModule getModule(String serviceID, String moduleID);

	FabIncident inputIncident(String accountID, String contactPerson,
			String incidentDesc, String serviceID, String sessionID,
			String transID);

	List<FabIncident> getIncident(String accountID, String serviceID, String sessionID);

}
