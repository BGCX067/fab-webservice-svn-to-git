package fab.formatic.backend.dao.impl;

import org.springframework.stereotype.Repository;

import fab.formatic.backend.dao.FabBaseDao;
import fab.formatic.backend.dao.FabStatusOrderDao;
import fab.formatic.backend.domain.FabStatusOrder;
import fab.formatic.backend.util.FabBeansLocator;

@Repository(FabBeansLocator.STATUS_ORDER_DAO)
public class FabStatusOrderDaoImpl extends FabBaseDao<FabStatusOrder, Integer> implements
		FabStatusOrderDao {

	public FabStatusOrderDaoImpl() {
		super();
	}

}
