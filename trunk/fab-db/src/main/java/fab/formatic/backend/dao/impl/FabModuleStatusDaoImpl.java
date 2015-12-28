/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fab.formatic.backend.dao.impl;

import fab.formatic.backend.dao.FabBaseDao;
import fab.formatic.backend.dao.FabModuleStatusDao;
import fab.formatic.backend.domain.FabCustomer;
import fab.formatic.backend.domain.FabModule;
import fab.formatic.backend.domain.FabModuleStatus;
import fab.formatic.backend.util.FabBackendHelper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author SWG
 */
@Repository(FabBackendHelper.MODULE_STATUS_DAO)
public class FabModuleStatusDaoImpl extends FabBaseDao<FabModuleStatus, Long> implements FabModuleStatusDao {

    public FabModuleStatusDaoImpl() {
    
        super();
    }

    @Override
    public FabModuleStatus findByModuleNameAndCustomerId(FabModule moduleName, FabCustomer customerId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
    
}
