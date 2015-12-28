package fab.formatic.web.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;

import fab.formatic.backend.domain.FabService;
import fab.formatic.backend.domain.FabServiceUsed;
import fab.formatic.backend.domain.FabTariff;
import fab.formatic.backend.service.FabBillingInputService;
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
import fab.formatic.web.service.FabBillingService;
import fab.formatic.web.util.FabWSConstant;

@Service(FabWSConstant.INBOUND_OUTBOUND_BILLING_SERVICE)
public class FabInOutBillingService implements FabBillingService {

	@Autowired
	private FabBillingInputService billingService;

	public GetServiceOutput getService(String serviceID, String sessionID) {
		FabService service = billingService.getServiceOutput(serviceID,
				sessionID);
		GetServiceOutput gso = new GetServiceOutput();
		gso.setOutMsg("Service: " + service.getServiceDesc());
		return gso;
	}

	public GetTarrifOutput getTarrif(String serviceID, String sessionID,
			XMLGregorianCalendar viewDate) {
		List<FabTariff> tariffs = billingService.getTariffOutput(serviceID,
				sessionID, viewDate.toGregorianCalendar().getTime());
		GetTarrifOutput gto = new GetTarrifOutput();

		for (FabTariff tariff : tariffs) {
			TarrifList tl = new TarrifList();
			tl.setInitiationFee(String.valueOf(tariff.getInitiationFee()));
			tl.setPeriodUnit(tariff.getPeriods());
			tl.setIsToBeBilled(tariff.isIsToBeBilled());
			tl.setPeriod(tariff.getPeriods());
			tl.setServiceID(tariff.getFabService().getId());

			GregorianCalendar end = new GregorianCalendar();
			end.setTime(tariff.getSalesEnd());

			GregorianCalendar start = new GregorianCalendar();
			start.setTime(tariff.getSalesStart());
			tl.setSalesEnd(new XMLGregorianCalendarImpl(start));

			Number number1 = new Number();
			number1.setIntValue(tariff.getQuantity());
			tl.setQuantity(number1);

			Number number2 = new Number();
			number2.setIntValue(tariff.getTerminationFee());
			tl.setTerminationFee(number2);

			Number number3 = new Number();
			number3.setStringValue(tariff.getServiceUnit());
			tl.setServiceUnit(number3);

			gto.getTarriflist().add(tl);
		}
		gto.setOutMsg("sukscute102");

		return null;
	}

	public GetServiceListOutput getServiceList(String accountID,
			String sessionID, String transID) {
		List<FabServiceUsed> serviceUseds = billingService.getServiceUsedsOutput(
											accountID, sessionID, transID);
		GetServiceListOutput output=new GetServiceListOutput();
		for (FabServiceUsed fsu : serviceUseds) {
			ServiceList serviceList = new ServiceList();
			serviceList.setServiceID(fsu.getFabService().getId());
			serviceList.setServiceName(fsu.getFabService().getServiceName());
			serviceList.setServiceType(fsu.getFabService().getFabTypeCharging().getTypeChargingName());
			serviceList.setServiceUsedId(fsu.getId());
			serviceList.setServiceAmt(String.valueOf(fsu.getServiceAmount()));

			GregorianCalendar gc = new GregorianCalendar();
			gc.setTime(fsu.getServiceStart());
			XMLGregorianCalendar calendar = new XMLGregorianCalendarImpl(gc);
			serviceList.setServiceStart(calendar);

			GregorianCalendar gc1 = new GregorianCalendar();
			gc1.setTime(fsu.getServiceEnd());
			XMLGregorianCalendar calendar1 = new XMLGregorianCalendarImpl(
					gc1);
			serviceList.setServiceEnd(calendar1);

			Number number = new Number();
			number.setDoubleValue(fsu.getServiceCount());
			serviceList.setServiceCount(number);
			
			
			
			for (FabTariff ft : billingService.findAllTariffs()) {
				if (ft.getFabService().equals(fsu.getFabService())) {
					serviceList.setServicePeriod(ft.getPeriods());
					serviceList.setServPeriodUnit(ft.getPeriodUnit());
					serviceList.setServiceUnit(ft.getServiceUnit());
					serviceList.setIsToBeBilled(ft.isIsToBeBilled());
				}
			}
			
			output.getServicelist().add(serviceList);
		}
		output.setOutMsg("sukscute102");
		return output;
	}

	public GetServiceDataOutput getServiceData(String accountID,
			int serviceUsedID, String sessionID, String transID) {
		List<FabServiceUsed> serviceUseds = billingService.getServiceUsedsOutput(
				accountID, sessionID, transID);
		GetServiceDataOutput output=new GetServiceDataOutput();
		for (FabServiceUsed fu : serviceUseds) {
			
			ServiceDataList serviceDataList=new ServiceDataList();
			
			
			Number number = new Number();
			number.setDoubleValue(fu.getDiscountAmount());
			serviceDataList.setDiscAmount(number);

			if (fu.getBillStatus() == 4) {
				serviceDataList.setIsCharged(true);
			} else {
				serviceDataList.setIsCharged(false);
			}

			serviceDataList.setIsExceed(fu.isIsExceed());
			serviceDataList.setServiceUsedId(fu.getId());

			Number number2 = new Number();
			number2.setIntValue(fu.getTransAmount());
			serviceDataList.setTransAmt(number2);
			
			output.getServicedatalist().add(serviceDataList);
			}
		output.setOutMsg("sukscute102");
		return output;
	}

	public UpdateBillInfoOutput updateBillInfo(String accountID,
			int serviceUsedId, String sessionID, String transID) {
		
		FabServiceUsed serviceUsed=billingService.updateServiceUsed(accountID, serviceUsedId, sessionID, transID);
		
		UpdateBillInfoOutput output=new UpdateBillInfoOutput();
		if (serviceUsed.getBillStatus() == 1) {
			serviceUsed.setBillStatus(2);
			output.setIsSuccess(true);
			output.setOutMsg("update success");

		} else if (serviceUsed.getBillStatus() == 2) {
			serviceUsed.setBillStatus(3);
			output.setIsSuccess(true);
			output.setOutMsg("update success");
		} else if (serviceUsed.getBillStatus() == 3) {
			serviceUsed.setBillStatus(4);
			output.setIsSuccess(true);
			output.setOutMsg("update success");
		} else if (serviceUsed.getServiceEnd().after(new Date())) {
			output.setIsSuccess(true);
			output.setOutMsg("service is expired");
		} else {
			output.setIsSuccess(false);
			output.setOutMsg("update failed");
		}
		return output;
	}

	public List<GetBillingDataOutput> getBillingData(String accountID,
			String period, int serviceID) {
		List<FabTariff> tariffs=billingService.findAllTariffs();
		List<GetBillingDataOutput> outputs = new ArrayList<GetBillingDataOutput>();
		if (tariffs != null && tariffs.size() > 0) 
		{
			for (FabTariff tariff : tariffs) 
			{
				GetBillingDataOutput gdo = new GetBillingDataOutput();
				BillingData billingData = new BillingData();
				billingData.setProductName(tariff.getFabService().getServiceName());
				billingData.setPeriod(String.valueOf(tariff.getPeriods()));
				for (FabServiceUsed fu : billingService.findAllFabServiceUseds()) 
				{
					if (fu.getFabService().equals(tariff.getFabService())) 
					{
						if (fu.getBillStatus() == 4) {
							billingData.setIsPaid(true);
						} else {
							billingData.setIsPaid(false);
						}
						billingData.setRevCodeName(fu.getRevCode());
						
						Number number = new Number();
						number.setIntValue(fu.getPaymentAmount());
						billingData.setAmount(number);
						
						Number number2 = new Number();
						number2.setDoubleValue(fu.getDiscountAmount());
						billingData.setDiscAmount(number2);

					}
				}
				gdo.setBillingdata(billingData);
				gdo.setOutMsg("sukses");
				outputs.add(gdo);
			}
		}
		return outputs;
		
	}

	public BillTransactionOutput billTransaction(String accountID,
			ServiceDataList serviceDataList, String transID) {
		
		billingService.persistServiceUsed(accountID, serviceDataList, transID);
		BillTransactionOutput output=new BillTransactionOutput();
		output.setIsSuccess(true);
		output.setOutMsg("sukscute102");
		return null;
	}

}
