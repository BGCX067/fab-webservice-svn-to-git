package fab.formatic.web.service;

import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import fab.formatic.web.dto.BillTransactionOutput;
import fab.formatic.web.dto.GetBillingDataOutput;
import fab.formatic.web.dto.GetServiceDataOutput;
import fab.formatic.web.dto.GetServiceListOutput;
import fab.formatic.web.dto.GetServiceOutput;
import fab.formatic.web.dto.GetTarrifOutput;
import fab.formatic.web.dto.ServiceDataList;
import fab.formatic.web.dto.UpdateBillInfoOutput;

/**
 * @author gilang
 *
 */
public interface FabBillingService {

	List<GetServiceOutput> getService(String serviceID, String sessionID);

	List<GetTarrifOutput> getTariff(String serviceID, String sessionID,XMLGregorianCalendar viewDate);
	
	List<GetServiceDataOutput> getServiceData(String accountID,int serviceUsedId, String sessionID, String transID);
	
	GetServiceListOutput getServiceList(String accountID,String sessionID, String transID);
	
	UpdateBillInfoOutput updateBillInfo(String accountID,int serviceUsedId, String sessionID, String transID);
	
	List<GetBillingDataOutput> getBillingData(String accountID,String periode, int serviceID);
	
	BillTransactionOutput billTransaction(String accountID,ServiceDataList serviceDataList, String transID);

}
