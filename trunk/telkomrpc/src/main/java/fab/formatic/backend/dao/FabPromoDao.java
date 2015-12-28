package fab.formatic.backend.dao;

import org.springframework.dao.DataAccessException;

import fab.formatic.backend.domain.FabPromo;

public interface FabPromoDao extends FabDao<FabPromo, Integer>{
	
	FabPromo findByPromoID (String promoID) throws DataAccessException;

}
