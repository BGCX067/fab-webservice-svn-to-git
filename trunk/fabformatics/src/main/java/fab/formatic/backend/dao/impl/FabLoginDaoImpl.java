package fab.formatic.backend.dao.impl;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fab.formatic.backend.dao.FabBaseDao;
import fab.formatic.backend.dao.FabLoginDao;
import fab.formatic.backend.domain.FabLogin;
import fab.formatic.backend.util.FabBackendHelper;

/**
 * @author gilang
 *
 */
@Repository(FabBackendHelper.LOGIN_DAO)
public class FabLoginDaoImpl extends FabBaseDao<FabLogin, Integer> implements FabLoginDao{
	
	public FabLoginDaoImpl(){super();}

	public FabLogin findByAdminEmail(String adminEmail) {
		Query q=entityManager.createQuery("select f from FabLogin f where f.loginEmail=?1");
		q.setParameter(1, adminEmail);
		return (FabLogin)q.getSingleResult();
	}

}
