package fab.formatic.backend.dao;

import org.springframework.dao.DataAccessException;

import fab.formatic.backend.domain.FabComplaint;
import fab.formatic.backend.domain.FabCustomer;

public interface FabComplaintDao extends FabDao<FabComplaint, Integer>{
	
	FabComplaint findByFabCustomer(FabCustomer customer) throws DataAccessException;
}
