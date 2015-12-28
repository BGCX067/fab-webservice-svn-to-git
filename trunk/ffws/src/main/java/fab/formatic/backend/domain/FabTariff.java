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
public class FabTariff implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    private int initiationFee;
    
    private int reccuringFee;
    
    private int terminationFee;
    
    private int periods;
    
    @Column(length=10)
    private String periodUnit;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date salesStart;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date salesEnd;
    
    private int quantity;
    
    @Column(length=10)
    private String serviceUnit;
    
    private boolean isToBeBilled;
    
    @ManyToOne
    private FabService fabService;
    
    @ManyToOne
    private FabModule fabModule;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public FabModule getFabModule() {
        return fabModule;
    }

    public void setFabModule(FabModule fabModule) {
        this.fabModule = fabModule;
    }

    public FabService getFabService() {
        return fabService;
    }

    public void setFabService(FabService fabService) {
        this.fabService = fabService;
    }

    public int getInitiationFee() {
        return initiationFee;
    }

    public void setInitiationFee(int initiationFee) {
        this.initiationFee = initiationFee;
    }

    public boolean isIsToBeBilled() {
        return isToBeBilled;
    }

    public void setIsToBeBilled(boolean isToBeBilled) {
        this.isToBeBilled = isToBeBilled;
    }

    public String getPeriodUnit() {
        return periodUnit;
    }

    public void setPeriodUnit(String periodUnit) {
        this.periodUnit = periodUnit;
    }

    public int getPeriods() {
        return periods;
    }

    public void setPeriods(int periods) {
        this.periods = periods;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getReccuringFee() {
        return reccuringFee;
    }

    public void setReccuringFee(int reccuringFee) {
        this.reccuringFee = reccuringFee;
    }

    public Date getSalesEnd() {
        return salesEnd;
    }

    public void setSalesEnd(Date salesEnd) {
        this.salesEnd = salesEnd;
    }

    public Date getSalesStart() {
        return salesStart;
    }

    public void setSalesStart(Date salesStart) {
        this.salesStart = salesStart;
    }

    public String getServiceUnit() {
        return serviceUnit;
    }

    public void setServiceUnit(String serviceUnit) {
        this.serviceUnit = serviceUnit;
    }

    public int getTerminationFee() {
        return terminationFee;
    }

    public void setTerminationFee(int terminationFee) {
        this.terminationFee = terminationFee;
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
        if (!(object instanceof FabTariff)) {
            return false;
        }
        FabTariff other = (FabTariff) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fab.formatic.backend.domain.FabTariff[ id=" + id + " ]";
    }
    
}
