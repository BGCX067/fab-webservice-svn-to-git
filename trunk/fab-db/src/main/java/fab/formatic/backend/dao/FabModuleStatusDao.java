/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fab.formatic.backend.dao;

import fab.formatic.backend.domain.FabCustomer;
import fab.formatic.backend.domain.FabModule;
import fab.formatic.backend.domain.FabModuleStatus;

/**
 *
 * @author SWG
 */
public interface FabModuleStatusDao extends FabDao<FabModuleStatus, Long> {
    
    FabModuleStatus findByModuleNameAndCustomerId(FabModule moduleName, FabCustomer customerId);
    
}
