/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fab.formatic.backend.dao.impl;

import fab.formatic.backend.dao.FabBaseDao;
import fab.formatic.backend.dao.FabServiceStatusDao;
import fab.formatic.backend.domain.FabCustomer;
import fab.formatic.backend.domain.FabService;
import fab.formatic.backend.domain.FabServiceStatus;

/**
 *
 * @author SWG
 */
public class FabServiceStatusDaoImpl extends FabBaseDao<FabServiceStatus, Long> implements FabServiceStatusDao {
    
    public FabServiceStatusDaoImpl(){
        super();
    }

    @Override
    public FabServiceStatus findByServiceIDAndCustomerId(FabService serviceID, FabCustomer customerId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
