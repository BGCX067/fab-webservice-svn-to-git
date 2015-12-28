package fab.formatic.backend.dao.impl;

import org.springframework.stereotype.Repository;

import fab.formatic.backend.dao.FabBaseDao;
import fab.formatic.backend.dao.FabTypeChargingDao;
import fab.formatic.backend.domain.FabTypeCharging;
import fab.formatic.backend.util.FabBeansLocator;

@Repository(FabBeansLocator.TYPE_CHARGING_DAO)
public class FabTypeChargingDaoImpl extends FabBaseDao<FabTypeCharging, Integer> implements
		FabTypeChargingDao {

	public FabTypeChargingDaoImpl() {
		super();
	}

}
