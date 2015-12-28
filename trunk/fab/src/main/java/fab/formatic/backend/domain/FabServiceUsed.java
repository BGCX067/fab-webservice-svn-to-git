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
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Hokcay
 */
@Entity
public class FabServiceUsed implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(length=6)
    private int billStatus;
       
    @Column(length=32)
    private int transAmount;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date transDate;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date serviceStart;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date serviceEnd;
    
    private double discountAmount;
    
    private boolean isExceed;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date paymentDate;
    
    @Column(length=32)
    private int paymentAmount;
    
    private double paymentDiscount;
    
    private String paymentPeriod;
    
    private String revCode;       
    
    @OneToOne(optional=true)
    private FabOrder fabOrder;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isIsExceed() {
        return isExceed;
    }

    public void setIsExceed(boolean isExceed) {
        this.isExceed = isExceed;
    }

    public int getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(int paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public double getPaymentDiscount() {
        return paymentDiscount;
    }

    public void setPaymentDiscount(double paymentDiscount) {
        this.paymentDiscount = paymentDiscount;
    }

    public String getPaymentPeriod() {
        return paymentPeriod;
    }

    public void setPaymentPeriod(String paymentPeriod) {
        this.paymentPeriod = paymentPeriod;
    }

    public String getRevCode() {
        return revCode;
    }

    public void setRevCode(String revCode) {
        this.revCode = revCode;
    }

    public Date getServiceEnd() {
        return serviceEnd;
    }

    public void setServiceEnd(Date serviceEnd) {
        this.serviceEnd = serviceEnd;
    }

    public Date getServiceStart() {
        return serviceStart;
    }

    public void setServiceStart(Date serviceStart) {
        this.serviceStart = serviceStart;
    }

    public int getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(int transAmount) {
        this.transAmount = transAmount;
    }

    public Date getTransDate() {
        return transDate;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    public int getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(int billStatus) {
        this.billStatus = billStatus;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public FabOrder getFabOrder() {
        return fabOrder;
    }

    public void setFabOrder(FabOrder fabOrder) {
        this.fabOrder = fabOrder;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FabServiceUsed other = (FabServiceUsed) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if (this.billStatus != other.billStatus) {
            return false;
        }
        if (this.transAmount != other.transAmount) {
            return false;
        }
        if (this.transDate != other.transDate && (this.transDate == null || !this.transDate.equals(other.transDate))) {
            return false;
        }
        if (this.serviceStart != other.serviceStart && (this.serviceStart == null || !this.serviceStart.equals(other.serviceStart))) {
            return false;
        }
        if (this.serviceEnd != other.serviceEnd && (this.serviceEnd == null || !this.serviceEnd.equals(other.serviceEnd))) {
            return false;
        }
        if (Double.doubleToLongBits(this.discountAmount) != Double.doubleToLongBits(other.discountAmount)) {
            return false;
        }
        if (this.isExceed != other.isExceed) {
            return false;
        }
        if (this.paymentDate != other.paymentDate && (this.paymentDate == null || !this.paymentDate.equals(other.paymentDate))) {
            return false;
        }
        if (this.paymentAmount != other.paymentAmount) {
            return false;
        }
        if (Double.doubleToLongBits(this.paymentDiscount) != Double.doubleToLongBits(other.paymentDiscount)) {
            return false;
        }
        if ((this.paymentPeriod == null) ? (other.paymentPeriod != null) : !this.paymentPeriod.equals(other.paymentPeriod)) {
            return false;
        }
        if ((this.revCode == null) ? (other.revCode != null) : !this.revCode.equals(other.revCode)) {
            return false;
        }
        if (this.fabOrder != other.fabOrder && (this.fabOrder == null || !this.fabOrder.equals(other.fabOrder))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 23 * hash + this.billStatus;
        hash = 23 * hash + this.transAmount;
        hash = 23 * hash + (this.transDate != null ? this.transDate.hashCode() : 0);
        hash = 23 * hash + (this.serviceStart != null ? this.serviceStart.hashCode() : 0);
        hash = 23 * hash + (this.serviceEnd != null ? this.serviceEnd.hashCode() : 0);
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.discountAmount) ^ (Double.doubleToLongBits(this.discountAmount) >>> 32));
        hash = 23 * hash + (this.isExceed ? 1 : 0);
        hash = 23 * hash + (this.paymentDate != null ? this.paymentDate.hashCode() : 0);
        hash = 23 * hash + this.paymentAmount;
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.paymentDiscount) ^ (Double.doubleToLongBits(this.paymentDiscount) >>> 32));
        hash = 23 * hash + (this.paymentPeriod != null ? this.paymentPeriod.hashCode() : 0);
        hash = 23 * hash + (this.revCode != null ? this.revCode.hashCode() : 0);
        hash = 23 * hash + (this.fabOrder != null ? this.fabOrder.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "FabServiceUsed{" + "id=" + id + ", billStatus=" + billStatus + ", transAmount=" + transAmount + ", transDate=" + transDate + ", serviceStart=" + serviceStart + ", serviceEnd=" + serviceEnd + ", discountAmount=" + discountAmount + ", isExceed=" + isExceed + ", paymentDate=" + paymentDate + ", paymentAmount=" + paymentAmount + ", paymentDiscount=" + paymentDiscount + ", paymentPeriod=" + paymentPeriod + ", revCode=" + revCode + ", fabOrder=" + fabOrder + '}';
    }           
}
