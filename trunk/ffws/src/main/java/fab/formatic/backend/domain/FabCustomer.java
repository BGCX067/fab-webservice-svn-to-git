/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fab.formatic.backend.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
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
public class FabCustomer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String accountID;
    
    private String customerID;
    
    private String customerName;
    
    private String customerAddress;
    
    private String userName;
    
    private String adminEmail;
    
    private String password;
    
    private String speedyNum;
            
    @ManyToOne
    private FabService fabService;

    @OneToMany(mappedBy="fabCustomer", cascade= CascadeType.ALL)
    private List<FabServiceUsed> fabServiceUsed = new ArrayList<FabServiceUsed>();

    @OneToMany(mappedBy="fabCustomer", cascade= CascadeType.ALL)
    private List<FabLogin> fabLogin = new ArrayList<FabLogin>();
    
    @OneToMany(mappedBy="fabCustomer", cascade= CascadeType.ALL)
    private List<FabIncident> fabIncident = new ArrayList<FabIncident>();
    
    @OneToMany(mappedBy="fabCustomer", cascade= CascadeType.ALL)
    private List<FabOrder> fabOrder = new ArrayList<FabOrder>();
    
    @OneToMany(mappedBy="fabCustomer", cascade= CascadeType.ALL)
    private List<FabServiceStatus> fabServiceStatus = new ArrayList<FabServiceStatus>();
    
    @OneToMany(mappedBy="fabCustomer", cascade= CascadeType.ALL)
    private List<FabModuleStatus> fabModuleStatus = new ArrayList<FabModuleStatus>();
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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

    public List<FabModuleStatus> getFabModuleStatus() {
        return fabModuleStatus;
    }

    public void setFabModuleStatus(List<FabModuleStatus> fabModuleStatus) {
        this.fabModuleStatus = fabModuleStatus;
    }

    public List<FabOrder> getFabOrder() {
        return fabOrder;
    }

    public void setFabOrder(List<FabOrder> fabOrder) {
        this.fabOrder = fabOrder;
    }

    public FabService getFabService() {
        return fabService;
    }

    public void setFabService(FabService fabService) {
        this.fabService = fabService;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSpeedyNum() {
        return speedyNum;
    }

    public void setSpeedyNum(String speedyNum) {
        this.speedyNum = speedyNum;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
        if (!(object instanceof FabCustomer)) {
            return false;
        }
        FabCustomer other = (FabCustomer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fab.formatic.backend.domain.FabCustomer[id=" + id + "]";
    }

}
