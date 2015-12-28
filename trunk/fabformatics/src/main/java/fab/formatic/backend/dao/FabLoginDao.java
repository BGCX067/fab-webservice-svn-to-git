package fab.formatic.backend.dao;

import fab.formatic.backend.domain.FabLogin;

/**
 * @author gilang
 *
 */
public interface FabLoginDao extends FabDao<FabLogin, Integer>{
	
	FabLogin findByAdminEmail(String adminEmail);

}
