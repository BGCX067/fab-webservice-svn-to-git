package fab.formatic.backend.maintest;

import java.util.Date;

import fab.formatic.backend.dao.FabCustomerDao;
import fab.formatic.backend.dao.FabModuleDao;
import fab.formatic.backend.dao.FabPackageDao;
import fab.formatic.backend.dao.FabServiceDao;
import fab.formatic.backend.dao.FabTariffDao;
import fab.formatic.backend.domain.FabCustomer;
import fab.formatic.backend.domain.FabModule;
import fab.formatic.backend.domain.FabPackage;
import fab.formatic.backend.domain.FabService;
import fab.formatic.backend.domain.FabTariff;
import fab.formatic.backend.util.FabBackendHelper;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		FabServiceDao serviceDao = (FabServiceDao)FabBackendHelper.getFabDAOBeans(FabBackendHelper.SERVICE_DAO);
		FabPackageDao packageDao = (FabPackageDao) FabBackendHelper.getFabDAOBeans(FabBackendHelper.PACKAGE_DAO);
		FabModuleDao moduleDao = (FabModuleDao) FabBackendHelper.getFabDAOBeans(FabBackendHelper.MODULE_DAO);
		FabTariffDao tariffDao = (FabTariffDao) FabBackendHelper.getFabDAOBeans(FabBackendHelper.TARIFF_DAO);
		FabCustomerDao customerDao = (FabCustomerDao) FabBackendHelper.getFabDAOBeans(FabBackendHelper.CUSTOMER_DAO);
		
		FabService fs = new FabService();
		fs.setServiceName("service1");
		fs.setServiceDesc("serviceDesc1");
		fs.setServiceType("serviceType1");
		fs.setServiceID(fs.getServiceName().toUpperCase());
		serviceDao.persist(fs);
		
		FabPackage fp = new FabPackage();
		fp.setPackageName("packageName1");
		fp.setPackageDesc("packageDesc1");
		fs.getFabPackages().add(fp);
		fp.setFabService(fs);		
		packageDao.persist(fp);
		
		FabModule fm = new FabModule();
		fm.setModuleName("moduleName1");
		fm.setModuleDesc("moduleDesc1");		
		fp.getFabModules().add(fm);
		fm.getFabPackages().add(fp);		
		moduleDao.persist(fm);
		
		FabTariff ft = new FabTariff();
		ft.setInitiationFee(100);
		ft.setReccuringFee(100);
		ft.setTerminationFee(100);
		ft.setSalesStart(new Date());
		ft.setSalesEnd(new Date());
		ft.setPeriods(10);
		ft.setQuantity(0);
		ft.setServiceUnit("su1");
		ft.setPeriodUnit(10);			
		fm.getFabTariffs().add(ft);
		ft.setFabModule(fm);
		fp.getFabTariffs().add(ft);
		ft.setFabPackage(fp);
		fs.getFabTariffs().add(ft);
		ft.setFabService(fs);		
		tariffDao.persist(ft);
		
		FabCustomer fc = new FabCustomer();
		fc.setAccountID("account1");
		fc.setAdminEmail("admin@email1.com");
		fc.setCustomerAddress("jalan1");
		fc.setCustomerID("customerID1");
		fc.setCustomerName("customerName1");
		fc.setPassword("password1");
		fc.setUserName("userName1");
		fc.setSpeedyNum("speedyNum1");		
		customerDao.persist(fc);							
	}

}
