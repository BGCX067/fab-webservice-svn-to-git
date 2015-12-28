package fab.formatic.web.ws;

import java.util.List;

import javax.jws.WebService;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fab.formatic.web.dto.BillTransactionOutput;
import fab.formatic.web.dto.FABws;
import fab.formatic.web.dto.GetBillingDataOutput;
import fab.formatic.web.dto.GetServiceDataOutput;
import fab.formatic.web.dto.GetServiceListOutput;
import fab.formatic.web.dto.GetServiceOutput;
import fab.formatic.web.dto.GetTarrifOutput;
import fab.formatic.web.dto.IncidentInputOutput;
import fab.formatic.web.dto.IncidentTrackingOutput;
import fab.formatic.web.dto.Module;
import fab.formatic.web.dto.OrderInputOutput;
import fab.formatic.web.dto.Package;
import fab.formatic.web.dto.ServiceAttr;
import fab.formatic.web.dto.ServiceDataList;
import fab.formatic.web.dto.Trans;
import fab.formatic.web.dto.UpdateBillInfoOutput;
import fab.formatic.web.service.FabAssuranceService;
import fab.formatic.web.service.FabBillingService;
import fab.formatic.web.service.FabFullfillmentService;
import fab.formatic.web.service.FabGeneralService;
import fab.formatic.web.util.FabWSHelper;

/**
 * @author gilang
 *
 */
@Component(FabWSHelper.WEB_SERVICE_ENDPOINT)
@WebService(endpointInterface="fab.formatic.web.dto.FABws", targetNamespace=FabWSHelper.NAMESPACE)
public class FabFormaticWebService implements FABws {
	
	@Autowired
	private FabBillingService billingService;
	
	@Autowired
	private FabFullfillmentService fullfillmentService;
	
	@Autowired
	private FabGeneralService generalService;
	
	@Autowired
	private FabAssuranceService assuranceService;
	

	public String login(String adminEmail, String password, String serviceID) {
		return generalService.login(adminEmail, password, serviceID);
	}

	public String getModuleInfo(String moduleID, String serviceID) {
		return generalService.getModuleInfo(serviceID, moduleID);
	}

	public String getServiceInfo(String serviceID) {
		return generalService.getServiceInfo(serviceID);
	}

	public OrderInputOutput orderInput(String accountID, Module module,
			Package paket, List<ServiceAttr> serviceAttr, String serviceID,
			String sessionID, String transType, String transID) {
		
		return fullfillmentService.orderInput(accountID, module, paket, serviceAttr, serviceID, sessionID, transType, transID);
	}

	public List<Trans> orderTracking(String accountID, String serviceID,
			String sessionID, String transID) {
		return fullfillmentService.orderTracking(accountID, serviceID, sessionID, transID);
	}

	public IncidentInputOutput incidentInput(String accountID,
			String contactPerson, String incidentDesc, String serviceID,
			String sessionID, String transID) {
		return assuranceService.incidentInput(accountID, contactPerson, incidentDesc, serviceID, sessionID, transID);
	}

	public List<IncidentTrackingOutput> incidentTracking(String accountID,
			String serviceID, String sessionID) {
		return assuranceService.incidentTracking(accountID, serviceID, sessionID);
	}

	public List<GetServiceOutput> getService(String serviceID, String sessionID) {
		return billingService.getService(serviceID, sessionID);
	}

	public List<GetTarrifOutput> getTarrif(String serviceID, String sessionID,
			XMLGregorianCalendar viewDate) {
		return billingService.getTariff(serviceID, sessionID, viewDate);
	}

	public GetServiceListOutput getServiceList(String accountID,
			String sessionID, String transID) {
		return billingService.getServiceList(accountID, sessionID, transID);
	}

	public List<GetServiceDataOutput> getServiceData(String accountID,
			int serviceUsedId, String sessionID, String transID) {
		return billingService.getServiceData(accountID, serviceUsedId, sessionID, transID);
	}

	public UpdateBillInfoOutput updateBillInfo(String accountID,
			int serviceUsedId, String sessionID, String transID) {
		return billingService.updateBillInfo(accountID, serviceUsedId, sessionID, transID);
	}

	public List<GetBillingDataOutput> getBillingData(String accountID,
			String periode, int serviceID) {
		return billingService.getBillingData(accountID, periode, serviceID);
	}

	public BillTransactionOutput billTransaction(String accountID,
			ServiceDataList serviceDataList, String transID) {
		return billingService.billTransaction(accountID, serviceDataList, transID);
	}

}
