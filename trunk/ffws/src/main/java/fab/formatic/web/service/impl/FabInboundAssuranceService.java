package fab.formatic.web.service.impl;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fab.formatic.backend.domain.FabIncident;
import fab.formatic.backend.service.FabCustomerService;
import fab.formatic.web.dto.IncidentInputOutput;
import fab.formatic.web.dto.IncidentTrackingOutput;
import fab.formatic.web.service.FabAssuranceService;
import fab.formatic.web.util.FabWSConstant;

@Service(FabWSConstant.INBOUND_ASSURANCE_SERVICE)
public class FabInboundAssuranceService implements FabAssuranceService {

	@Autowired
	private FabCustomerService customerService;

	public IncidentInputOutput incidentInput(String accountID,
			String contactPerson, String incidentDesc, String serviceID,
			String sessionID, String transID) {
		FabIncident fabIncident = customerService.inputIncident(accountID,
				contactPerson, incidentDesc, serviceID, sessionID, transID);
		IncidentInputOutput incidentInputOutput = new IncidentInputOutput();
		if (fabIncident != null) {
			incidentInputOutput.setOutMsg(fabIncident.getIncidentDesc());
			incidentInputOutput.setOutStatus("incident report sukses dibuat");
		} else {
			incidentInputOutput.setOutMsg("failed to report incident");
			incidentInputOutput.setOutStatus("incident report gagal dibuat");
		}
		return incidentInputOutput;

	}

	public List<IncidentTrackingOutput> incidentTracking(String accountID,
			String serviceID, String sessionID) {

		List<FabIncident> incidents = customerService.getIncident(accountID,
				serviceID, sessionID);
		if (incidents != null && incidents.size()>0) {
			List<IncidentTrackingOutput> outputs = new ArrayList<IncidentTrackingOutput>();
			Iterator<FabIncident> iterator = incidents.iterator();
			while (iterator.hasNext()) {

				FabIncident next = iterator.next();
				IncidentTrackingOutput incidentOutput = new IncidentTrackingOutput();
				incidentOutput.setDate(DateFormat.getInstance().format(
						next.getIncidentDate()));
				incidentOutput.setSolutionDesc(next.getIncidentSolution());
				incidentOutput.setStatusDesc(next.getIncidentDesc());
				incidentOutput.setTransID(next.getTransID());
				
				outputs.add(incidentOutput);

			}
			return outputs;
		}else{
			return null;
		}

	}

}
