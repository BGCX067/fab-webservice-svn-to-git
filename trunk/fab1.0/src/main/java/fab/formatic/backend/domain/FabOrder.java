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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.UniqueConstraint;

import fab.formatic.backend.domain.enumerate.FabTransactionType;


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
    
    @Column(unique=true)
    private String transID;
    
    @Enumerated(EnumType.STRING)
    private FabTransactionType transType=FabTransactionType.UNKNOWN;
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date transDate;
    
    @Column(length=20)
    private String transStatus;
    
    @Column(length=100)
    private String transDesc;
    
    @OneToMany(mappedBy="fabOrder", cascade={CascadeType.PERSIST, CascadeType.MERGE})
    private List<FabIncident> fabIncidents = new ArrayList<FabIncident>();    
   
    @OneToOne(mappedBy="fabOrder", cascade={CascadeType.PERSIST, CascadeType.MERGE})
    private FabServiceUsed fabServiceUsed;
    
    @ManyToOne(optional=true)
    private FabCustomer fabCustomer;
    
    @ManyToOne(optional=true)
    private FabService fabService;        
 

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTransDate() {
        return transDate;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    public String getTransDesc() {
        return transDesc;
    }

    public void setTransDesc(String transDesc) {
        this.transDesc = transDesc;
    }

    public String getTransID() {
        return transID;
    }

    public void setTransID(String transID) {
        this.transID = transID;
    }

    public String getTransStatus() {
        return transStatus;
    }

    public void setTransStatus(String transStatus) {
        this.transStatus = transStatus;
    }

    public FabTransactionType getTransType() {
		return transType;
	}

	public void setTransType(FabTransactionType transType) {
		this.transType = transType;
	}

	public FabCustomer getFabCustomer() {
        return fabCustomer;
    }

    public void setFabCustomer(FabCustomer fabCustomer) {
        this.fabCustomer = fabCustomer;
    }

    public List<FabIncident> getFabIncidents() {
        return fabIncidents;
    }

    public void setFabIncidents(List<FabIncident> fabIncidents) {
        this.fabIncidents = fabIncidents;
    }


    public FabService getFabService() {
        return fabService;
    }

    public void setFabService(FabService fabService) {
        this.fabService = fabService;
    }

    public FabServiceUsed getFabServiceUsed() {
        return fabServiceUsed;
    }

    public void setFabServiceUsed(FabServiceUsed fabServiceUsed) {
        this.fabServiceUsed = fabServiceUsed;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FabOrder other = (FabOrder) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if ((this.transID == null) ? (other.transID != null) : !this.transID.equals(other.transID)) {
            return false;
        }
        if ((this.transType == null) ? (other.transType != null) : !this.transType.equals(other.transType)) {
            return false;
        }
        if (this.transDate != other.transDate && (this.transDate == null || !this.transDate.equals(other.transDate))) {
            return false;
        }
        if ((this.transStatus == null) ? (other.transStatus != null) : !this.transStatus.equals(other.transStatus)) {
            return false;
        }
        if ((this.transDesc == null) ? (other.transDesc != null) : !this.transDesc.equals(other.transDesc)) {
            return false;
        }
        if (this.fabIncidents != other.fabIncidents && (this.fabIncidents == null || !this.fabIncidents.equals(other.fabIncidents))) {
            return false;
        }
        if (this.fabServiceUsed != other.fabServiceUsed && (this.fabServiceUsed == null || !this.fabServiceUsed.equals(other.fabServiceUsed))) {
            return false;
        }
        if (this.fabCustomer != other.fabCustomer && (this.fabCustomer == null || !this.fabCustomer.equals(other.fabCustomer))) {
            return false;
        }
        if (this.fabService != other.fabService && (this.fabService == null || !this.fabService.equals(other.fabService))) {
            return false;
        }
       
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 89 * hash + (this.transID != null ? this.transID.hashCode() : 0);
        hash = 89 * hash + (this.transType != null ? this.transType.hashCode() : 0);
        hash = 89 * hash + (this.transDate != null ? this.transDate.hashCode() : 0);
        hash = 89 * hash + (this.transStatus != null ? this.transStatus.hashCode() : 0);
        hash = 89 * hash + (this.transDesc != null ? this.transDesc.hashCode() : 0);
        hash = 89 * hash + (this.fabIncidents != null ? this.fabIncidents.hashCode() : 0);
        hash = 89 * hash + (this.fabServiceUsed != null ? this.fabServiceUsed.hashCode() : 0);
        hash = 89 * hash + (this.fabCustomer != null ? this.fabCustomer.hashCode() : 0);
        hash = 89 * hash + (this.fabService != null ? this.fabService.hashCode() : 0);
   
        return hash;
    }

    @Override
    public String toString() {
        return "FabOrder{" + "id=" + id + ", transID=" + transID + ", transType=" + transType + ", transDate=" + transDate + ", transStatus=" + transStatus + ", transDesc=" + transDesc + ", fabIncidents=" + fabIncidents + ", fabServiceUsed=" + fabServiceUsed + ", fabCustomer=" + fabCustomer + ", fabService=" + fabService + ", fabModules=" + '}';
    }       	
}

	
