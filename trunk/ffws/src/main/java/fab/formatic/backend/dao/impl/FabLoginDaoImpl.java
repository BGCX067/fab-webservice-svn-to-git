package fab.formatic.backend.dao.impl;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fab.formatic.backend.dao.FabBaseDao;
import fab.formatic.backend.dao.FabLoginDao;
import fab.formatic.backend.domain.FabLogin;
import fab.formatic.backend.util.FabBeansLocator;

@Repository(FabBeansLocator.LOGIN_DAO)
public class FabLoginDaoImpl extends FabBaseDao<FabLogin, Integer> implements FabLoginDao {

	public FabLoginDaoImpl() {
		super();
	}

	public FabLogin findLoginBySession(String sessionID) {
		Query q=entityManager.createQuery("select l from FabLogin l where l.sessionID=:sessionID");
		q.setParameter("sessionID", sessionID);
		return (FabLogin) q.getSingleResult();
	}
}
