package fab.formatic.backend.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class FabComplaint implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length=5000)
    private String complaintDesc;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date complaintDate;
    
    private String complaintStatus;
    
    @Column(length=5000)
    private String complaintSolution;
    
    @ManyToOne(optional=true)
    private FabOrder fabOrder;
    
    @ManyToOne(optional=true)
    private FabCustomer fabCustomer;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getComplaintDesc() {
		return complaintDesc;
	}

	public void setComplaintDesc(String complaintDesc) {
		this.complaintDesc = complaintDesc;
	}

	public Date getComplaintDate() {
		return complaintDate;
	}

	public void setComplaintDate(Date complaintDate) {
		this.complaintDate = complaintDate;
	}

	public String getComplaintStatus() {
		return complaintStatus;
	}

	public void setComplaintStatus(String complaintStatus) {
		this.complaintStatus = complaintStatus;
	}

	public String getComplaintSolution() {
		return complaintSolution;
	}

	public void setComplaintSolution(String complaintSolution) {
		this.complaintSolution = complaintSolution;
	}

	public FabOrder getFabOrder() {
		return fabOrder;
	}

	public void setFabOrder(FabOrder fabOrder) {
		this.fabOrder = fabOrder;
	}

	public FabCustomer getFabCustomer() {
		return fabCustomer;
	}

	public void setFabCustomer(FabCustomer fabCustomer) {
		this.fabCustomer = fabCustomer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((complaintDate == null) ? 0 : complaintDate.hashCode());
		result = prime * result
				+ ((complaintDesc == null) ? 0 : complaintDesc.hashCode());
		result = prime
				* result
				+ ((complaintSolution == null) ? 0 : complaintSolution
						.hashCode());
		result = prime * result
				+ ((complaintStatus == null) ? 0 : complaintStatus.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		FabComplaint other = (FabComplaint) obj;
		if (complaintDate == null) {
			if (other.complaintDate != null)
				return false;
		} else if (!complaintDate.equals(other.complaintDate))
			return false;
		if (complaintDesc == null) {
			if (other.complaintDesc != null)
				return false;
		} else if (!complaintDesc.equals(other.complaintDesc))
			return false;
		if (complaintSolution == null) {
			if (other.complaintSolution != null)
				return false;
		} else if (!complaintSolution.equals(other.complaintSolution))
			return false;
		if (complaintStatus == null) {
			if (other.complaintStatus != null)
				return false;
		} else if (!complaintStatus.equals(other.complaintStatus))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FabComplaint [id=" + id + ", complaintDesc=" + complaintDesc
				+ ", complaintDate=" + complaintDate + ", complaintStatus="
				+ complaintStatus + ", complaintSolution=" + complaintSolution
				+ "]";
	}        
}
