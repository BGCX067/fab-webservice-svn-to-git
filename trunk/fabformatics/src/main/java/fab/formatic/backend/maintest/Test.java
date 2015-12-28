package fab.formatic.backend.maintest;

import java.util.Calendar;
import java.util.Date;

import fab.formatic.backend.dao.FabModuleDao;
import fab.formatic.backend.dao.FabPackageDao;
import fab.formatic.backend.dao.FabServiceDao;
import fab.formatic.backend.dao.FabTariffDao;
import fab.formatic.backend.domain.FabModule;
import fab.formatic.backend.domain.FabPackage;
import fab.formatic.backend.domain.FabService;
import fab.formatic.backend.domain.FabTariff;
import fab.formatic.backend.util.FabBackendHelper;





public class Test {
	
	public static void main(String[] arg)
	{	
		
		FabServiceDao serviceDao=(FabServiceDao)FabBackendHelper.getFabDAOBeans(FabBackendHelper.SERVICE_DAO);
		
		FabPackageDao packageDao=(FabPackageDao)FabBackendHelper.getFabDAOBeans(FabBackendHelper.PACKAGE_DAO);
	  
		FabModuleDao moduleDao=(FabModuleDao) FabBackendHelper.getFabDAOBeans(FabBackendHelper.MODULE_DAO);
		
		FabTariffDao tariffDao=(FabTariffDao) FabBackendHelper.getFabDAOBeans(FabBackendHelper.TARIFF_DAO);
		
		FabTariff tariff=new FabTariff();
		tariff.setInitiationFee(2000);
		tariff.setPeriods(5);
		tariff.setQuantity(2);
		tariff.setPeriodUnit("unit 1");
		Date d=new Date();
		tariff.setServiceStart(d);
		Calendar c=Calendar.getInstance();
		c.setTime(d);
		c.add(Calendar.DATE, 11);
		tariff.setServiceUnit("UNIT1");
		tariff.setServiceEnd(c.getTime());
		tariff.setTerminationFee(1200);
		tariff.setToBeBilled(false);
		tariff.setReccuringFee(200);
		
		FabService fs=serviceDao.findByServiceID("service001");
		tariff.setFabService(fs);
		
		
		tariffDao.persist(tariff);
		
		
		
	}

	
}
