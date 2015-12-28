package fab.formatic.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fab.formatic.backend.dao.FabIncidentDao;
import fab.formatic.backend.dao.FabOrderDao;
import fab.formatic.backend.domain.FabIncident;
import fab.formatic.backend.domain.FabOrder;
import fab.formatic.backend.util.FabBackendHelper;

/**
 * @author gilang
 *
 */
@Service(FabBackendHelper.INCIDENT_SERVICE)
public class FabIncidentServiceImpl implements FabIncidentService {

	@Autowired
	private FabIncidentDao incidentDao;
	
	@Autowired
	private FabOrderDao orderDao;
	
	@Transactional
	public FabIncident incidentInput(String accountID, String contactPerson,String incidentDesc, String serviceID, String sessionID, String transID) {
		
		FabIncident incident=new FabIncident();
		incident.setContactPerson(contactPerson);
		incident.setIncidentDate(new Date());
		incident.setIncidentDesc(incidentDesc);
		incident.setIncidentSolution(null);
		incident.setIncidentStatus(0);
		
		FabOrder order=orderDao.findByTransID(transID);
		incident.setFabOrder(order);
		
		incidentDao.persist(incident);
		
		return incident;
	}

	public List<FabIncident> incidentTrack(String accountID, String serviceID,String sessionID) {
		
		
		return null;
	}

}
