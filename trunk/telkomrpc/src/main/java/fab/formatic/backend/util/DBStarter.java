package fab.formatic.backend.util;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fab.formatic.backend.dao.FabHostDao;
import fab.formatic.backend.dao.FabPackageDao;
import fab.formatic.backend.dao.FabPromoDao;
import fab.formatic.backend.dao.FabUrlDao;
import fab.formatic.backend.domain.FabHost;
import fab.formatic.backend.domain.FabPackage;
import fab.formatic.backend.domain.FabPromo;
import fab.formatic.backend.domain.FabUrl;

@Component("dbStarter")
public class DBStarter {
	
	private static Logger logger=Logger.getLogger(DBStarter.class);
	
	@Autowired
	private FabHostDao hostDao;
	
	@Autowired
	private FabPackageDao packageDao;
	
	@Autowired
	private FabPromoDao promoDao;
	
	@Autowired
	private FabUrlDao urlDao;
	
	@PostConstruct
	public void populateData(){
		
		FabHost fh = new FabHost();
		fh.setHostName("hostName1");
		fh.setHostID(fh.getHostName().toUpperCase());
		fh.setHostDesc("hostDesc1");
		hostDao.persist(fh);
		
		logger.info("persist object: "+fh.getHostID());
		
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
