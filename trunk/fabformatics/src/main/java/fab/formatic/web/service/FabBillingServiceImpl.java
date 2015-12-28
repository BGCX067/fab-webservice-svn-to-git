package fab.formatic.web.service;

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
import fab.formatic.web.util.FabWSHelper;

/**
 * @author gilang
 *
 */
@Service(FabWSHelper.BILLING_SERVICE)
public class FabBillingServiceImpl implements FabBillingService {

	@Autowired
	private FabInboundBillingService inboundBillingService;

	@Autowired
	private FabOutboundBillingService outboundBillingService;

	public List<GetServiceOutput> getService(String serviceID, String sessionID) {
		List<GetServiceOutput> outputs = new ArrayList<GetServiceOutput>();
		FabService service = inboundBillingService.getService(sessionID,
				serviceID);
		GetServiceOutput serviceOutput = new GetServiceOutput();
		if (service == null) {
			serviceOutput.setServicelist(null);
			serviceOutput.setOutMsg("no service found");
		} else {
			ServiceList sList = new ServiceList();
			sList.setServiceID(service.getId());
			sList.setServiceName(service.getServiceName());
			sList.setServiceType(service.getServiceType());
			serviceOutput.setServicelist(sList);
		}
		outputs.add(serviceOutput);
		return outputs;
	}

	public List<GetTarrifOutput> getTariff(String serviceID, String sessionID,
			XMLGregorianCalendar viewDate) {
		List<FabTariff> fabTariffs = inboundBillingService.getTariff(serviceID,
				sessionID, viewDate.toGregorianCalendar().getTime());
		List<GetTarrifOutput> outputs = new ArrayList<GetTarrifOutput>();
		if (fabTariffs == null || fabTariffs.size() == 0) {
			GetTarrifOutput output = new GetTarrifOutput();
			output.setOutMsg("no tariffs found");
			output.setTarriflist(null);
			outputs.add(output);
		}
		for (FabTariff t : fabTariffs) {
			GetTarrifOutput gto = new GetTarrifOutput();
			TarrifList tl = new TarrifList();
			tl.setInitiationFee(String.valueOf(t.getInitiationFee()));
			tl.setIsToBeBilled(t.isToBeBilled());
			tl.setPeriod(t.getPeriods());
			//tl.setPeriodUnit(Integer.parseInt(t.getPeriodUnit())); illegal argument String to Integer
			Number n1 = new Number();
			n1.setIntValue(t.getQuantity());
			Number n2 = new Number();
			n2.setIntValue(t.getTerminationFee());
			Number n3 = new Number();
			n3.setStringValue(t.getServiceUnit());
			tl.setQuantity(n1);
			tl.setTerminationFee(n2);
			tl.setServiceUnit(n3);

			GregorianCalendar gcalendar1 = new GregorianCalendar();
			gcalendar1.setTime(t.getServiceStart());
			XMLGregorianCalendar calendar1 = new XMLGregorianCalendarImpl(
					gcalendar1);

			GregorianCalendar gcalendar2 = new GregorianCalendar();
			gcalendar2.setTime(t.getServiceEnd());
			XMLGregorianCalendar calendar2 = new XMLGregorianCalendarImpl(
					gcalendar2);

			tl.setSalesStart(calendar1);
			tl.setSalesEnd(calendar2);

			gto.setTarriflist(tl);
			outputs.add(gto);
		}
		return outputs;
	}

	public GetServiceListOutput getServiceList(String accountID,
			String sessionID, String transID) {
		List<FabServiceUsed> useds = inboundBillingService.getServiceList(
				sessionID, transID, accountID, null);
		GetServiceListOutput listOutput = new GetServiceListOutput();
		if (useds != null && useds.size() > 0) {
			for (FabServiceUsed fsu : useds) {
				ServiceList sl = new ServiceList();
				//sl.setIsToBeBilled(fsu.getFabTariff().isToBeBilled()); FabTariff hasn't been set to fsu
				sl.setServiceAmt(String.valueOf(fsu.getServiceAmount()));
				sl.setServiceUsedId(fsu.getId());
				// dan lain lain;
				listOutput.getServicelist().add(sl);
			}
		} else {
			listOutput.setOutMsg("no service used found");
		}
		return listOutput;
	}

	public UpdateBillInfoOutput updateBillInfo(String accountID,
			int serviceUsedId, String sessionID, String transID) {
		FabServiceUsed fsu = inboundBillingService.updateBillStatus(transID,
				accountID, Integer.valueOf(serviceUsedId));
		UpdateBillInfoOutput output = new UpdateBillInfoOutput();
		if (fsu != null) {
			output.setIsSuccess(true);
			output.setOutMsg("sukscute"+fsu.getBillStatus());
		} else {
			output.setIsSuccess(false);
			output.setOutMsg("sukstidakcute");
		}
		return output;
	}

	public List<GetBillingDataOutput> getBillingData(String accountID,
			String periode, int serviceID) {
		List<FabServiceUsed> useds = outboundBillingService.getBillingData(
				accountID, periode, serviceID);
		List<GetBillingDataOutput> outputs = new ArrayList<GetBillingDataOutput>();
		if (useds != null && useds.size() > 0) {
			for (FabServiceUsed fsu : useds) {
				GetBillingDataOutput output = new GetBillingDataOutput();
				BillingData bd = new BillingData();
				bd.setIsPaid(fsu.getBillStatus() == 4);
				bd.setProductName(fsu.getFabOrder().getFabService()
						.getServiceName());
				// dan lain-lain
				output.setBillingdata(bd);
				outputs.add(output);
			}
		} else {
			GetBillingDataOutput output = new GetBillingDataOutput();
			output.setBillingdata(null);
			output.setOutMsg("error");
			outputs.add(output);
		}
		return outputs;
	}

	public BillTransactionOutput billTransaction(String accountID,
			ServiceDataList serviceDataList, String transID) {

		Integer serviceUsedID = serviceDataList.getServiceUsedId();
		boolean charged = serviceDataList.isIsCharged();
		Integer transAmount = serviceDataList.getTransAmt().getIntValue();
		double discAmount = serviceDataList.getDiscAmount().getDoubleValue();
		FabServiceUsed useds = outboundBillingService.billTransaction(transID,
				accountID, serviceUsedID, transAmount, discAmount, charged);
		BillTransactionOutput output=new BillTransactionOutput();
		if(useds!=null){
			output.setIsSuccess(true);
			output.setOutMsg("sukscute: "+useds.getBillStatus());
		}else{
			output.setIsSuccess(false);
			output.setOutMsg("sukstidakcute");
		}

		return output;
	}

	public List<GetServiceDataOutput> getServiceData(String accountID,
			int serviceUsedId, String sessionID, String transID) {
		FabOrder order = inboundBillingService.getOrderServiceData(accountID,
				transID);
		List<FabServiceUsed> useds = inboundBillingService
				.getServiceUsedServiceData(order);
		List<GetServiceDataOutput> outputs = new ArrayList<GetServiceDataOutput>();
		if (useds != null && useds.size() > 0) {
			for (FabServiceUsed fsu : useds) {
				GetServiceDataOutput output = new GetServiceDataOutput();
				ServiceDataList sdl = new ServiceDataList();
				sdl.setServiceUsedId(serviceUsedId);
				sdl.setIsCharged(fsu.getBillStatus() < 4);
				// dan lain-lain
				output.setServicedatalist(sdl);
				outputs.add(output);
			}
		} else {
			GetServiceDataOutput output = new GetServiceDataOutput();
			output.setServicedatalist(null);
			output.setOutMsg("no service found");
			outputs.add(output);
		}
		return outputs;
	}

}
