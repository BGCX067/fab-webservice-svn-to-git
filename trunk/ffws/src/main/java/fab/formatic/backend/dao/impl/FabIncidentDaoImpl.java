package fab.formatic.backend.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fab.formatic.backend.dao.FabBaseDao;
import fab.formatic.backend.dao.FabIncidentDao;
import fab.formatic.backend.domain.FabIncident;
import fab.formatic.backend.util.FabBeansLocator;

@Repository(FabBeansLocator.INCIDENT_DAO)
public class FabIncidentDaoImpl extends FabBaseDao<FabIncident, Integer> implements FabIncidentDao{
	
	public FabIncidentDaoImpl(){
		super();
	}

	public FabIncident findByReporterId(String accountID) {
		Query q=entityManager.createQuery("select i from FabIncident i where i.fabCustomer.accountID=:accountID");
		q.setParameter("accountID",accountID);
		return (FabIncident) q.getResultList().get(0);
	}

	@SuppressWarnings("unchecked")
	public List<FabIncident> finIncidentTrack(String accountID, String serviceID) {
		Query q=entityManager.createQuery("select i from FabIncident i where i.fabCustomer.accountID=:accountID and i.fabService.serviceID=:serviceID");
		q.setParameter("accountID", accountID);
		q.setParameter("serviceID", serviceID);
		
		return q.getResultList();
	}

}
