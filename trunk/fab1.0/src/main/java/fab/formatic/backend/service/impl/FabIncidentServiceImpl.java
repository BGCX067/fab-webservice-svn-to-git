

package fab.formatic.backend.service.impl;

import fab.formatic.backend.dao.FabCustomerDao;
import fab.formatic.backend.dao.FabIncidentDao;
import fab.formatic.backend.dao.FabOrderDao;
import fab.formatic.backend.dao.FabServiceDao;
import fab.formatic.backend.domain.FabCustomer;
import fab.formatic.backend.domain.FabIncident;
import fab.formatic.backend.domain.FabOrder;
import fab.formatic.backend.domain.FabService;
import fab.formatic.backend.service.FabIncidentService;
import fab.formatic.backend.util.FabBackendHelper;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(FabBackendHelper.INCIDENT_SERVICE)
public class FabIncidentServiceImpl implements FabIncidentService{

    @Autowired
    private FabCustomerDao customerDao;

    @Autowired
    private FabServiceDao serviceDao;

    @Autowired
    private FabOrderDao orderDao;

    @Autowired
    private FabIncidentDao incidentDao;

    public FabIncident incidentInput(String accountID, String contactPerson, String incidentDesc, String serviceID, String sessionID, String transID) {

        FabOrder fo =  orderDao.findByTransID(transID);
        FabCustomer fc = customerDao.findByAccountID(accountID);
        FabService fs = serviceDao.findByServiceID(serviceID);

        fo.setFabCustomer(fc);
        fo.setFabService(fs);

        if(fc==null && fs==null){
            return null;
        }

        FabIncident fi = new FabIncident();
        fi.setFabOrder(fo);
        fi.setContactPerson(contactPerson);
        fi.setIncidentDesc(incidentDesc);
        fi.setIncidentDate(new Date());
        fi.setIncidentStatus(0);
        fi.setIncidentSolution("belum ada solusi");

        incidentDao.persist(fi);

        return fi;
    }

    public List<FabIncident> incidentTrack(String accountID, String serviceID, String sessionID) {
        
        List<FabIncident> incidents = new ArrayList<FabIncident>();
        FabCustomer fc = customerDao.findByAccountID(accountID);
        FabService fs = serviceDao.findByServiceID(serviceID);
        FabOrder fo = new FabOrder();
        fo.setFabCustomer(fc);
        fo.setFabService(fs);

        if(fc==null && fs==null){
            return null;
        }

        for(FabIncident fi:incidents)
        {
            fi.setFabOrder(fo);
        }
        return incidents;
    }

}
