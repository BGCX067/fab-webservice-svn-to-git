package fab.formatic.backend.dao.impl;

import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import fab.formatic.backend.dao.FabBaseDao;
import fab.formatic.backend.dao.FabComplaintDao;
import fab.formatic.backend.domain.FabComplaint;
import fab.formatic.backend.domain.FabCustomer;
import fab.formatic.backend.util.FabBackendHelper;

@Repository(FabBackendHelper.COMPLAINT_DAO)
public class FabComplaintDaoImpl extends FabBaseDao<FabComplaint, Integer> implements FabComplaintDao{

	
	public FabComplaintDaoImpl(){
		super();
	}
	
	public FabComplaint findByFabCustomer(FabCustomer customer)
			throws DataAccessException {
		Query q=entityManager.createQuery("select c from FabComplaint c where c.fabCustomer=:fabCustomer");
		q.setParameter("fabCustomer", customer);
		return (FabComplaint) q.getSingleResult();
		
	}

}
