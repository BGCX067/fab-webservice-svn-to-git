/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fab.formatic.backend.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Puradidjaja
 */
@Entity
public class FabServiceStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length=6)
    private int status;
    
    private String transID;
    
    @Column(length=50)
    private String url;

    @Column(length=50)
    private String databaseName;
    
    private int limit1;
    private int limit2;
    private int limit3;
    
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

    public String getDatabase() {
        return databaseName;
    }

    public void setDatabase(String databaseName) {
        this.databaseName = databaseName;
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

    public int getLimit1() {
        return limit1;
    }

    public void setLimit1(int limit1) {
        this.limit1 = limit1;
    }

    public int getLimit2() {
        return limit2;
    }

    public void setLimit2(int limit2) {
        this.limit2 = limit2;
    }

    public int getLimit3() {
        return limit3;
    }

    public void setLimit3(int limit3) {
        this.limit3 = limit3;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTransID() {
        return transID;
    }

    public void setTransID(String transID) {
        this.transID = transID;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
        if (!(object instanceof FabServiceStatus)) {
            return false;
        }
        FabServiceStatus other = (FabServiceStatus) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fab.formatic.backend.domain.FabServiceStatus[ id=" + id + " ]";
    }
    
}
