/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fab.formatic.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fab.formatic.backend.domain.FabIncident;
import fab.formatic.backend.service.FabIncidentService;
import fab.formatic.web.dto.IncidentInputOutput;
import fab.formatic.web.dto.IncidentTrackingOutput;
import fab.formatic.web.service.FabAssuranceService;
import fab.formatic.web.util.FabWSHelper;

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

    public IncidentTrackingOutput incidentTracking(String accountID, String serviceID, String sessionID) {
            	
    	List<FabIncident> incidents = incidentService.incidentTrack(accountID, serviceID, sessionID);
    	IncidentTrackingOutput output = new IncidentTrackingOutput();
    	String statusDesc="";
    	String solutionDesc="";
    	String date="";
    	for(FabIncident fi:incidents)
    	{
    		 	statusDesc+=fi.getIncidentStatus();
    			solutionDesc+=fi.getIncidentSolution();
    			date+=fi.getIncidentDate().toString();
    			output.setTransID(fi.getFabOrder().getTransID()); 	  	
       	}
    	
    	output.setStatusDesc(statusDesc);
		output.setSolutionDesc(solutionDesc);
		output.setDate(date);
    	return output;
    }

}
