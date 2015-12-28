package fab.formatic.web.ws;

import fab.formatic.web.dto.exception.ServiceOutputException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jws.WebService;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;

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
import fab.formatic.web.dto.exception.BillingException;
import fab.formatic.web.dto.exception.OrderringException;
import fab.formatic.web.service.FabBillingService;
import fab.formatic.web.service.FabFullfillmentService;
import fab.formatic.web.service.FabGeneralService;
import fab.formatic.web.util.FabWSHelper;
import java.util.ArrayList;

@WebService(endpointInterface="fab.formatic.web.dto.FABws", targetNamespace=FabWSHelper.NAMESPACE)
public class FabFormaticWebService implements FABws {
	
	
	@Autowired
	private FabGeneralService generalService;
	
	@Autowired
	private FabFullfillmentService fullfillmentService;
	
	@Autowired
	private FabBillingService billingService;

	public String login(String adminEmail, String password, String serviceID) {
		String login=generalService.login(adminEmail, password, serviceID);
		return login;
	}

	public String getModuleInfo(String moduleID, String serviceID) {
		return generalService.getModuleInfo(serviceID, moduleID);
	}

	public String getServiceInfo(String serviceID) {
		return generalService.getServiceInfo(serviceID);
	}

	public OrderInputOutput orderInput(String accountID, Module module,
			Package _package, List<ServiceAttr> serviceAttr, String serviceID,
			String sessionID, String transType) throws OrderringException {
		OrderInputOutput output=fullfillmentService.orderInput(accountID, module, _package, serviceAttr, serviceID, sessionID, transType);
		
		return output;
	}

	public Trans orderTracking(String accountID, String serviceID, String sessionID, String transID) throws OrderringException {
		Trans trans=fullfillmentService.orderTracking(accountID, serviceID, sessionID, transID);
		return trans;
	}

	public IncidentInputOutput incidentInput(String accountID,
			String contactPerson, String incidentDesc, String serviceID,
			String sessionID, String transID) {
		
		return null;
	}

	public IncidentTrackingOutput incidentTracking(String accountID,
			String serviceID, String sessionID) {
		// TODO Auto-generated method stub
		return null;
	}

	public GetServiceOutput getService(String serviceID, String sessionID) {
		GetServiceOutput output = null;
        try {
            output = billingService.getService(serviceID, sessionID);
        } catch (ServiceOutputException ex) {
            Logger.getLogger(FabFormaticWebService.class.getName()).log(Level.SEVERE, null, ex);
        }
		return output;
	}

	public List<GetTarrifOutput> getTarrif(String serviceID, String sessionID,
			XMLGregorianCalendar viewDate) {
		List<GetTarrifOutput> outputs = new ArrayList<GetTarrifOutput>();
        try {
            outputs = billingService.getTarrif(serviceID, sessionID, viewDate);
        } catch (ServiceOutputException ex) {
            Logger.getLogger(FabFormaticWebService.class.getName()).log(Level.SEVERE, null, ex);
        }
		return outputs;
	}

	public GetServiceListOutput getServiceList(String accountID,
			String sessionID, String transID) {
		GetServiceListOutput output = null;
        try {
            output = billingService.getServiceList(accountID, sessionID, transID);
        } catch (ServiceOutputException ex) {
            Logger.getLogger(FabFormaticWebService.class.getName()).log(Level.SEVERE, null, ex);
        }
		return output;
	}

	public GetServiceDataOutput getServiceData(String accountID,
			int serviceSeq, String sessionID, String transID) {
		GetServiceDataOutput output = null;
        try {
            output = billingService.getServiceData(accountID, serviceSeq, sessionID, transID);
        } catch (ServiceOutputException ex) {
            Logger.getLogger(FabFormaticWebService.class.getName()).log(Level.SEVERE, null, ex);
        }
		return output;
	}

	public UpdateBillInfoOutput updateBillInfo(String accountID,
			int serviceSeq, String sessionID, String transID) {
		UpdateBillInfoOutput output = null;
        try {
            output = billingService.updateBillInfo(accountID, serviceSeq, sessionID, transID);
        } catch (BillingException ex) {
            Logger.getLogger(FabFormaticWebService.class.getName()).log(Level.SEVERE, null, ex);
        }
                return output;
	}

	public GetBillingDataOutput getBillingData(String accountID,
			String periode, int serviceID) throws NumberFormatException, BillingException {
		return billingService.getBillingData(accountID, Integer.valueOf(periode), serviceID);
	}

	public BillTransactionOutput billTransaction(String accountID,
			ServiceDataList serviceDataList, String transID) {
		BillTransactionOutput output = null;
        try {
            output = billingService.billTransaction(accountID, serviceDataList, transID, true);
        } catch (BillingException ex) {
            Logger.getLogger(FabFormaticWebService.class.getName()).log(Level.SEVERE, null, ex);
        }
		return output;
	}

}
