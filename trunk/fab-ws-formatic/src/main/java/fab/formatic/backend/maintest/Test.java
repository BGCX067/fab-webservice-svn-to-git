package fab.formatic.backend.maintest;

import fab.formatic.backend.dao.FabHostDao;
import fab.formatic.backend.dao.FabPackageDao;
import fab.formatic.backend.dao.FabPromoDao;
import fab.formatic.backend.dao.FabUrlDao;
import fab.formatic.backend.domain.FabHost;
import fab.formatic.backend.domain.FabPackage;
import fab.formatic.backend.domain.FabPromo;
import fab.formatic.backend.domain.FabUrl;
import fab.formatic.backend.util.FabBackendHelper;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		FabHostDao hostDao = (FabHostDao) FabBackendHelper.getFabDAOBeans(FabBackendHelper.HOST_DAO);
		FabPackageDao packageDao = (FabPackageDao) FabBackendHelper.getFabDAOBeans(FabBackendHelper.PACKAGE_DAO);
		FabPromoDao promoDao = (FabPromoDao) FabBackendHelper.getFabDAOBeans(FabBackendHelper.PROMO_DAO);
		FabUrlDao urlDao = (FabUrlDao) FabBackendHelper.getFabDAOBeans(FabBackendHelper.URL_DAO);
		
		FabHost fh = new FabHost();
		fh.setHostName("hostName1");
		fh.setHostID(fh.getHostName().toUpperCase());
		fh.setHostDesc("hostDesc1");
		hostDao.persist(fh);
		
		FabPromo fp = new FabPromo();
		fp.setPromoName("promoName1");
		fp.setPromoID(fp.getPromoName().toUpperCase());
		fp.setPromoDesc("promoDesc1");
		promoDao.persist(fp);
		
		FabPackage pa = new FabPackage();
		pa.setPackageName("packageName1");
		pa.setPackageID(pa.getPackageName().toUpperCase());
		pa.setPackageDesc("packageDesc1");
		pa.setFabHost(fh);
		pa.setFabPromo(fp);
		packageDao.persist(pa);
		
		FabUrl fu = new FabUrl();
		fu.setUrlName("urlName1");
		fu.setUrlID(fu.getUrlName().toUpperCase());
		urlDao.persist(fu);
		
	}

}
