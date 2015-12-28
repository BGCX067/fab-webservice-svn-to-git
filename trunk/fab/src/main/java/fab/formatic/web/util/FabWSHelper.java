package fab.formatic.web.util;

import fab.formatic.web.dto.FABws;

/**
 * @author gilang
 *
 */
public abstract class FabWSHelper {
	
	public final static String WS_INTERFACE=FABws.class.getName();
	
	public final static String NAMESPACE="http://fab/";
	
	public final static String GENERAL_SERVICE="fabGeneralService";
	
	public final static String FULLFILLMENT_SERVICE="fabFullfillmentService";
	
	public final static String BILLING_SERVICE="fabBillingService";
	
	public final static String ASSURANCE_SERVICE="fabAssuranceService";
	
	public final static String CUSTOMER_USERDETAILS_SERVICE="fabCustomerUserDetailsService";
	
	public final static String WEB_SERVICE_ENDPOINT="fabFormaticWebService";

}
