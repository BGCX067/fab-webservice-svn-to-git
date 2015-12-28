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
 * @author Hokcay
 */
@Entity
public class FabTypeCharging implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length=20)
    private String typeChargingName;

    @Column(length=100)
    private String typeChargindDesc;

    @OneToMany(mappedBy="fabTypeCharging", cascade=CascadeType.ALL)
    private List<FabService> fabService = new ArrayList<FabService>();
    
    @OneToMany(mappedBy="fabTypeCharging", cascade=CascadeType.ALL)
    private List<FabPackage> fabPackage = new ArrayList<FabPackage>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public List<FabService> getFabService() {
        return fabService;
    }

    public void setFabService(List<FabService> fabService) {
        this.fabService = fabService;
    }
    
    public String getTypeChargindDesc() {
        return typeChargindDesc;
    }

    public void setTypeChargindDesc(String typeChargindDesc) {
        this.typeChargindDesc = typeChargindDesc;
    }

    public String getTypeChargingName() {
        return typeChargingName;
    }

    public void setTypeChargingName(String typeChargingName) {
        this.typeChargingName = typeChargingName;
    }

    public List<FabPackage> getFabPackage() {
        return fabPackage;
    }

    public void setFabPackage(List<FabPackage> fabPackage) {
        this.fabPackage = fabPackage;
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
        if (!(object instanceof FabTypeCharging)) {
            return false;
        }
        FabTypeCharging other = (FabTypeCharging) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fab.formatic.backend.domain.FabTypeCharging[id=" + id + "]";
    }

}
