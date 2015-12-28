package fab.formatic.backend.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fab.formatic.backend.dao.FabCustomerDao;
import fab.formatic.backend.dao.FabIncidentDao;
import fab.formatic.backend.dao.FabModuleDao;
import fab.formatic.backend.dao.FabServiceDao;
import fab.formatic.backend.domain.FabCustomer;
import fab.formatic.backend.domain.FabIncident;
import fab.formatic.backend.domain.FabLogin;
import fab.formatic.backend.domain.FabModule;
import fab.formatic.backend.domain.FabService;
import fab.formatic.web.util.FabWSConstant;

@Service(FabWSConstant.FAB_CUSTOMER_SERVICE)
public class FabCustomerServiceImpl implements FabCustomerService {

	@Autowired
	private FabCustomerDao customerDao;

	//@Autowired
	//private FabLoginDao loginDao;

	@Autowired
	private FabModuleDao moduleDao;

	@Autowired
	private FabServiceDao serviceDao;
	
	@Autowired
	private FabIncidentDao incidentDao;

	public FabLogin login(String adminEmail, String password, String serviceID) {

		FabCustomer fc = customerDao.findByAdminEmail(adminEmail);
		FabService fs = serviceDao.findByServiceId(serviceID);

		if (fs != null && fc != null) {
			FabLogin fabLogin = new FabLogin();
			fabLogin.setFabCustomer(fc);
			fabLogin.setFabService(fs);
			fabLogin.setSessionID(adminEmail + serviceID + password
					+ new Date());
			fabLogin.setIsExpired(false);
			//loginDao.persist(fabLogin);
			return fabLogin;
		} else {
			return null;
		}

	}

	public FabService getService(String serviceID) {
		FabService service=serviceDao.findByServiceId(serviceID);
		return service;
	}

	public FabModule getModule(String serviceID, String moduleID) {
		FabModule module=moduleDao.getModuleByName(moduleID);
		FabService service=serviceDao.findByServiceId(serviceID);
		
		if(service.getFabModule().contains(module))
			return module;
		else
			return null;
	}

	public FabIncident inputIncident(String accountID, String contactPerson,
			String incidentDesc, String serviceID, String sessionID,
			String transID) {
	
		if(sessionID==null || StringUtils.isEmpty(sessionID))
		{
			throw new RuntimeException("no session, try to login first");
		}
		
		FabCustomer customer=customerDao.findByAccountId(accountID);
		FabService service=serviceDao.findByServiceId(serviceID);
		if(customer!=null && service!=null){
			FabIncident fi=new FabIncident();
			fi.setFabCustomer(customer);
			fi.setFabService(service);
			fi.setIncidentDesc(incidentDesc);
			fi.setContactPerson(contactPerson);
			fi.setIncidentDate(new Date());
			fi.setIncidentStatus(0);
			fi.setTransID(transID);
			fi.setIncidentSolution(null);
			incidentDao.persist(fi);
			return fi;
		}else{
			return null;
		}
		
		
	}

	public List<FabIncident> getIncident(String accountID, String serviceID,
			String sessionID) {
		if(sessionID==null || StringUtils.isEmpty(sessionID))
		{
			throw new RuntimeException("no session, try to login first");
		}
		List<FabIncident> fabIncidents=incidentDao.finIncidentTrack(accountID, serviceID);
		if(fabIncidents!=null && fabIncidents.size()>0)
			return fabIncidents;
		else
			return null;
	}

}
