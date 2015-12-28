package fab.formatic.web.ws;

import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.servlet.http.HttpSession;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.WebServiceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fab.formatic.web.dto.BillTransactionOutput;
import fab.formatic.web.dto.GetBillingDataOutput;
import fab.formatic.web.dto.GetServiceDataOutput;
import fab.formatic.web.dto.GetServiceListOutput;
import fab.formatic.web.dto.GetServiceOutput;
import fab.formatic.web.dto.GetTarrifOutput;
import fab.formatic.web.dto.IncidentInputOutput;
import fab.formatic.web.dto.IncidentTrackingOutput;
import fab.formatic.web.dto.Module;
import fab.formatic.web.dto.OrderInputOutput;
import fab.formatic.web.dto.ServiceAttr;
import fab.formatic.web.dto.ServiceDataList;
import fab.formatic.web.dto.Trans;
import fab.formatic.web.dto.UpdateBillInfoOutput;
import fab.formatic.web.service.FabAssuranceService;
import fab.formatic.web.service.FabBillingService;
import fab.formatic.web.service.FabFullfillmentService;
import fab.formatic.web.service.FabGeneralService;
import fab.formatic.web.util.FabSessionHandler;
import fab.formatic.web.util.FabSessionHandlerFactory;
import fab.formatic.web.util.FabWSConstant;
import fab.formatic.web.dto.Package;

@Component(FabWSConstant.FAB_FORMATIC_SERVICE_BEAN)
@WebService(endpointInterface = "fab.formatic.web.ws.FABws", targetNamespace = FabWSConstant.NAMESPACE)
public class FabFormaticWebService implements FABws {

	@Autowired
	private FabGeneralService generalService;

	@Autowired
	private FabAssuranceService assuranceService;

	@Autowired
	private FabFullfillmentService fullfillmentService;

	@Autowired
	private FabBillingService billingService;

	@Resource
	WebServiceContext context;

	protected HttpSession getSession(WebServiceContext context) {
		FabSessionHandler handler = FabSessionHandlerFactory
				.getSessionHandlerInstance();
		HttpSession session = handler.getSessionInstance(context);
		if (session == null) {
			session = handler.newSessionInstance(context);
		}
		return session;
	}

	public String login(String adminEmail, String password, String serviceID) {
		String login = generalService.login(adminEmail, password, serviceID);
		HttpSession session = getSession(context);
		session.setAttribute(FabWSConstant.FAB_SESSION_ID, login);
		return (String) session.getAttribute(FabWSConstant.FAB_SESSION_ID);
	}

	public String getModuleInfo(String moduleID, String serviceID) {
		String moduleInfo = generalService.getModuleInfo(moduleID, serviceID);
		return moduleInfo;
	}

	public String getServiceInfo(String serviceID) {
		String serviceInfo = generalService.getServiceInfo(serviceID);
		return serviceInfo;
	}

	public OrderInputOutput orderInput(String accountID, Module module,
			Package paket, List<ServiceAttr> serviceAttr, String serviceID,
			String sessionID, String transType, String transID) {
		return fullfillmentService.orderInput(accountID, module, paket,
				serviceAttr, serviceID, sessionID, transType, transID);
	}

	public List<Trans> orderTracking(String accountID, String serviceID,
			String sessionID, String transID) {
		return fullfillmentService.orderTracking(accountID, serviceID,
				sessionID, transID);
	}

	public IncidentInputOutput incidentInput(String accountID,
			String contactPerson, String incidentDesc, String serviceID,
			String sessionID, String transID) {
		IncidentInputOutput output = incidentInput(accountID, contactPerson,
				incidentDesc, serviceID, sessionID, transID);
		return output;
	}

	public List<IncidentTrackingOutput> incidentTracking(String accountID,
			String serviceID, String sessionID) {
		List<IncidentTrackingOutput> outputs = assuranceService
				.incidentTracking(accountID, serviceID, sessionID);
		if (outputs == null || outputs.size() < 0) {
			throw new RuntimeException(
					"service null, the parameters might be empty or input error");
		}
		return outputs;
	}

	public GetServiceOutput getService(String serviceID, String sessionID) {
		return billingService.getService(serviceID, sessionID);
	}

	public GetTarrifOutput getTarrif(String serviceID, String sessionID,
			XMLGregorianCalendar viewDate) {
		return billingService.getTarrif(serviceID, sessionID, viewDate);
	}

	public GetServiceListOutput getServiceList(String accountID,
			String sessionID, String transID) {
		return billingService.getServiceList(accountID, sessionID, transID);
	}

	public GetServiceDataOutput getServiceData(String accountID,
			int serviceUsedId, String sessionID, String transID) {
		return billingService.getServiceData(accountID, serviceUsedId,
				sessionID, transID);
	}

	public UpdateBillInfoOutput updateBillInfo(String accountID,
			int serviceUsedId, String sessionID, String transID) {
		return billingService.updateBillInfo(accountID, serviceUsedId,
				sessionID, transID);
	}

	public List<GetBillingDataOutput> getBillingData(String accountID,
			String periode, int serviceID) {
		return billingService.getBillingData(accountID, periode, serviceID);
	}

	public BillTransactionOutput billTransaction(String accountID,
			ServiceDataList serviceDataList, String transID) {
		return billingService.billTransaction(accountID, serviceDataList,
				transID);
	}

}
