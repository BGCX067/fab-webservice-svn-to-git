package fab.formatic.backend.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class FabOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String transID;
    
    private String transType;
    
    @Column(length=500)
    private String transDesc;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date transDate;
    
    private String transStatus;
    
    @OneToMany(mappedBy="fabOrder", cascade={CascadeType.PERSIST, CascadeType.MERGE})
    private List<FabComplaint> fabComplaints = new ArrayList<FabComplaint>();
    
    @ManyToOne(optional=true)
    private FabCustomer fabCustomer;
    
    @ManyToOne(optional=true)
    private FabPackage fabPackage;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTransID() {
		return transID;
	}

	public void setTransID(String transID) {
		this.transID = transID;
	}

	public String getTransType() {
		return transType;
	}

	public void setTransType(String transType) {
		this.transType = transType;
	}

	public String getTransDesc() {
		return transDesc;
	}

	public void setTransDesc(String transDesc) {
		this.transDesc = transDesc;
	}

	public Date getTransDate() {
		return transDate;
	}

	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}

	public String getTransStatus() {
		return transStatus;
	}

	public void setTransStatus(String transStatus) {
		this.transStatus = transStatus;
	}

	public FabCustomer getFabCustomer() {
		return fabCustomer;
	}

	public void setFabCustomer(FabCustomer fabCustomer) {
		this.fabCustomer = fabCustomer;
	}

	public FabPackage getFabPackage() {
		return fabPackage;
	}

	public void setFabPackage(FabPackage fabPackage) {
		this.fabPackage = fabPackage;
	}
	
	public List<FabComplaint> getFabComplaints() {
		return fabComplaints;
	}

	public void setFabComplaints(List<FabComplaint> fabComplaints) {
		this.fabComplaints = fabComplaints;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((transDate == null) ? 0 : transDate.hashCode());
		result = prime * result
				+ ((transDesc == null) ? 0 : transDesc.hashCode());
		result = prime * result + ((transID == null) ? 0 : transID.hashCode());
		result = prime * result
				+ ((transStatus == null) ? 0 : transStatus.hashCode());
		result = prime * result
				+ ((transType == null) ? 0 : transType.hashCode());
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
		FabOrder other = (FabOrder) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (transDate == null) {
			if (other.transDate != null)
				return false;
		} else if (!transDate.equals(other.transDate))
			return false;
		if (transDesc == null) {
			if (other.transDesc != null)
				return false;
		} else if (!transDesc.equals(other.transDesc))
			return false;
		if (transID == null) {
			if (other.transID != null)
				return false;
		} else if (!transID.equals(other.transID))
			return false;
		if (transStatus == null) {
			if (other.transStatus != null)
				return false;
		} else if (!transStatus.equals(other.transStatus))
			return false;
		if (transType == null) {
			if (other.transType != null)
				return false;
		} else if (!transType.equals(other.transType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FabOrder [id=" + id + ", transID=" + transID + ", transType="
				+ transType + ", transDesc=" + transDesc + ", transDate="
				+ transDate + ", transStatus=" + transStatus + "]";
	}	    
}
