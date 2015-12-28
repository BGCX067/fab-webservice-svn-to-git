package fab.formatic.test;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;

import fab.formatic.web.dto.BillTransactionOutput;
import fab.formatic.web.dto.GetBillingDataOutput;
import fab.formatic.web.dto.GetServiceDataOutput;
import fab.formatic.web.dto.GetServiceListOutput;
import fab.formatic.web.dto.GetServiceOutput;
import fab.formatic.web.dto.GetTarrifOutput;
import fab.formatic.web.dto.Module;
import fab.formatic.web.dto.Number;
import fab.formatic.web.dto.OrderInputOutput;
import fab.formatic.web.dto.Package;
import fab.formatic.web.dto.ServiceDataList;
import fab.formatic.web.dto.ServiceList;
import fab.formatic.web.dto.Trans;
import fab.formatic.web.dto.UpdateBillInfoOutput;
import fab.formatic.web.service.FabAssuranceService;
import fab.formatic.web.service.FabBillingService;
import fab.formatic.web.service.FabFullfillmentService;
import fab.formatic.web.service.FabGeneralService;

/**
 * @author gilang
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-context.xml")
public class ServiceUnitTest {

	final static Logger logger = Logger
			.getLogger(ServiceUnitTest.class);

	@Autowired
	FabAssuranceService assuranceService;

	@Autowired
	FabBillingService billingService;

	@Autowired
	FabFullfillmentService fullfillmentService;

	@Autowired
	FabGeneralService generalService;

	@Test
	public void getServiceInfo() {
		String info = generalService.getServiceInfo("service001");
		Assert.assertNotNull(info);
		logger.info("service found: " + info);
	}

	@Test
	public void getModuleInfo() {
		String info = generalService.getModuleInfo("service001", "modul001");
		Assert.assertNotNull(info);
		logger.info("module found: " + info);
	}

	@Test
	public void orderInput() {

		Package p = new Package();
		p.setName("packet 001");
		Module m = new Module();
		m.setName("modul001");
		OrderInputOutput output = fullfillmentService.orderInput("account001",
				m, p, null, "service001", "xxxx", "TERMINATION", "id21");
		Assert.assertNotNull(output);
		logger.info("order input: " + output.getOutMsg() + ", "
				+ output.getOutAttr().getValue());
	}
	
	@Test
	public void orderInputAgain() {

		Package p = new Package();
		p.setName("packet 001");
		Module m = new Module();
		m.setName("modul001");
		OrderInputOutput output = fullfillmentService.orderInput("account001",
				m, p, null, "service001", "xxxx", "RESUMPTION", "id22");
		Assert.assertNotNull(output);
		logger.info("order input: " + output.getOutMsg() + ", "
				+ output.getOutAttr().getValue());
	}
	
	@Test
	public void orderTracking()
	{
		List<Trans> tracking=fullfillmentService.orderTracking("account001", "service001", "xxxx", "id22");
		Assert.assertNotNull(tracking);
		Assert.assertTrue(tracking.size()>0);
		for(Trans t:tracking)
		{
			System.out.println("ORDER TRACKING: "+t.getTransType());
		}
	}
	
	@Test
	public void getService()
	{
		List<GetServiceOutput> output=billingService.getService("service001", "xxxx");
		Assert.assertNotNull(output);
		Assert.assertTrue(output.size()>0);
		for(GetServiceOutput go:output)
		{
			System.out.println("service: "+go.getServicelist().getServiceName());
		}
	}
	
	@Test
	public void getTariff()
	{
		GregorianCalendar gc=new GregorianCalendar();
		gc.setTime(new Date());
		XMLGregorianCalendar calendar=new XMLGregorianCalendarImpl(gc);
		List<GetTarrifOutput> outputs=billingService.getTariff("service001", "xxxx", calendar);
		Assert.assertNotNull(outputs);
		Assert.assertTrue(outputs.size()>0);
		for(GetTarrifOutput gto:outputs){
			System.out.println(gto.getTarriflist().getInitiationFee());
		}
	}
	
	@Test
	public void getServiceList()
	{
		GetServiceListOutput output=billingService.getServiceList("account001", "xxxx", "id21");
		Assert.assertNotNull(output);
		Assert.assertTrue(output.getServicelist().size()>0);
		for(ServiceList sl:output.getServicelist()){
			System.out.println("Service UsedID"+sl.getServiceUsedId());
		}
	}
	
	@Test
	public void updateBillInfo()
	{
		UpdateBillInfoOutput output=billingService.updateBillInfo("account001", 2, "xxxx", "id21");
		Assert.assertNotNull(output);
		System.out.println("updateBillInfo message: "+output.getOutMsg());
	}
	
	@Test
	public void getBillingData()
	{
		List<GetBillingDataOutput> outputs=billingService.getBillingData("account001", "", 1);
		Assert.assertNotNull(outputs);
		for(GetBillingDataOutput gdo:outputs){
			System.out.println("billing data: "+gdo.getBillingdata().getProductName());
		}
	}
	
	@Test
	public void billTransaction()
	{
		ServiceDataList sdl=new ServiceDataList();
		sdl.setServiceUsedId(2);
		sdl.setIsCharged(false);
		Number n=new Number();
		n.setIntValue(21);
		Number n2=new Number();
		n2.setDoubleValue(21.2);
		sdl.setTransAmt(n);
		sdl.setDiscAmount(n2);
		
		BillTransactionOutput output=billingService.billTransaction("account001", sdl, "id21");
		Assert.assertNotNull(output);
		System.out.println("bill transaction output: "+output.getOutMsg());
	}
	
	@Test
	public void getServiceData()
	{
		List<GetServiceDataOutput> outputs=billingService.getServiceData("account001", 2, "xxxx", "id21");
		Assert.assertNotNull(outputs);
		for(GetServiceDataOutput o:outputs)
		{
			System.out.println(o.getServicedatalist().getServiceUsedId());
		}
	}
}
