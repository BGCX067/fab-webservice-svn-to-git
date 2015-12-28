package fab.formatic.backend.dao;

import fab.formatic.backend.domain.FabLogin;

public interface FabLoginDao extends BaseDao<FabLogin, Integer> {
	
	FabLogin findLoginBySession(String sessionID);

}
