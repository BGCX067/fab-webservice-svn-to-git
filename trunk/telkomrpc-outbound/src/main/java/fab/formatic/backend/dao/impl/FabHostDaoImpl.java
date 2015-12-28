package fab.formatic.backend.dao.impl;

import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import fab.formatic.backend.dao.FabBaseDao;
import fab.formatic.backend.dao.FabHostDao;
import fab.formatic.backend.domain.FabHost;
import fab.formatic.backend.util.FabBackendHelper;

@Repository(FabBackendHelper.HOST_DAO)
public class FabHostDaoImpl extends FabBaseDao<FabHost, Integer> implements FabHostDao{

	public FabHostDaoImpl(){
		super();
	}
	
	public FabHost findByHostID(String hostID) throws DataAccessException {
		Query q=entityManager.createQuery("select h from FabHost h where h.hostID=:hostID");
		q.setParameter("accountID", hostID);
		return (FabHost) q.getSingleResult();		
	}	
	
}
