/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fab.formatic.backend.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.UniqueConstraint;

import fab.formatic.backend.util.FabTransactionType;

/**
 *
 * @author Puradidjaja
 */
@Entity
@Table(uniqueConstraints={
		@UniqueConstraint(columnNames="transID")
})
public class FabOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Enumerated(EnumType.STRING)
    private FabTransactionType transType=FabTransactionType.UNKNOWN;
    
    @Column(unique=true)
    private String transID;
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date transDate;
    
    @Column(length=20)
    private String transStatus;
    
    @Column(length=100)
    private String transDesc;
    
    @OneToMany(mappedBy="fabOrder", cascade={CascadeType.PERSIST, CascadeType.MERGE})
    private List<FabIncident> fabIncidents = new ArrayList<FabIncident>();
    
    @OneToMany(mappedBy="fabOrder", cascade={CascadeType.PERSIST, CascadeType.MERGE})
    private List<FabServiceStatus> fabServiceStatuses = new ArrayList<FabServiceStatus>();
    
    @OneToMany(mappedBy="fabOrder", cascade={CascadeType.PERSIST, CascadeType.MERGE})
    private List<FabServiceUsed> fabServiceUseds = new ArrayList<FabServiceUsed>();
    
    @ManyToOne(optional=true)
    private FabCustomer fabCustomer;
    
    @ManyToOne(optional=true)
    private FabService fabService;        
 
    @ManyToMany
    private List<FabModule> fabModules = new ArrayList<FabModule>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public FabTransactionType getTransType() {
		return transType;
	}

	public void setTransType(FabTransactionType transType) {
		this.transType = transType;
	}

	public String getTransID() {
		return transID;
	}

	public void setTransID(String transID) {
		this.transID = transID;
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

	public String getTransDesc() {
		return transDesc;
	}

	public void setTransDesc(String transDesc) {
		this.transDesc = transDesc;
	}

	public List<FabIncident> getFabIncidents() {
		return fabIncidents;
	}

	public void setFabIncidents(List<FabIncident> fabIncidents) {
		this.fabIncidents = fabIncidents;
	}

	public List<FabServiceStatus> getFabServiceStatuses() {
		return fabServiceStatuses;
	}

	public void setFabServiceStatuses(List<FabServiceStatus> fabServiceStatuses) {
		this.fabServiceStatuses = fabServiceStatuses;
	}

	public List<FabServiceUsed> getFabServiceUseds() {
		return fabServiceUseds;
	}

	public void setFabServiceUseds(List<FabServiceUsed> fabServiceUseds) {
		this.fabServiceUseds = fabServiceUseds;
	}

	public FabCustomer getFabCustomer() {
		return fabCustomer;
	}

	public void setFabCustomer(FabCustomer fabCustomer) {
		this.fabCustomer = fabCustomer;
	}

	public FabService getFabService() {
		return fabService;
	}

	public void setFabService(FabService fabService) {
		this.fabService = fabService;
	}

	public List<FabModule> getFabModules() {
		return fabModules;
	}

	public void setFabModules(List<FabModule> fabModules) {
		this.fabModules = fabModules;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((fabCustomer == null) ? 0 : fabCustomer.hashCode());
		result = prime * result
				+ ((fabIncidents == null) ? 0 : fabIncidents.hashCode());
		result = prime * result
				+ ((fabModules == null) ? 0 : fabModules.hashCode());
		result = prime * result
				+ ((fabService == null) ? 0 : fabService.hashCode());
		result = prime
				* result
				+ ((fabServiceStatuses == null) ? 0 : fabServiceStatuses
						.hashCode());
		result = prime * result
				+ ((fabServiceUseds == null) ? 0 : fabServiceUseds.hashCode());
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
		if (fabCustomer == null) {
			if (other.fabCustomer != null)
				return false;
		} else if (!fabCustomer.equals(other.fabCustomer))
			return false;
		if (fabIncidents == null) {
			if (other.fabIncidents != null)
				return false;
		} else if (!fabIncidents.equals(other.fabIncidents))
			return false;
		if (fabModules == null) {
			if (other.fabModules != null)
				return false;
		} else if (!fabModules.equals(other.fabModules))
			return false;
		if (fabService == null) {
			if (other.fabService != null)
				return false;
		} else if (!fabService.equals(other.fabService))
			return false;
		if (fabServiceStatuses == null) {
			if (other.fabServiceStatuses != null)
				return false;
		} else if (!fabServiceStatuses.equals(other.fabServiceStatuses))
			return false;
		if (fabServiceUseds == null) {
			if (other.fabServiceUseds != null)
				return false;
		} else if (!fabServiceUseds.equals(other.fabServiceUseds))
			return false;
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
		return "FabOrder [id=" + id + ", transType=" + transType + ", transID="
				+ transID + ", transDate=" + transDate + ", transStatus="
				+ transStatus + ", transDesc=" + transDesc + ", fabIncidents="
				+ fabIncidents + ", fabServiceStatuses=" + fabServiceStatuses
				+ ", fabServiceUseds=" + fabServiceUseds + ", fabCustomer="
				+ fabCustomer + ", fabService=" + fabService + ", fabModules="
				+ fabModules + "]";
	}
    
    
}
