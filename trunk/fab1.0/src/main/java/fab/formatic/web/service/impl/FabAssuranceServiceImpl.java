/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fab.formatic.web.service.impl;

import fab.formatic.backend.domain.FabIncident;
import fab.formatic.backend.service.FabIncidentService;
import fab.formatic.web.dto.IncidentInputOutput;
import fab.formatic.web.dto.IncidentTrackingOutput;
import fab.formatic.web.service.FabAssuranceService;
import fab.formatic.web.util.FabWSHelper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(FabWSHelper.ASSURANCE_SERVICE)
public class FabAssuranceServiceImpl implements FabAssuranceService {

	@Autowired
	private FabIncidentService incidentService;
	
    public IncidentInputOutput incidentInput(String accountID, String contactPerson, String incidentDesc, String serviceID, String sessionID, String transID) {
        FabIncident incident = incidentService.incidentInput(accountID, contactPerson, incidentDesc, serviceID, sessionID, transID);
		IncidentInputOutput iio = new IncidentInputOutput();
		
		if(incident==null){
			iio.setOutMsg("incident input failed");
			iio.setOutStatus("failed");
		}else{
			iio.setOutMsg("incident input success");
			iio.setOutStatus("success");
		}
        
        return iio;
        
    }

    public List<IncidentTrackingOutput> incidentTracking(String accountID, String serviceID, String sessionID) {
            	
    	List<FabIncident> incidents = incidentService.incidentTrack(accountID, serviceID, sessionID);
    	List<IncidentTrackingOutput> outputs = new ArrayList<IncidentTrackingOutput>();
    	
    	for(FabIncident fi:incidents)
    	{
    		IncidentTrackingOutput ito = new IncidentTrackingOutput();
    		if(fi==null){
    			ito.setTransID("transID not found");
    			ito.setDate(null);
    			ito.setStatusDesc("incident not found");
    			ito.setSolutionDesc(null);
    		}else{
    			ito.setTransID(fi.getFabOrder().getTransID());
    			ito.setStatusDesc(fi.getIncidentDesc());
    			ito.setSolutionDesc(fi.getIncidentSolution());
    			ito.setDate(fi.getIncidentDate().toString());
    		}
    		outputs.add(ito);	
    	}
    	    	
    	return outputs;
    }

}
