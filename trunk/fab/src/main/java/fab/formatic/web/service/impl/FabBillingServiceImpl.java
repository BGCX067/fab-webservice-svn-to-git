package fab.formatic.web.service.impl;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;

import fab.formatic.backend.domain.FabOrder;
import fab.formatic.backend.domain.FabService;
import fab.formatic.backend.domain.FabServiceUsed;
import fab.formatic.backend.domain.FabTariff;
import fab.formatic.backend.service.FabInboundBillingService;
import fab.formatic.backend.service.FabOutboundBillingService;
import fab.formatic.web.dto.BillTransactionOutput;
import fab.formatic.web.dto.BillingData;
import fab.formatic.web.dto.GetBillingDataOutput;
import fab.formatic.web.dto.GetServiceDataOutput;
import fab.formatic.web.dto.GetServiceListOutput;
import fab.formatic.web.dto.GetServiceOutput;
import fab.formatic.web.dto.GetTarrifOutput;
import fab.formatic.web.dto.Number;
import fab.formatic.web.dto.ServiceDataList;
import fab.formatic.web.dto.ServiceList;
import fab.formatic.web.dto.TarrifList;
import fab.formatic.web.dto.UpdateBillInfoOutput;
import fab.formatic.web.dto.exception.BillingException;
import fab.formatic.web.dto.exception.ServiceOutputException;
import fab.formatic.web.service.FabBillingService;
import fab.formatic.web.util.FabWSHelper;

@SuppressWarnings("restriction")
@Service(FabWSHelper.BILLING_SERVICE)
public class FabBillingServiceImpl implements FabBillingService {

	@Autowired
	private FabInboundBillingService inboundBillingService;

	@Autowired
	private FabOutboundBillingService outboundBillingService;

	public BillTransactionOutput billTransaction(String accountID,
			ServiceDataList serviceDataList, String transID, boolean charged)
			throws BillingException {

		FabServiceUsed serviceUsed = outboundBillingService.billTransaction(
				transID, accountID, serviceDataList.getTransSeq(),
				serviceDataList.getTransAmt().getIntValue(), serviceDataList
						.getDiscAmount().getDoubleValue(), charged);
		BillTransactionOutput output=new BillTransactionOutput();
		if(serviceUsed==null){
			output.setIsSuccess(false);
			output.setOutMsg("fail");
			throw new BillingException(output.getOutMsg());
		}else{
			output.setOutMsg("succes");
			output.setIsSuccess(true);
		}		

		return output;
	}

	public UpdateBillInfoOutput updateBillInfo(String accountID,
			int serviceSeq, String sessionID, String transID)
			throws BillingException {
		FabServiceUsed used=inboundBillingService.updateBillStatus(transID, accountID, Integer.valueOf(serviceSeq));
		UpdateBillInfoOutput output=new UpdateBillInfoOutput();
		if(used==null){
			output.setIsSuccess(false);
			output.setOutMsg("failed to update");
			throw new BillingException(output.getOutMsg());
		}else{
			output.setIsSuccess(true);
			output.setOutMsg("update: bill status: "+used.getBillStatus());
		}
		return output;
	}

	public GetServiceOutput getService(String serviceID, String sessionID)
			throws ServiceOutputException {
		FabService service=inboundBillingService.getService(sessionID, serviceID);
		GetServiceOutput output=new GetServiceOutput();
		if(service==null){
			output.setServicelist(null);
			output.setOutMsg("service not found");
			throw new ServiceOutputException(output.getOutMsg());
		}else{
			ServiceList sList = new ServiceList();
			sList.setServiceID(service.getId());
			sList.setServiceName(service.getServiceName());
			sList.setServiceType(service.getServiceType());			
			output.setServicelist(sList);
			output.setOutMsg(new String("Service"));
		}
		return output;
	}

	public List<GetTarrifOutput> getTarrif(String serviceID, String sessionID,
			XMLGregorianCalendar viewDate) throws ServiceOutputException {
		List<FabTariff> fabTariffs = inboundBillingService.getTariff(serviceID,
				sessionID, viewDate.toGregorianCalendar().getTime());
		List<GetTarrifOutput> outputs = new ArrayList<GetTarrifOutput>();
		if (fabTariffs == null || fabTariffs.size() == 0) {
			GetTarrifOutput output = new GetTarrifOutput();
			output.setOutMsg("no tariffs found");
			output.setTarriflist(null);
			outputs.add(output);
			throw new ServiceOutputException(output.getOutMsg());
		}
		for (FabTariff t : fabTariffs) {
			GetTarrifOutput gto = new GetTarrifOutput();
			TarrifList tl = new TarrifList();
			tl.setInitiationFee(String.valueOf(t.getInitiationFee()));
			tl.setIsToBeBilled(t.isIsToBeBilled());
			tl.setPeriod(t.getPeriods());
			tl.setPeriodUnit(t.getPeriodUnit()); 
			Number n1 = new Number();
			n1.setIntValue(t.getQuantity());
			Number n2 = new Number();
			n2.setDoubleValue(Double.valueOf(t.getTerminationFee()));
			Number n3 = new Number();
			n3.setStringValue(t.getServiceUnit());
			tl.setQuantity(n1);
			tl.setTerminationFee(n2);
			tl.setServiceUnit(n3);

			GregorianCalendar gcalendar1 = new GregorianCalendar();
			gcalendar1.setTime(t.getSalesStart());
			XMLGregorianCalendar calendar1 = new XMLGregorianCalendarImpl(gcalendar1);

			GregorianCalendar gcalendar2 = new GregorianCalendar();
			gcalendar2.setTime(t.getSalesEnd());
			XMLGregorianCalendar calendar2 = new XMLGregorianCalendarImpl(gcalendar2);
			tl.setServiceID(t.getFabService().getId());
			tl.setSalesStart(calendar1);
			tl.setSalesEnd(calendar2);

			gto.setTarriflist(tl);
			gto.setOutMsg("Tariff dari " + serviceID  );
			
			outputs.add(gto);
		}
		return outputs;
	}

	public GetServiceListOutput getServiceList(String accountID,
			String sessionID, String transID) throws ServiceOutputException {
		FabServiceUsed used=inboundBillingService.getServiceList(sessionID, transID, accountID);
		GetServiceListOutput output=new GetServiceListOutput();
		if(used!=null){
			ServiceList serviceList=new ServiceList();
			serviceList.setIsToBeBilled(used.getBillStatus()<4);
			serviceList.setServiceAmt(String.valueOf(used.getFabOrder().getFabCustomer().getServiceAmount()));
			Number n1 = new Number();
			n1.setIntValue(used.getFabOrder().getFabCustomer().getServiceCount());
			serviceList.setServiceCount(n1);
			serviceList.setServiceID(used.getFabOrder().getFabService().getId());
			serviceList.setServiceName(used.getFabOrder().getFabService().getServiceName());
			List<FabTariff> tariffs = new ArrayList<FabTariff>();
			for(FabTariff t:tariffs)
			{
				if(t.getFabService().getId() == used.getFabOrder().getFabService().getId())
				{
					serviceList.setServicePeriod(t.getPeriods());
					serviceList.setServiceUnit(t.getServiceUnit());
					serviceList.setServPeriodUnit(String.valueOf(t.getPeriodUnit()));
				}				
			}
			serviceList.setServiceSeq(used.getId());
			serviceList.setServiceType(used.getFabOrder().getFabService().getServiceType());
						
			output.setServicelist(serviceList);
			output.setOutMsg("Service List");	
			
		}else{
			output.setServicelist(null);
			output.setOutMsg("failed to retrieve service list");
			throw new ServiceOutputException(output.getOutMsg());
		}
		return output;
	}

	public GetServiceDataOutput getServiceData(String accountID,
			int serviceSeq, String sessionID, String transID)
			throws ServiceOutputException {
		FabOrder order=inboundBillingService.getOrderServiceData(accountID, transID);
		FabServiceUsed used=inboundBillingService.getServiceUsedServiceData(order);
		GetServiceDataOutput output=new GetServiceDataOutput();
		if(used!=null){
			ServiceDataList sdl = new ServiceDataList();
			sdl.setTransSeq(serviceSeq);
			sdl.setIsCharged(used.getBillStatus() < 4);
			Number n = new Number();
			n.setDoubleValue(used.getDiscountAmount());
			sdl.setDiscAmount(n);
			Number n1 = new Number();
			n1.setIntValue(used.getTransAmount());
			sdl.setTransAmt(n1);			
			GregorianCalendar gc=new GregorianCalendar();
			gc.setTime(used.getTransDate());
			XMLGregorianCalendar calendar=new XMLGregorianCalendarImpl(gc);
			sdl.setTransDateTime(calendar);
			output.setOutMsg("Service Data");
			output.setServicedatalist(sdl);
		}else{
			output.setServicedatalist(null);
			output.setOutMsg("fail");
			throw new ServiceOutputException(output.getOutMsg());
		}
		return output;
	}

	public GetBillingDataOutput getBillingData(String accountID, int period,
			int serviceID) throws BillingException {
		FabServiceUsed serviceUsed=outboundBillingService.getBillingData(accountID, String.valueOf(period), serviceID);
		GetBillingDataOutput output=new GetBillingDataOutput();
		if(serviceUsed==null){
			output.setBillingdata(null);
			output.setOutMsg("no billing data found");
			throw new BillingException(output.getOutMsg());
		}
		BillingData data=new BillingData();
		Number n = new Number();
		n.setIntValue(serviceUsed.getPaymentAmount());
		data.setAmount(n);
		Number n1 = new Number();
		n1.setDoubleValue(serviceUsed.getDiscountAmount());
		data.setDiscAmount(n1);
		if(serviceUsed.getBillStatus()==4)
		{
			data.setIsPaid(true);
		}		
		data.setRevCodeName(serviceUsed.getRevCode());
		data.setPeriod(serviceUsed.getPaymentPeriod());
		
		data.setProductName(serviceUsed.getFabOrder().getFabService().getServiceName());
		output.setBillingdata(data);
		output.setOutMsg("success");
		return output;
	}


}
