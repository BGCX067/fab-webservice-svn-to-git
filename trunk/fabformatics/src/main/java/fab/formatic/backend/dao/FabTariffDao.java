package fab.formatic.backend.dao;

import java.util.List;

import fab.formatic.backend.domain.FabModule;
import fab.formatic.backend.domain.FabPackage;
import fab.formatic.backend.domain.FabService;
import fab.formatic.backend.domain.FabTariff;

/**
 * @author gilang
 *
 */
public interface FabTariffDao extends FabDao<FabTariff, Integer>{

	List<FabTariff> findByFabService(FabService service);
	List<FabTariff> findByFabPackage(FabPackage pack);
	List<FabTariff> findByFabModule(FabModule module);
}
