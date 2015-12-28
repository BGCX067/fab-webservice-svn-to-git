package fab.formatic.backend.dao;

import org.springframework.dao.DataAccessException;

import fab.formatic.backend.domain.FabOrder;

public interface FabOrderDao extends FabDao<FabOrder, Integer>{

	FabOrder findByTransID (String transID) throws DataAccessException;
	
}
