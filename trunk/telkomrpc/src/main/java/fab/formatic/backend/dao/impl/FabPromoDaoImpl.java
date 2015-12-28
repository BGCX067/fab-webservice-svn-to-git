package fab.formatic.backend.dao.impl;

import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import fab.formatic.backend.dao.FabBaseDao;
import fab.formatic.backend.dao.FabPromoDao;
import fab.formatic.backend.domain.FabPromo;
import fab.formatic.backend.util.FabBackendHelper;

@Repository(FabBackendHelper.PROMO_DAO)
public class FabPromoDaoImpl extends FabBaseDao<FabPromo, Integer> implements FabPromoDao{

	public FabPromoDaoImpl(){
		super();
	}
	
	public FabPromo findByPromoID(String promoID) throws DataAccessException {
		Query q=entityManager.createQuery("select p from FabPromo p where p.promoID=:promoID");
		q.setParameter("promoID", promoID);
		return (FabPromo) q.getSingleResult();
	}
	
}
