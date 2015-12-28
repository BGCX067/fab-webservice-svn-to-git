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
import fab.formatic.web.dto.exception.BillingException;
import fab.formatic.web.dto.exception.ServiceOutputException;

public interface FabBillingService {

	BillTransactionOutput billTransaction(String accountID,
			ServiceDataList serviceDataList, String transID, boolean charged)
			throws BillingException;

	UpdateBillInfoOutput updateBillInfo(String accountID, int serviceSeq,
			String sessionID, String transID) throws BillingException;

	GetServiceOutput getService(String serviceID, String sessionID)
			throws ServiceOutputException;

	List<GetTarrifOutput> getTarrif(String serviceID, String sessionID,
			XMLGregorianCalendar viewDate) throws ServiceOutputException;

	GetServiceListOutput getServiceList(String accountID, String sessionID,
			String transID) throws ServiceOutputException;

	GetServiceDataOutput getServiceData(String accountID, int serviceSeq,
			String sessionID, String transID) throws ServiceOutputException;

	GetBillingDataOutput getBillingData(String accountID, int period,
			int serviceID) throws BillingException;
}
