/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Puradidjaja
 */
@Entity
public class FabIncident implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(length=5000)
    private String incidentDesc;
    
    @Column(length=500)
    private String contactPerson;
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date incidentDate;
    
    @Column(length=6)
    private int incidentStatus;
    
    @Column(length=5000)
    private String incidentSolution;
   
    @ManyToOne(optional=true)
    private FabOrder fabOrder;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public Date getIncidentDate() {
        return incidentDate;
    }

    public void setIncidentDate(Date incidentDate) {
        this.incidentDate = incidentDate;
    }

    public String getIncidentDesc() {
        return incidentDesc;
    }

    public void setIncidentDesc(String incidentDesc) {
        this.incidentDesc = incidentDesc;
    }

    public String getIncidentSolution() {
        return incidentSolution;
    }

    public void setIncidentSolution(String incidentSolution) {
        this.incidentSolution = incidentSolution;
    }

    public int getIncidentStatus() {
        return incidentStatus;
    }

    public void setIncidentStatus(int incidentStatus) {
        this.incidentStatus = incidentStatus;
    }
    
    public FabOrder getFabOrder() {
		return fabOrder;
	}

	public void setFabOrder(FabOrder fabOrder) {
		this.fabOrder = fabOrder;
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
        if (!(object instanceof FabIncident)) {
            return false;
        }
        FabIncident other = (FabIncident) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fab.formatic.backend.domain.FabIncident[ id=" + id + " ]";
    }
    
}
