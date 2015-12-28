/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fab.formatic.web.service;

import fab.formatic.web.dto.IncidentInputOutput;
import fab.formatic.web.dto.IncidentTrackingOutput;

public interface FabAssuranceService {

    IncidentInputOutput incidentInput(String accountID, String contactPerson,
			String incidentDesc, String serviceID, String sessionID,
			String transID);

    IncidentTrackingOutput incidentTracking(String accountID,String serviceID, String sessionID);

   
}
