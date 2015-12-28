package fab.formatic.backend.dao;

import org.springframework.dao.DataAccessException;

import fab.formatic.backend.domain.FabUrl;

public interface FabUrlDao extends FabDao<FabUrl, Integer>{
	
	FabUrl findByUrlID (String urlID) throws DataAccessException;

}
