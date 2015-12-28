package fab.formatic.backend.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import fab.formatic.backend.dao.FabBaseDao;
import fab.formatic.backend.dao.FabIncidentDao;
import fab.formatic.backend.domain.FabIncident;
import fab.formatic.backend.util.FabBackendHelper;

/**
 * @author gilang
 *
 */
@Repository(FabBackendHelper.INCIDENT_DAO)
public class FabIncidentDaoImpl extends FabBaseDao<FabIncident, Integer> implements FabIncidentDao {

	public FabIncidentDaoImpl() {
		super();
	}

	@SuppressWarnings("unchecked")
	public List<FabIncident> findIncidentFromOrder(String transID) throws DataAccessException{
		Query q=entityManager.createQuery("select i from FabIncident i where i.fabOrder.transID=:transID");
		q.setParameter("transID", transID);
		return q.getResultList();
	}

	public List<FabIncident> findIncidentByAccountServiceTrans(
			String accountID, String serviceID, String transID) throws DataAccessException{
		// TODO Auto-generated method stub
		return null;
	}

	

}
