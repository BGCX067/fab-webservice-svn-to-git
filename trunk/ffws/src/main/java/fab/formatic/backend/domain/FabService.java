/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fab.formatic.backend.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Hokcay
 */
@Entity
public class FabService implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length=30)
    private String serviceName;

    private String serviceID ;

    @Column(length=500)
    private String serviceDesc;

    @ManyToOne
    private FabTypeCharging fabTypeCharging;

    @OneToMany(mappedBy="fabService", cascade=CascadeType.ALL)
    private List<FabCustomer> fabCustomer = new ArrayList<FabCustomer>();

    @OneToMany(mappedBy="fabService", cascade=CascadeType.ALL)
    private List<FabPackage> fabPackage = new ArrayList<FabPackage>();

    @OneToMany(mappedBy="fabService", cascade=CascadeType.ALL)
    private List<FabServiceUsed> fabServiceUsed = new ArrayList<FabServiceUsed>();

    @OneToMany(mappedBy="fabService", cascade=CascadeType.ALL)
    private List<FabLogin> fabLogin = new ArrayList<FabLogin>();
    
    @OneToMany(mappedBy="fabService", cascade=CascadeType.ALL)
    private List<FabModule> fabModule = new ArrayList<FabModule>();
    
    @OneToMany(mappedBy="fabService", cascade=CascadeType.ALL)
    private List<FabIncident> fabIncident = new ArrayList<FabIncident>();
    
    @OneToMany(mappedBy="fabService", cascade=CascadeType.ALL)
    private List<FabTariff> fabTariff = new ArrayList<FabTariff>();
    
    @OneToMany(mappedBy="fabService", cascade=CascadeType.ALL)
    private List<FabOrder> fabOrder = new ArrayList<FabOrder>();

    @OneToMany(mappedBy="fabService", cascade=CascadeType.ALL)
    private List<FabServiceStatus> fabServiceStatus = new ArrayList<FabServiceStatus>();
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<FabCustomer> getFabCustomer() {
        return fabCustomer;
    }

    public void setFabCustomer(List<FabCustomer> fabCustomer) {
        this.fabCustomer = fabCustomer;
    }

    public List<FabIncident> getFabIncident() {
        return fabIncident;
    }

    public void setFabIncident(List<FabIncident> fabIncident) {
        this.fabIncident = fabIncident;
    }

    public List<FabLogin> getFabLogin() {
        return fabLogin;
    }

    public void setFabLogin(List<FabLogin> fabLogin) {
        this.fabLogin = fabLogin;
    }

    public List<FabModule> getFabModule() {
        return fabModule;
    }

    public void setFabModule(List<FabModule> fabModule) {
        this.fabModule = fabModule;
    }

    public List<FabOrder> getFabOrder() {
        return fabOrder;
    }

    public void setFabOrder(List<FabOrder> fabOrder) {
        this.fabOrder = fabOrder;
    }

    public List<FabPackage> getFabPackage() {
        return fabPackage;
    }

    public void setFabPackage(List<FabPackage> fabPackage) {
        this.fabPackage = fabPackage;
    }

    public List<FabServiceStatus> getFabServiceStatus() {
        return fabServiceStatus;
    }

    public void setFabServiceStatus(List<FabServiceStatus> fabServiceStatus) {
        this.fabServiceStatus = fabServiceStatus;
    }

    public List<FabServiceUsed> getFabServiceUsed() {
        return fabServiceUsed;
    }

    public void setFabServiceUsed(List<FabServiceUsed> fabServiceUsed) {
        this.fabServiceUsed = fabServiceUsed;
    }

    public List<FabTariff> getFabTariff() {
        return fabTariff;
    }

    public void setFabTariff(List<FabTariff> fabTariff) {
        this.fabTariff = fabTariff;
    }

    public FabTypeCharging getFabTypeCharging() {
        return fabTypeCharging;
    }

    public void setFabTypeCharging(FabTypeCharging fabTypeCharging) {
        this.fabTypeCharging = fabTypeCharging;
    }

    public String getServiceDesc() {
        return serviceDesc;
    }

    public void setServiceDesc(String serviceDesc) {
        this.serviceDesc = serviceDesc;
    }

    public String getServiceID() {
    	if(serviceID==null){
    		serviceID=getServiceName().toUpperCase();
    	}
        return serviceID;
    }

    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FabService)) {
            return false;
        }
        FabService other = (FabService) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fab.formatic.backend.domain.FabService[id=" + id + "]";
    }

}
