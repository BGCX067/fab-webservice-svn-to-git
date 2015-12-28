/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fab.formatic.backend.domain;

import java.io.Serializable;
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
public class FabOrderModule implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @ManyToOne
    private FabOrder fabOrder;
    
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
        if (!(object instanceof FabOrderModule)) {
            return false;
        }
        FabOrderModule other = (FabOrderModule) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fab.formatic.backend.domain.FabOrderModule[ id=" + id + " ]";
    }
    
}
