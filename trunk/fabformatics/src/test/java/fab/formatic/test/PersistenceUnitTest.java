package fab.formatic.test;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fab.formatic.backend.dao.FabCustomerDao;
import fab.formatic.backend.dao.FabModuleDao;
import fab.formatic.backend.dao.FabOrderDao;
import fab.formatic.backend.dao.FabPackageDao;
import fab.formatic.backend.dao.FabServiceDao;
import fab.formatic.backend.dao.FabServiceStatusDao;
import fab.formatic.backend.dao.FabServiceUsedDao;
import fab.formatic.backend.dao.FabTariffDao;
import fab.formatic.backend.domain.FabCustomer;
import fab.formatic.backend.domain.FabModule;
import fab.formatic.backend.domain.FabOrder;
import fab.formatic.backend.domain.FabPackage;
import fab.formatic.backend.domain.FabService;
import fab.formatic.backend.domain.FabServiceStatus;
import fab.formatic.backend.domain.FabServiceUsed;
import fab.formatic.backend.domain.FabTariff;
import fab.formatic.backend.service.FabOrderService;
import fab.formatic.web.dto.Module;
import fab.formatic.web.dto.Package;

/**
 * @author gilang
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-context.xml")
public class PersistenceUnitTest {

	private static Logger logger = Logger.getLogger(PersistenceUnitTest.class);
	
	//private final ApplicationContext context=new ClassPathXmlApplicationContext("classpath:test-context.xml");

	@Autowired
	FabCustomerDao customerDao;
	
	@Autowired
	FabServiceDao serviceDao;
	
	@Autowired
	FabPackageDao packageDao;
	
	@Autowired
	FabModuleDao fabModuleDao;
	
	@Autowired
	FabOrderDao orderDao;
	
	@Autowired
	FabOrderService orderService;
	
	@Autowired
	FabServiceStatusDao serviceStatusDao;
	
	@Autowired
	FabServiceUsedDao serviceUsedDao;
	
	@Autowired
	FabTariffDao tariffDao;
	
	@Test
	public void testPersistCustomer()
	{
		Assert.assertNotNull(customerDao);
		FabCustomer fc=new FabCustomer();
		fc.setAccountID("account001");
		fc.setAdminEmail("ngadimin001@mail.com");
		fc.setCustomerAddress("customer address no 1");
		fc.setCustomerName("Si Customer No 1");
		fc.setPassword("passwordcustomer1");
		fc.setCustomerID("customer001");
		Assert.assertNotNull(fc);
		customerDao.persist(fc);
		logger.debug("persist data:"+fc.getAccountID());
		FabCustomer fc2=customerDao.findByAdminEmail("ngadimin001@mail.com");
		logger.debug("load data:"+fc2.getAccountID());
		Assert.assertNotNull(fc2);
	}
	
	@Test(expected=Exception.class)
	public void testPersistCustomerAgain()
	{
		Assert.assertNotNull(customerDao);
		FabCustomer fc=new FabCustomer();
		fc.setAccountID("account001");
		fc.setAdminEmail("ngadimin001@mail.com");
		fc.setCustomerAddress("customer address no 1");
		fc.setCustomerName("Si Customer No 1");
		fc.setPassword("passwordcustomer1");
		fc.setCustomerID("customer001");
		Assert.assertNotNull(fc);
		customerDao.persist(fc);
		logger.debug("persist data:"+fc.getAccountID());
		//FabCustomer fc2=customerDao.findByAdminEmail("ngadimin001@mail.com");
		//logger.debug("load data:"+fc2.getAccountID());
		//Assert.assertNotNull(fc2);
	}
	
	
	@Test
	public void testPersistService()
	{
		Assert.assertNotNull(serviceDao);
		FabService fs=new FabService();
		fs.setServiceID("service001");
		fs.setServiceDesc("service description 001");
		fs.setTypeCharging("type charging 1");
		fs.setTypeChargingDesc("type chargin no desc no 1");
		fs.setServiceName("service jok, kursi, parabot batur");
		serviceDao.persist(fs);
		logger.info("persist service: "+fs.getServiceName());
	}
	
	@Test
	public void testServiceQuery() throws DataAccessException
	{
		Assert.assertNotNull(serviceDao);
		FabService fs=serviceDao.findByServiceID("service001");
		//assertEquals(fs.getServiceID().equals(query), query.equals("service001"));
		Assert.assertNotNull(fs);
		logger.info("load service: "+fs.getServiceDesc());
	}
	
	@Test
	public void testPersistPackage()
	{
		Assert.assertNotNull(packageDao);
		FabPackage fp=new FabPackage();
		fp.setPackageName("packet 001");
		fp.setPackageDesc("packet desc no 1 is dead");
		FabService fs=serviceDao.findByServiceID("service001");
		Assert.assertNotNull(fs);
		fp.setFabService(fs);
		fp.setTypeCharging(fs.getTypeCharging());
		fp.setTypeChargingDesc(fs.getTypeChargingDesc());
		packageDao.persist(fp);
		logger.info("persis package: "+fp.getPackageName()+" for service: "+fp.getFabService().getServiceName());
		
	}
	
	@Test
	public void testPersistModule()
	{
		Assert.assertNotNull(fabModuleDao);
		FabPackage fp=packageDao.findByPackageName("packet 001");
		Assert.assertNotNull(fp);
		FabModule fm=new FabModule();
		fm.setModuleName("modul001");
		fm.setModuleDesc("paket soal snmptn dijamin lulus kedokteran Unpad");
		fm.getFabPackages().add(fp);
		fm.setFabService(fp.getFabService());
		fabModuleDao.persist(fm);
		logger.info("persist module: "+fm.getModuleName()+"for package: "+fm.getFabPackages().get(0).getPackageName()+ "at service: "+fm.getFabService().getServiceName());
		
	}
	
	
	
	@Test
	public void testPersistStandAloneModule()
	{
		Assert.assertNotNull(serviceDao);
		FabService fs=serviceDao.findByServiceID("service001");
		Assert.assertNotNull(fs);
		FabModule fm=new FabModule();
		fm.setFabService(fs);
		fm.setModuleName("module yu ya yuuu");
		fm.setModuleDesc("module yu ya yuu edan tenan, djancuk karo usus, pancen o ye");
		fm.setTypeCharging(fs.getTypeCharging());
		fm.setTypeChargingDesc(fs.getTypeChargingDesc());
		fabModuleDao.persist(fm);
		logger.info("persist stand alone: "+fm.getModuleName());
		FabModule fm2=fabModuleDao.findByModuleName("module yu ya yuuu");
		Assert.assertNotNull(fm2);
		System.out.println("load module: "+fm2.getModuleName()+" in service: "+fm2.getFabService().getServiceName());
	}
	
	@Test
	public void testPersistOrder()
	{
		Assert.assertNotNull(orderService);
		FabPackage fp=packageDao.findByPackageName("packet 001");
		Package p=new Package();
		p.setName(fp.getPackageName());
		
		FabModule fm=fabModuleDao.findByModuleName("modul001");
		
		logger.info("loading data: "+fm.getModuleName());
		
		Module m=new Module();
		m.setName(fm.getModuleName());
		
		//Assert.assertNotNull(fm);
		
		FabOrder fo=orderService.orderInput("account001", m, p, null, "service001", "session", "ACTIVATION", "trans001");
		Assert.assertNotNull(fo);
		logger.debug("persist order: "+fo.getTransType().toString()+" persis service status: ");
		
		List<FabServiceStatus> status=serviceStatusDao.findByFabOrder(fo);
		
		for(FabServiceStatus fss:status)
		{
			System.out.println(fss.getStatus());
		}
		
	}
	
	@Test
	public void testTrackOrder()
	{
		FabOrder order=orderService.trackOrder("account001", "service001", "trans001");
		if(order!=null)
			logger.info(order.getTransType());
		else
			logger.info("null order ");
		
		List<FabServiceUsed> useds=serviceUsedDao.findByFabOrder(order);
		for(FabServiceUsed u:useds)
		{
			System.out.println("+++++++++++++"+u.getBillStatus());
		}
	}
	
	@Test
	public void testPersistTariff()
	{
		FabTariff tariff=new FabTariff();
		tariff.setInitiationFee(2000);
		tariff.setPeriods(3);
		tariff.setQuantity(3);
		tariff.setPeriodUnit("unit 1");
		Date d=new Date();
		tariff.setServiceStart(d);
		Calendar c=Calendar.getInstance();
		c.setTime(d);
		c.add(Calendar.DATE, 19);
		tariff.setServiceEnd(c.getTime());
		tariff.setTerminationFee(100);
		tariff.setToBeBilled(true);
		
		FabService s=serviceDao.findByServiceID("service001");
		tariff.setFabService(s);
		
		FabPackage fs=packageDao.findByPackageName("packet 001");
		tariff.setFabPackage(fs);
		
		FabModule fm=fabModuleDao.findByModuleName("modul001");
		tariff.setFabModule(fm);
		
		tariffDao.persist(tariff);
		logger.info("persist tariff: "+tariff.getServiceEnd());
		
		List<FabTariff> tariffs=tariffDao.findByFabPackage(fs);
		for(FabTariff ft:tariffs)
		{
			System.out.println("xxxxxxxxxxxxxxx Tariff for:"+ft.getFabPackage().getPackageName());
		}
		List<FabTariff> tariffs2=tariffDao.findByFabModule(fm);
		for(FabTariff ft:tariffs2)
		{
			System.out.println("xxxxxxxxxxxxxxx Tariff for:"+ft.getFabModule().getModuleName());
		}
		List<FabTariff> tariffs3=tariffDao.findByFabService(s);
		for(FabTariff ft:tariffs3)
		{
			System.out.println("xxxxxxxxxxxxxxx Tariff for:"+ft.getFabService().getServiceID());
		}
		
		
		
		
	}
	
	
	
	
	
}
