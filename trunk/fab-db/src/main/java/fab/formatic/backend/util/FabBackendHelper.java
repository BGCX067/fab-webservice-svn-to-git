package fab.formatic.backend.util;

import java.util.Random;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fab.formatic.backend.domain.enumerate.FabTransactionType;
import fab.formatic.backend.domain.enumerate.FabTypeCharging;

/**
 * @author gilang
 *
 */
public abstract class FabBackendHelper {
	
	public static final String CUSTOMER_DAO="fabCustomerDao";
	
	public static final String CUSTOMER_SERVICE="fabCustomerService";
	
	public final static String SERVICE_DAO="fabServiceDao";
	
	public final static String PACKAGE_DAO="fabPackageDao";
	
	public final static String MODULE_DAO="fabModuleDao";
        
        public final static String MODULE_STATUS_DAO="fabModuleStatusDao";
	
	public final static String ORDER_DAO="fabOrderDao";
	
	public static final String ORDER_SERVICE="fabOrderService";
	
	public final static String LOGIN_DAO="fabLoginDao";
	
	public final static String TARIFF_DAO="fabTariffDao";
	
	public final static String INCIDENT_DAO="fabIncidentDao";
	
	public final static String INCIDENT_SERVICE="fabIncidentService";
	
	public final static String SERVICE_USED_DAO="fabServiceUsedDao";
	
	public final static String SERVICE_STATUS_DAO="fabServiceStatusDao";
	
	public final static String INBOUND_BILLING_SERVICE="fabInboundBillingService";
	
	public final static String OUTBOUND_BILLING_SERVICE="fabOutboundBillingService";
	
	public final static String SPRING_CONFIG_DAO="classpath:applicationContext-jpa.xml";
	
	public final static String ACTIVATION_ORDER=FabTransactionType.ENUM_CLASS_NAME+"."+"ACTIVATION";
	
	public final static String SUSPENSION_ORDER=FabTransactionType.ENUM_CLASS_NAME+"."+"SUSPENSION";
	
	public final static String RESUMPTION_ORDER=FabTransactionType.ENUM_CLASS_NAME+"."+"RESUMPTION";
	
	public final static String TERMINATION_ORDER=FabTransactionType.ENUM_CLASS_NAME+"."+"TERMINATION";
	
	public final static String EXPIRATION_TYPE=FabTypeCharging.ENUM_CLASS_NAME+"."+"EXPIRATION";
	
	public final static String QUOTA_TYPE=FabTypeCharging.ENUM_CLASS_NAME+"."+"QUOTA";
	
	private static ApplicationContext context;
	
	public static Object getFabDAOBeans(String springBeansName)
	{
		if(context==null)
			context=new ClassPathXmlApplicationContext(SPRING_CONFIG_DAO);
		return context.getBean(springBeansName);
	}
	
	public static String generateTransId(){
		StringBuilder builder=new StringBuilder();
		builder.append("TRANS");
		Random random=new Random();
		long rand=random.nextLong()%1000;
		builder.append(rand);
		return builder.toString();
	}
	
	
}
