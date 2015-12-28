package fab.formatic.backend.dao;

import java.util.Date;
import java.util.List;

import fab.formatic.backend.domain.FabTariff;

public interface FabTariffDao extends BaseDao<FabTariff, Integer> {
	
	List<FabTariff> findByDate(Date date);
	
	List<FabTariff> findByPeriod(String period);

}
