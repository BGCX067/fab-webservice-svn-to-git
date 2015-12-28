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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author Puradidjaja
 */
@Entity
public class FabModule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(length = 30)
    private String moduleName;
    @Column(length = 500)
    private String moduleDesc;
    @Column(length = 20)
    private String typeCharging;
    @Column(length = 100)
    private String typeChargingDesc;
    @ManyToMany
    private List<FabPackage> fabPackages = new ArrayList<FabPackage>();
    @OneToMany(mappedBy = "fabModule", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<FabTariff> fabTariffs = new ArrayList<FabTariff>();
    @OneToMany(mappedBy = "fabModule", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<FabModuleStatus> fabModuleStatuses = new ArrayList<FabModuleStatus>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModuleDesc() {
        return moduleDesc;
    }

    public void setModuleDesc(String moduleDesc) {
        this.moduleDesc = moduleDesc;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getTypeCharging() {
        return typeCharging;
    }

    public void setTypeCharging(String typeCharging) {
        this.typeCharging = typeCharging;
    }

    public String getTypeChargingDesc() {
        return typeChargingDesc;
    }

    public void setTypeChargingDesc(String typeChargingDesc) {
        this.typeChargingDesc = typeChargingDesc;
    }

    public List<FabPackage> getFabPackages() {
        return fabPackages;
    }

    public void setFabPackages(List<FabPackage> fabPackages) {
        this.fabPackages = fabPackages;
    }

    public List<FabTariff> getFabTariffs() {
        return fabTariffs;
    }

    public void setFabTariffs(List<FabTariff> fabTariffs) {
        this.fabTariffs = fabTariffs;
    }

    public List<FabModuleStatus> getFabModuleStatuses() {
        return fabModuleStatuses;
    }

    public void setFabModuleStatuses(List<FabModuleStatus> fabModuleStatuses) {
        this.fabModuleStatuses = fabModuleStatuses;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FabModule other = (FabModule) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if ((this.moduleName == null) ? (other.moduleName != null) : !this.moduleName.equals(other.moduleName)) {
            return false;
        }
        if ((this.moduleDesc == null) ? (other.moduleDesc != null) : !this.moduleDesc.equals(other.moduleDesc)) {
            return false;
        }
        if ((this.typeCharging == null) ? (other.typeCharging != null) : !this.typeCharging.equals(other.typeCharging)) {
            return false;
        }
        if ((this.typeChargingDesc == null) ? (other.typeChargingDesc != null) : !this.typeChargingDesc.equals(other.typeChargingDesc)) {
            return false;
        }
        if (this.fabPackages != other.fabPackages && (this.fabPackages == null || !this.fabPackages.equals(other.fabPackages))) {
            return false;
        }

        if (this.fabTariffs != other.fabTariffs && (this.fabTariffs == null || !this.fabTariffs.equals(other.fabTariffs))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 67 * hash + (this.moduleName != null ? this.moduleName.hashCode() : 0);
        hash = 67 * hash + (this.moduleDesc != null ? this.moduleDesc.hashCode() : 0);
        hash = 67 * hash + (this.typeCharging != null ? this.typeCharging.hashCode() : 0);
        hash = 67 * hash + (this.typeChargingDesc != null ? this.typeChargingDesc.hashCode() : 0);
        hash = 67 * hash + (this.fabPackages != null ? this.fabPackages.hashCode() : 0);
        hash = 67 * hash + (this.fabTariffs != null ? this.fabTariffs.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "FabModule{" + "id=" + id + ", moduleName=" + moduleName + ", moduleDesc=" + moduleDesc + ", typeCharging=" + typeCharging + ", typeChargingDesc=" + typeChargingDesc + ", fabPackages=" + fabPackages + ", fabOrders=" + ", fabTariffs=" + fabTariffs + '}';
    }
}
