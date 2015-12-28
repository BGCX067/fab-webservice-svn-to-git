package fab.formatic.backend.dao.impl;

import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import fab.formatic.backend.dao.FabBaseDao;
import fab.formatic.backend.dao.FabOrderDao;
import fab.formatic.backend.domain.FabOrder;
import fab.formatic.backend.util.FabBackendHelper;

@Repository(FabBackendHelper.ORDER_DAO)
public class FabOrderDaoImpl extends FabBaseDao<FabOrder, Integer> implements FabOrderDao{

	public FabOrderDaoImpl(){
		super();
	}
	
	public FabOrder findByTransID(String transID) throws DataAccessException {
		Query q=entityManager.createQuery("select o from FabOrder o where o.transID=:transID");
		q.setParameter("transID", transID);
		return (FabOrder) q.getSingleResult();		
	}		
}
