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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author Puradidjaja
 */
@Entity
public class FabOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    private String transType;
    
    private String transID;
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date orderDate;

    @ManyToOne
    private FabService fabService;
    
    @ManyToOne
    private FabCustomer fabCustomer;
    
    @ManyToOne
    private FabStatusOrder fabStatusOrder;
    
    @OneToMany(mappedBy="fabOrder", cascade= CascadeType.ALL)
    private List<FabOrderModule> fabOrderModule = new ArrayList<FabOrderModule>();
        
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public FabStatusOrder getFabStatusOrder() {
        return fabStatusOrder;
    }

    public void setFabStatusOrder(FabStatusOrder fabStatusOrder) {
        this.fabStatusOrder = fabStatusOrder;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
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
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    public List<FabOrderModule> getFabOrderModule() {
        return fabOrderModule;
    }

    public void setFabOrderModule(List<FabOrderModule> fabOrderModule) {
        this.fabOrderModule = fabOrderModule;
    }
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FabOrder)) {
            return false;
        }
        FabOrder other = (FabOrder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fab.formatic.backend.domain.FabOrder[ id=" + id + " ]";
    }
    
}
