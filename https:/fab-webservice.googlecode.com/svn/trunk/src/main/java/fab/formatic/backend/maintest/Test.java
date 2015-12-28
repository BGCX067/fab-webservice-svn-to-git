package fab.formatic.backend.maintest;

import java.util.Date;

import fab.formatic.backend.dao.FabCustomerDao;
import fab.formatic.backend.dao.FabModuleDao;
import fab.formatic.backend.dao.FabPackageDao;
import fab.formatic.backend.dao.FabServiceDao;
import fab.formatic.backend.dao.FabServiceStatusDao;
import fab.formatic.backend.dao.FabTariffDao;
import fab.formatic.backend.domain.FabCustomer;
import fab.formatic.backend.domain.FabModule;
import fab.formatic.backend.domain.FabPackage;
import fab.formatic.backend.domain.FabService;
import fab.formatic.backend.domain.FabServiceStatus;
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
		FabServiceStatusDao serviceStatusDao = (FabServiceStatusDao) FabBackendHelper.getFabDAOBeans(FabBackendHelper.SERVICE_STATUS_DAO);		
		
		FabService fs = new FabService();
		fs.setServiceName("service2");
		fs.setServiceDesc("serviceDesc2");
		fs.setServiceType("serviceType2");
		fs.setServiceID(fs.getServiceName().toUpperCase());
		serviceDao.persist(fs);
		
		FabPackage fp = new FabPackage();
		fp.setPackageName("packageName2");
		fp.setPackageDesc("packageDesc2");
		fs.getFabPackages().add(fp);
		fp.setFabService(fs);		
		packageDao.persist(fp);
		
		FabModule fm = new FabModule();
		fm.setModuleName("moduleName2");
		fm.setModuleDesc("moduleDesc2");		
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
		ft.setServiceUnit("su2");
		ft.setPeriodUnit(10);			
		fm.getFabTariffs().add(ft);
		ft.setFabModule(fm);
		fp.getFabTariffs().add(ft);
		ft.setFabPackage(fp);
		fs.getFabTariffs().add(ft);
		ft.setFabService(fs);		
		tariffDao.persist(ft);
		
		FabCustomer fc = new FabCustomer();
		fc.setAccountID("account2");
		fc.setAdminEmail("admin@email2.com");
		fc.setCustomerAddress("jalan2");
		fc.setCustomerID("customerID2");
		fc.setCustomerName("customerName2");
		fc.setPassword("password2");
		fc.setUserName("userName2");
		fc.setSpeedyNum("speedyNum2");		
		customerDao.persist(fc);		
		
		FabServiceStatus fss = new FabServiceStatus();
		fss.setFabService(fs);
		fss.setLimit1(1);
		serviceStatusDao.persist(fss);
	}

}
