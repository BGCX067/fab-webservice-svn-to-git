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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Hokcay
 */
@Entity
@Table(uniqueConstraints={
		@UniqueConstraint(columnNames="accountID"),
		@UniqueConstraint(columnNames="customerID"),
		@UniqueConstraint(columnNames="userName"),
		@UniqueConstraint(columnNames="adminEmail"),
		@UniqueConstraint(columnNames="speedyNum")
})
public class FabCustomer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique=true)
    private String accountID;
    
    @Column(unique=true)
    private String customerID;
    
    private String customerName;
    
    private String customerAddress;
    
    @Column(unique=true)
    private String userName;
    
    @Column(unique=true)
    private String adminEmail;
    
    private String password;
    
    @Column(length=32)
    private long serviceAmount=0;
    
    private int serviceCount=0;
    
    @Column(unique=true)
    private String speedyNum;
            
    @OneToMany(mappedBy="fabCustomer", cascade={CascadeType.PERSIST, CascadeType.MERGE})
    private List<FabOrder> fabOrders = new ArrayList<FabOrder>();
    
    @OneToMany(mappedBy="fabCustomer", cascade={CascadeType.PERSIST, CascadeType.MERGE})
    private List<FabLogin> fabLogins = new ArrayList<FabLogin>();

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public long getServiceAmount() {
		return serviceAmount;
	}

	public void setServiceAmount(long serviceAmount) {
		this.serviceAmount = serviceAmount;
	}

	public int getServiceCount() {
		return serviceCount;
	}

	public void setServiceCount(int serviceCount) {
		this.serviceCount = serviceCount;
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

    public List<FabLogin> getFabLogins() {
        return fabLogins;
    }

    public void setFabLogins(List<FabLogin> fabLogins) {
        this.fabLogins = fabLogins;
    }

    public List<FabOrder> getFabOrders() {
        return fabOrders;
    }

    public void setFabOrders(List<FabOrder> fabOrders) {
        this.fabOrders = fabOrders;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FabCustomer other = (FabCustomer) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if ((this.accountID == null) ? (other.accountID != null) : !this.accountID.equals(other.accountID)) {
            return false;
        }
        if ((this.customerID == null) ? (other.customerID != null) : !this.customerID.equals(other.customerID)) {
            return false;
        }
        if ((this.customerName == null) ? (other.customerName != null) : !this.customerName.equals(other.customerName)) {
            return false;
        }
        if ((this.customerAddress == null) ? (other.customerAddress != null) : !this.customerAddress.equals(other.customerAddress)) {
            return false;
        }
        if ((this.userName == null) ? (other.userName != null) : !this.userName.equals(other.userName)) {
            return false;
        }
        if ((this.adminEmail == null) ? (other.adminEmail != null) : !this.adminEmail.equals(other.adminEmail)) {
            return false;
        }
        if ((this.password == null) ? (other.password != null) : !this.password.equals(other.password)) {
            return false;
        }
        if (this.serviceAmount != other.serviceAmount) {
            return false;
        }
        if (Double.doubleToLongBits(this.serviceCount) != Double.doubleToLongBits(other.serviceCount)) {
            return false;
        }
        if ((this.speedyNum == null) ? (other.speedyNum != null) : !this.speedyNum.equals(other.speedyNum)) {
            return false;
        }
        if (this.fabOrders != other.fabOrders && (this.fabOrders == null || !this.fabOrders.equals(other.fabOrders))) {
            return false;
        }
        if (this.fabLogins != other.fabLogins && (this.fabLogins == null || !this.fabLogins.equals(other.fabLogins))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 47 * hash + (this.accountID != null ? this.accountID.hashCode() : 0);
        hash = 47 * hash + (this.customerID != null ? this.customerID.hashCode() : 0);
        hash = 47 * hash + (this.customerName != null ? this.customerName.hashCode() : 0);
        hash = 47 * hash + (this.customerAddress != null ? this.customerAddress.hashCode() : 0);
        hash = 47 * hash + (this.userName != null ? this.userName.hashCode() : 0);
        hash = 47 * hash + (this.adminEmail != null ? this.adminEmail.hashCode() : 0);
        hash = 47 * hash + (this.password != null ? this.password.hashCode() : 0);
        hash = (int) (47 * hash + this.serviceAmount);
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.serviceCount) ^ (Double.doubleToLongBits(this.serviceCount) >>> 32));
        hash = 47 * hash + (this.speedyNum != null ? this.speedyNum.hashCode() : 0);
        hash = 47 * hash + (this.fabOrders != null ? this.fabOrders.hashCode() : 0);
        hash = 47 * hash + (this.fabLogins != null ? this.fabLogins.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "FabCustomer{" + "id=" + id + ", accountID=" + accountID + ", customerID=" + customerID + ", customerName=" + customerName + ", customerAddress=" + customerAddress + ", userName=" + userName + ", adminEmail=" + adminEmail + ", password=" + password + ", serviceAmount=" + serviceAmount + ", serviceCount=" + serviceCount + ", speedyNum=" + speedyNum + ", fabOrders=" + fabOrders + ", fabLogins=" + fabLogins + '}';
    }          
}
