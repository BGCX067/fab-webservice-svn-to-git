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
		
	public final static String PACKAGE_DAO="fabPackageDao";
		
	public final static String ORDER_DAO="fabOrderDao";
	
	public static final String ORDER_SERVICE="fabOrderService";	
	
	public static final String HOST_DAO="fabHostDao";
	
	public final static String PROMO_DAO="fabPromoDao";
	
	public final static String URL_DAO="fabUrlDao";
	
	public final static String COMPLAINT_DAO="fabComplaintDao";
	
	public final static String COMPLAINT_SERVICE="fabIncidentService";		
	
	public final static String SPRING_CONFIG_DAO="classpath:applicationContext-jpa.xml";
	
	public final static String ACTIVATION_ORDER=FabTransactionType.ENUM_CLASS_NAME+"."+"ACTIVATION";
	
	public final static String SUSPENSION_ORDER=FabTransactionType.ENUM_CLASS_NAME+"."+"SUSPENSION";
	
	public final static String RESUMPTION_ORDER=FabTransactionType.ENUM_CLASS_NAME+"."+"RESUMPTION";
	
	public final static String TERMINATION_ORDER=FabTransactionType.ENUM_CLASS_NAME+"."+"TERMINATION";
	
	public final static String EXPIRATION_TYPE=FabTypeCharging.ENUM_CLASS_NAME+"."+"EXPIRATION";
			
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
