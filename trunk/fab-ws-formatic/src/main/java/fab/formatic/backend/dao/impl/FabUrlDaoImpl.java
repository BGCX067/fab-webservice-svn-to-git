package fab.formatic.backend.dao.impl;

import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import fab.formatic.backend.dao.FabBaseDao;
import fab.formatic.backend.dao.FabUrlDao;
import fab.formatic.backend.domain.FabUrl;
import fab.formatic.backend.util.FabBackendHelper;

@Repository(FabBackendHelper.URL_DAO)
public class FabUrlDaoImpl extends FabBaseDao<FabUrl, Integer> implements FabUrlDao{

	public FabUrlDaoImpl(){
		super();
	}
	
	public FabUrl findByUrlID(String urlID) throws DataAccessException {
		Query q=entityManager.createQuery("select u from FabUrl u where c.urlID=:urlID");
		q.setParameter("urlID", urlID);
		return (FabUrl) q.getSingleResult();
	}
	
}
