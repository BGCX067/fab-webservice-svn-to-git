package fab.formatic.backend.dao;

import org.springframework.dao.DataAccessException;

import fab.formatic.backend.domain.FabHost;

public interface FabHostDao extends FabDao<FabHost, Integer>{
	FabHost findByHostID (String hostID) throws DataAccessException;
}
