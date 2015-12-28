package fab.formatic.web.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public abstract class FabWSConstant {

	public static final String NAMESPACE = "http://fab/";

	public static final String ROLE_FAB = "ROLE_FAB";

	public static final String ROLE_BARAPRAJA = "ROLE_BARAPRAJA";

	public static final String ROLE_ANONYMOUS = "ROLE_ANONYMOUS";

	public static final String ANONYMOUS = "anonymous";

	public static final String ANONYMOUS_PWD = "anonymous";
	
	public static final String FAB_CUSTOMER_SERVICE="fabCustomerService";
	
	public static final String FAB_CUSTOMER_ORDER_SERVICE="fabCustomerOrderService";
	
	public static final String FAB_BILLING_SERVICE="fabBillingService";
	
	public static final String INBOUND_GENERAL_SERVICE = "fabInboundGeneralService";

	public static final String INBOUND_FULLFILLMENT_SERVICE = "fabInboundFullfillmentService";

	public static final String INBOUND_ASSURANCE_SERVICE = "fabInboundAssuranceService";

	public static final String INBOUND_OUTBOUND_BILLING_SERVICE = "fabInOutBillingService";
	
	public static final String FAB_SESSION_ID="FABSESSIONID";
	
	public static final String FAB_SERVER_PASSWORD_CALLBACK="fabServerPasswordCallback";
	
	public static final String FAB_SESSION_INBOUND_INTERCEPT="fabSessionInboundInterceptor";
	
	public static final String FAB_SESSION_OUTBOUND_INTERCEPT="fabSessionOutboundInterceptor";
	
	public static final String FAB_AUTHORIZATION_INBOUND_INTERCEP="fabAuthorizationInboundInterceptor";
	
	public static final String FAB_FORMATIC_SERVICE_BEAN="fabFormaticWebService";
	
	private static final ClassPathXmlApplicationContext webServiceContext;

	protected static final List<String> DUMMY_ROLES;

	static {

		DUMMY_ROLES = new ArrayList<String>();
		DUMMY_ROLES.add(ROLE_FAB);
		DUMMY_ROLES.add(ROLE_BARAPRAJA);
		
		webServiceContext=new ClassPathXmlApplicationContext("classpath:applicationContext-ws.xml");
	}

	public static List<String> getAllRoles() {
		return DUMMY_ROLES;
	}

	public static List<String> getAnonymousRole() {
		List<String> anonymouse = new ArrayList<String>();
		anonymouse.add(ROLE_ANONYMOUS);
		return anonymouse;
	}

	public static List<String> getFabRole() {
		List<String> anonymouse = new ArrayList<String>();
		anonymouse.add(ROLE_BARAPRAJA);
		return anonymouse;
	}
	
	public static ClassPathXmlApplicationContext getWebServiceApplicationContext()
	{
		return webServiceContext;
	}

	

}
