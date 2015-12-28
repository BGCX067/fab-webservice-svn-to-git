/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fab.formatic.backend.dao;

import fab.formatic.backend.domain.FabCustomer;
import fab.formatic.backend.domain.FabService;
import fab.formatic.backend.domain.FabServiceStatus;

/**
 *
 * @author SWG
 */
public interface FabServiceStatusDao extends FabDao<FabServiceStatus, Long> {
    
    FabServiceStatus findByServiceIDAndCustomerId(FabService serviceID, FabCustomer customerId);
    
}
