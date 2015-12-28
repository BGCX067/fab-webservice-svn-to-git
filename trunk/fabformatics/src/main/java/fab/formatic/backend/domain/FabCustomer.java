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
    
    @Column(unique=true)
    private String speedyNum;
            
    @OneToMany(mappedBy="fabCustomer", cascade={CascadeType.PERSIST, CascadeType.MERGE})
    private List<FabOrder> fabOrders = new ArrayList<FabOrder>();
    
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
    
    public List<FabOrder> getFabOrders() {
		return fabOrders;
	}

	public void setFabOrders(List<FabOrder> fabOrders) {
		this.fabOrders = fabOrders;
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
