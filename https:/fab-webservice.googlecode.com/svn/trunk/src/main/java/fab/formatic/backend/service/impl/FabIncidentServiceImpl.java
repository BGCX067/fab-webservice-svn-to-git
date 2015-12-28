

package fab.formatic.backend.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        fi.setAccountID(accountID);
        fi.setServiceID(serviceID);
        incidentDao.persist(fi);

        return incidentDao.find(fi.getId());
    }

    public List<FabIncident> incidentTrack(String accountID, String serviceID, String sessionID) {
        
        List<FabIncident> incidents = incidentDao.findIncidentByAccountService(accountID, serviceID);
        return incidents;
    }
}
