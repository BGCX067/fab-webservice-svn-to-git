package fab.formatic.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fab.formatic.backend.domain.FabIncident;
import fab.formatic.backend.service.FabIncidentService;
import fab.formatic.web.dto.IncidentInputOutput;
import fab.formatic.web.dto.IncidentTrackingOutput;
import fab.formatic.web.util.FabWSHelper;

/**
 * @author gilang
 *
 */
@Service(FabWSHelper.ASSURANCE_SERVICE)
public class FabAssuranceServiceImpl implements FabAssuranceService {
	
	@Autowired
	private FabIncidentService incidentService;

	public IncidentInputOutput incidentInput(String accountID,
			String contactPerson, String incidentDesc, String serviceID,
			String sessionID, String transID) {
		
		FabIncident incident=incidentService.incidentInput(accountID, contactPerson, incidentDesc, serviceID, sessionID, transID);
		if(incident!=null){
			IncidentInputOutput output=new IncidentInputOutput();
			output.setOutMsg(incident.getIncidentDesc()+" solution: "+incident.getIncidentSolution());
			output.setOutStatus(String.valueOf(incident.getIncidentStatus()));
			return output;
		}
		return null;
	}

	public List<IncidentTrackingOutput> incidentTracking(String accountID,
			String serviceID, String sessionID) {
		List<IncidentTrackingOutput> outputs=new ArrayList<IncidentTrackingOutput>();
		List<FabIncident> fabIncidents=incidentService.incidentTrack(accountID, serviceID, sessionID);
		if(fabIncidents!=null && fabIncidents.size()>0){
			for(FabIncident fi:fabIncidents){
				IncidentTrackingOutput output=new IncidentTrackingOutput();
				output.setDate(fi.getIncidentDate().toString());
				output.setSolutionDesc(fi.getIncidentSolution());
				output.setTransID(fi.getFabOrder().getTransID());
				
				outputs.add(output);
			}
			return outputs;
		}
		return null;
	}

}
