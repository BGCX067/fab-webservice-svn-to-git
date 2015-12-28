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
    
    @Column(length=100)
    private String customerAddress;
    
    @Column(unique=true)
    private String userName;    
    
    private String password;
    
    private String contactPerson;
    
    private String email;
    
    private String flexyNumber;
    
    private String telephoneNumber;
    
    @Column(unique=true)
    private String speedyNum;  
    
    private String billingAnchor;
    
    @OneToMany(mappedBy="fabCustomer", cascade={CascadeType.PERSIST, CascadeType.MERGE})
    private List<FabOrder> fabOrders = new ArrayList<FabOrder>();
    
    @OneToMany(mappedBy="fabCustomer", cascade={CascadeType.PERSIST, CascadeType.MERGE})
    private List<FabComplaint> fabComplaints = new ArrayList<FabComplaint>();
    
    @OneToMany(mappedBy="fabCustomer", cascade={CascadeType.PERSIST, CascadeType.MERGE})
    private List<FabUrl> fabUrls = new ArrayList<FabUrl>();
   
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

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFlexyNumber() {
		return flexyNumber;
	}

	public void setFlexyNumber(String flexyNumber) {
		this.flexyNumber = flexyNumber;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getSpeedyNum() {
		return speedyNum;
	}

	public void setSpeedyNum(String speedyNum) {
		this.speedyNum = speedyNum;
	}

	public String getBillingAnchor() {
		return billingAnchor;
	}

	public void setBillingAnchor(String billingAnchor) {
		this.billingAnchor = billingAnchor;
	}
	
	public List<FabOrder> getFabOrders() {
		return fabOrders;
	}

	public void setFabOrders(List<FabOrder> fabOrders) {
		this.fabOrders = fabOrders;
	}

	public List<FabComplaint> getFabComplaints() {
		return fabComplaints;
	}

	public void setFabComplaints(List<FabComplaint> fabComplaints) {
		this.fabComplaints = fabComplaints;
	}

	public List<FabUrl> getFabUrls() {
		return fabUrls;
	}

	public void setFabUrls(List<FabUrl> fabUrls) {
		this.fabUrls = fabUrls;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((accountID == null) ? 0 : accountID.hashCode());
		result = prime * result
				+ ((billingAnchor == null) ? 0 : billingAnchor.hashCode());
		result = prime * result
				+ ((contactPerson == null) ? 0 : contactPerson.hashCode());
		result = prime * result
				+ ((customerAddress == null) ? 0 : customerAddress.hashCode());
		result = prime * result
				+ ((customerID == null) ? 0 : customerID.hashCode());
		result = prime * result
				+ ((customerName == null) ? 0 : customerName.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((flexyNumber == null) ? 0 : flexyNumber.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result
				+ ((speedyNum == null) ? 0 : speedyNum.hashCode());
		result = prime * result
				+ ((telephoneNumber == null) ? 0 : telephoneNumber.hashCode());
		result = prime * result
				+ ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FabCustomer other = (FabCustomer) obj;
		if (accountID == null) {
			if (other.accountID != null)
				return false;
		} else if (!accountID.equals(other.accountID))
			return false;
		if (billingAnchor == null) {
			if (other.billingAnchor != null)
				return false;
		} else if (!billingAnchor.equals(other.billingAnchor))
			return false;
		if (contactPerson == null) {
			if (other.contactPerson != null)
				return false;
		} else if (!contactPerson.equals(other.contactPerson))
			return false;
		if (customerAddress == null) {
			if (other.customerAddress != null)
				return false;
		} else if (!customerAddress.equals(other.customerAddress))
			return false;
		if (customerID == null) {
			if (other.customerID != null)
				return false;
		} else if (!customerID.equals(other.customerID))
			return false;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (flexyNumber == null) {
			if (other.flexyNumber != null)
				return false;
		} else if (!flexyNumber.equals(other.flexyNumber))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (speedyNum == null) {
			if (other.speedyNum != null)
				return false;
		} else if (!speedyNum.equals(other.speedyNum))
			return false;
		if (telephoneNumber == null) {
			if (other.telephoneNumber != null)
				return false;
		} else if (!telephoneNumber.equals(other.telephoneNumber))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FabCustomer [id=" + id + ", accountID=" + accountID
				+ ", customerID=" + customerID + ", customerName="
				+ customerName + ", customerAddress=" + customerAddress
				+ ", userName=" + userName + ", password=" + password
				+ ", contactPerson=" + contactPerson + ", email=" + email
				+ ", flexyNumber=" + flexyNumber + ", telephoneNumber="
				+ telephoneNumber + ", speedyNum=" + speedyNum
				+ ", billingAnchor=" + billingAnchor + "]";
	}
    
}
