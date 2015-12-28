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
 * @author Hokcay
 */
@Entity
public class FabServiceUsed implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date serviceStart;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date serviceEnd;
    
    @Column(length=32)
    private int serviceAmount;
    
    private double serviceCount;
    
    @Column(length=6)
    private int billStatus;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date transDate;
    
    @Column(length=32)
    private int transAmount;
    
    private double  discountAmount;
    
    private boolean isExceed;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date paymentDate;
    
    @Column(length=32)
    private int paymentAmount;
    
    private double paymentDiscount;
    
    private String paymentPeriod;
    
    private String revCode;
    
    @ManyToOne
    private FabService fabService;
    
    @ManyToOne
    private FabCustomer fabCustomer;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
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

    public int getServiceAmount() {
        return serviceAmount;
    }

    public void setServiceAmount(int serviceAmount) {
        this.serviceAmount = serviceAmount;
    }

    public double getServiceCount() {
        return serviceCount;
    }

    public void setServiceCount(double serviceCount) {
        this.serviceCount = serviceCount;
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
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FabServiceUsed)) {
            return false;
        }
        FabServiceUsed other = (FabServiceUsed) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fab.formatic.backend.domain.FabServiceUsed[id=" + id + "]";
    }

}
