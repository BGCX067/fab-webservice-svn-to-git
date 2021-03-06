/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fab.formatic.backend.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Puradidjaja
 */
@Entity
public class FabStatusOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(length=20)
    private String statusOrderName;
    
    @Column(length=100)
    private String statusOrderDesc;
    
    @OneToMany(mappedBy="fabStatusOrder", cascade= CascadeType.ALL)
    private List<FabOrder> fabOrder = new ArrayList<FabOrder>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<FabOrder> getFabOrder() {
        return fabOrder;
    }

    public void setFabOrder(List<FabOrder> fabOrder) {
        this.fabOrder = fabOrder;
    }

    public String getStatusOrderDesc() {
        return statusOrderDesc;
    }

    public void setStatusOrderDesc(String statusOrderDesc) {
        this.statusOrderDesc = statusOrderDesc;
    }

    public String getStatusOrderName() {
        return statusOrderName;
    }

    public void setStatusOrderName(String statusOrderName) {
        this.statusOrderName = statusOrderName;
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
        if (!(object instanceof FabStatusOrder)) {
            return false;
        }
        FabStatusOrder other = (FabStatusOrder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fab.formatic.backend.domain.FabStatusOrder[ id=" + id + " ]";
    }
    
}
