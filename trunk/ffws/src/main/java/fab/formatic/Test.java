package fab.formatic;

import java.util.ArrayList;
import java.util.List;

import fab.formatic.backend.dao.FabCustomerDao;
import fab.formatic.backend.dao.FabOrderDao;
import fab.formatic.backend.dao.FabServiceDao;
import fab.formatic.backend.domain.FabCustomer;
import fab.formatic.backend.domain.FabOrder;
import fab.formatic.backend.domain.FabService;
import fab.formatic.backend.util.FabBeansLocator;

public class Test {
	
	public static void main(String[] args)
	{
		
		FabCustomerDao customerDao=(FabCustomerDao) FabBeansLocator.getDaoClass(FabBeansLocator.CUSTOMER_DAO);
		FabServiceDao serviceDao=(FabServiceDao) FabBeansLocator.getDaoClass(FabBeansLocator.SERVICE_DAO);
		FabCustomer fc=customerDao.findByAdminEmail("email1");
		FabService fs=serviceDao.findByServiceId("SERVICE1");
		System.out.println(fc.getAccountID());
		System.out.println(fs.getServiceDesc());
		
		FabOrderDao orderDao=(FabOrderDao)FabBeansLocator.getDaoClass(FabBeansLocator.ORDER_DAO);
		List<FabOrder> orders=orderDao.findByAccountServiceID(fc.getAccountID(), fs.getServiceID());
		List<FabOrder> baru=new ArrayList<FabOrder>();
		for(FabOrder o:orders){
			if(o.getTransID().equals("id1")){
				baru.add(o);
			}
		}
		
		for(FabOrder or:baru){
			System.out.println(or.getTransType());
		}
		
		/**
		FabStatusOrder fso = new FabStatusOrder();
        fso.setStatusOrderName("statusName2");
        fso.setStatusOrderName("statusDesc2");
        FabStatusOrderDao statusOrderDao=(FabStatusOrderDao) FabBeansLocator.getDaoClass(FabBeansLocator.STATUS_ORDER_DAO);
        statusOrderDao.persist(fso);
        
        
        FabTypeCharging ftc = new FabTypeCharging();
        ftc.setTypeChargingName("charName2");
        ftc.setTypeChargindDesc("charDesc2");
        FabTypeChargingDao ftcjc = (FabTypeChargingDao)FabBeansLocator.getDaoClass(FabBeansLocator.TYPE_CHARGING_DAO);
        ftcjc.persist(ftc);
                
                
        FabService fs = new FabService();
        fs.setServiceName("service2");
        fs.setServiceDesc("service2");
        ftc.getFabService().add(fs);
        fs.setFabTypeCharging(ftc);
        fs.setServiceID(fs.getServiceName().toUpperCase());
        FabServiceDao fsjc = (FabServiceDao) FabBeansLocator.getDaoClass(FabBeansLocator.SERVICE_DAO);
        fsjc.persist(fs);
        
        
        FabCustomer fc = new FabCustomer();
        fc.setAccountID("account2");
        fc.setAdminEmail("email2");
        fc.setCustomerAddress("jalan2");
        fc.setCustomerID("id2");
        fc.setCustomerName("name2");
        fc.setPassword("pass2");
        fc.setSpeedyNum("num2");
        fc.setUserName("user2");
        fs.getFabCustomer().add(fc);
        fc.setFabService(fs);
        FabCustomerDao fcjc = (FabCustomerDao) FabBeansLocator.getDaoClass(FabBeansLocator.CUSTOMER_DAO);
        fcjc.persist(fc);
        
        
        FabOrder fo = new FabOrder();
        fo.setTransID("id2");
        fo.setTransType("type2");
        fo.setOrderDate(new Date());
        fc.getFabOrder().add(fo);
        fo.setFabCustomer(fc);
        fs.getFabOrder().add(fo);
        fo.setFabService(fs);
        fso.getFabOrder().add(fo);
        fo.setFabStatusOrder(fso);
        FabOrderDao fojc = (FabOrderDao) FabBeansLocator.getDaoClass(FabBeansLocator.ORDER_DAO);
        fojc.persist(fo);
        
        
        FabIncident fi = new FabIncident();
        fi.setContactPerson("person2");
        fi.setIncidentDate(new Date());
        fi.setIncidentDesc("desc2");
        fi.setIncidentSolution("solution2");
        fi.setIncidentStatus(0);
        fi.setTransID(fo.getTransID());
        fs.getFabIncident().add(fi);
        fi.setFabService(fs);
        fc.getFabIncident().add(fi);
        fi.setFabCustomer(fc);
        FabIncidentDao fijc = (FabIncidentDao) FabBeansLocator.getDaoClass(FabBeansLocator.INCIDENT_DAO);
        fijc.persist(fi);
        
        
        FabLogin fl = new FabLogin();
        fl.setIsExpired(true);
        fl.setSessionID("session2");
        fc.getFabLogin().add(fl);
        fl.setFabCustomer(fc);
        fs.getFabLogin().add(fl);
        fl.setFabService(fs);
        FabLoginDao fljc = (FabLoginDao) FabBeansLocator.getDaoClass(FabBeansLocator.LOGIN_DAO);
        fljc.persist(fl);
                
        
        FabModule fm = new FabModule();
        fm.setModuleName("moduleName2");
        fm.setModuleDesc("moduleDesc2");
        fs.getFabModule().add(fm);
        fm.setFabService(fs);
        FabModuleDao fmjc =(FabModuleDao) FabBeansLocator.getDaoClass(FabBeansLocator.MODULE_DAO);
        fmjc.persist(fm);
        
        
        FabModuleStatus fms = new FabModuleStatus();
        fms.setStatus(2);
        fc.getFabModuleStatus().add(fms);
        fms.setFabCustomer(fc);
        fm.getFabModuleStatus().add(fms);
        fms.setFabModule(fm);
        FabModuleStatusDao fmsjc = (FabModuleStatusDao) FabBeansLocator.getDaoClass(FabBeansLocator.MODULE_STATUS_DAO);
        fmsjc.persist(fms);
                       
        
        FabOrderModule fom = new FabOrderModule();
        fo.getFabOrderModule().add(fom);
        fom.setFabOrder(fo);
        fm.getFabOrderModule().add(fom);
        fom.setFabModule(fm);
        FabOrderModuleDao fomjc =(FabOrderModuleDao) FabBeansLocator.getDaoClass(FabBeansLocator.ORDER_MODULE_DAO);
        fomjc.persist(fom);
        
        
        FabPackage fp = new FabPackage();
        fp.setPackageName("packageName2");
        fp.setPackageDesc("packageDesc2");
        fs.getFabPackage().add(fp);
        fp.setFabService(fs);
        ftc.getFabPackage().add(fp);
        fp.setFabTypeCharging(ftc);
        FabPackageDao fpjc = (FabPackageDao) FabBeansLocator.getDaoClass(FabBeansLocator.PACKAGE_DAO);
        fpjc.persist(fp);
        
        
        FabServiceStatus fss = new FabServiceStatus();
        fss.setDatabase("DB2");
        fss.setLimit2(2);
        fss.setLimit2(2);
        fss.setLimit3(3);
        fss.setStatus(2);
        fss.setTransID(fo.getTransID());
        fss.setUrl("url2");
      //  fc.getFabServiceStatus().add(fss);
        fss.setFabCustomer(fc);
        fcjc.merge(fc);
       // fs.getFabServiceStatus().add(fss);
        fss.setFabService(fs);
        fsjc.merge(fs);
        FabServiceStatusDao fssjc = (FabServiceStatusDao) FabBeansLocator.getDaoClass(FabBeansLocator.SERVICE_STATUS_DAO);
        fssjc.persist(fss);
        
        
        FabServiceUsed fsu = new FabServiceUsed();
        fsu.setBillStatus(2);
        fsu.setDiscountAmount(0.2);
        fsu.setIsExceed(true);
        fsu.setPaymentAmount(20);
        fsu.setPaymentDate(new Date());
        fsu.setPaymentDiscount(0.2);
        fsu.setPaymentPeriod("period2");
        fsu.setRevCode("revCode2");
        fsu.setServiceAmount(20);
        fsu.setServiceCount(20);
        fsu.setServiceEnd(new Date());
        fsu.setServiceStart(new Date());
        fsu.setTransAmount(20);
        fsu.setTransDate(new Date());
        fc.getFabServiceUsed().add(fsu);
        fsu.setFabCustomer(fc);
        fs.getFabServiceUsed().add(fsu);
        fsu.setFabService(fs);
        FabServiceUsedDao fsujc = (FabServiceUsedDao) FabBeansLocator.getDaoClass(FabBeansLocator.SERVICE_USED_DAO);
        fsujc.persist(fsu);
        
        
        FabTariff ft = new FabTariff();
        ft.setInitiationFee(2000);
        ft.setIsToBeBilled(true);
        ft.setPeriodUnit("period2");
        ft.setPeriods(20);
        ft.setQuantity(20);
        ft.setReccuringFee(2000);
        ft.setSalesEnd(new Date());
        ft.setSalesStart(new Date());
        ft.setServiceUnit("su2");
        ft.setTerminationFee(200);
        fs.getFabTariff().add(ft);
        ft.setFabService(fs);
        fm.getFabTariff().add(ft);
        ft.setFabModule(fm);
        FabTariffDao ftjc = (FabTariffDao) FabBeansLocator.getDaoClass(FabBeansLocator.TARIFF_DAO);
        ftjc.persist(ft);
       **/
                        
	}

}
