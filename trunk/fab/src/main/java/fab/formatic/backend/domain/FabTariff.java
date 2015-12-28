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
        
    private int periodUnit;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date salesStart;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date salesEnd;
    
    private int quantity;
    
    @Column(length=10)
    private String serviceUnit;
    
    private boolean isToBeBilled;
    
    @ManyToOne(optional=true)
    private FabService fabService;
    
    @ManyToOne(optional=true)
    private FabModule fabModule;
    
    @ManyToOne(optional=true)
    private FabPackage fabPackage;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public int getPeriodUnit() {
        return periodUnit;
    }

    public void setPeriodUnit(int periodUnit) {
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

    public FabModule getFabModule() {
        return fabModule;
    }

    public void setFabModule(FabModule fabModule) {
        this.fabModule = fabModule;
    }

    public FabPackage getFabPackage() {
        return fabPackage;
    }

    public void setFabPackage(FabPackage fabPackage) {
        this.fabPackage = fabPackage;
    }

    public FabService getFabService() {
        return fabService;
    }

    public void setFabService(FabService fabService) {
        this.fabService = fabService;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FabTariff other = (FabTariff) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if (this.initiationFee != other.initiationFee) {
            return false;
        }
        if (this.reccuringFee != other.reccuringFee) {
            return false;
        }
        if (this.terminationFee != other.terminationFee) {
            return false;
        }
        if (this.periods != other.periods) {
            return false;
        }
        if (this.periodUnit != other.periodUnit) {
            return false;
        }
        if (this.salesStart != other.salesStart && (this.salesStart == null || !this.salesStart.equals(other.salesStart))) {
            return false;
        }
        if (this.salesEnd != other.salesEnd && (this.salesEnd == null || !this.salesEnd.equals(other.salesEnd))) {
            return false;
        }
        if (this.quantity != other.quantity) {
            return false;
        }
        if ((this.serviceUnit == null) ? (other.serviceUnit != null) : !this.serviceUnit.equals(other.serviceUnit)) {
            return false;
        }
        if (this.isToBeBilled != other.isToBeBilled) {
            return false;
        }
        if (this.fabService != other.fabService && (this.fabService == null || !this.fabService.equals(other.fabService))) {
            return false;
        }
        if (this.fabModule != other.fabModule && (this.fabModule == null || !this.fabModule.equals(other.fabModule))) {
            return false;
        }
        if (this.fabPackage != other.fabPackage && (this.fabPackage == null || !this.fabPackage.equals(other.fabPackage))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 67 * hash + this.initiationFee;
        hash = 67 * hash + this.reccuringFee;
        hash = 67 * hash + this.terminationFee;
        hash = 67 * hash + this.periods;
        hash = 67 * hash + this.periodUnit;
        hash = 67 * hash + (this.salesStart != null ? this.salesStart.hashCode() : 0);
        hash = 67 * hash + (this.salesEnd != null ? this.salesEnd.hashCode() : 0);
        hash = 67 * hash + this.quantity;
        hash = 67 * hash + (this.serviceUnit != null ? this.serviceUnit.hashCode() : 0);
        hash = 67 * hash + (this.isToBeBilled ? 1 : 0);
        hash = 67 * hash + (this.fabService != null ? this.fabService.hashCode() : 0);
        hash = 67 * hash + (this.fabModule != null ? this.fabModule.hashCode() : 0);
        hash = 67 * hash + (this.fabPackage != null ? this.fabPackage.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "FabTariff{" + "id=" + id + ", initiationFee=" + initiationFee + ", reccuringFee=" + reccuringFee + ", terminationFee=" + terminationFee + ", periods=" + periods + ", periodUnit=" + periodUnit + ", salesStart=" + salesStart + ", salesEnd=" + salesEnd + ", quantity=" + quantity + ", serviceUnit=" + serviceUnit + ", isToBeBilled=" + isToBeBilled + ", fabService=" + fabService + ", fabModule=" + fabModule + ", fabPackage=" + fabPackage + '}';
    }            
}
