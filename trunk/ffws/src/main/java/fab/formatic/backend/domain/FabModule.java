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
import javax.persistence.ManyToOne;
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

    @Column(length=30)
    private String moduleName;
    
    @Column(length=500)
    private String moduleDesc;
    
    @ManyToMany
    private List<FabPackage> fabPackage = new ArrayList<FabPackage>();
    
    @ManyToOne
    private FabService fabService;
    
    @OneToMany(mappedBy="fabModule", cascade= CascadeType.ALL)
    private List<FabModuleStatus> fabModuleStatus = new ArrayList<FabModuleStatus>();
    
    @OneToMany(mappedBy="fabModule", cascade= CascadeType.ALL)
    private List<FabOrderModule> fabOrderModule = new ArrayList<FabOrderModule>();
    
    @OneToMany(mappedBy="fabModule", cascade= CascadeType.ALL)
    private List<FabTariff> fabTariff = new ArrayList<FabTariff>();
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<FabModuleStatus> getFabModuleStatus() {
        return fabModuleStatus;
    }

    public void setFabModuleStatus(List<FabModuleStatus> fabModuleStatus) {
        this.fabModuleStatus = fabModuleStatus;
    }

    public List<FabPackage> getFabPackage() {
        return fabPackage;
    }

    public void setFabPackage(List<FabPackage> fabPackage) {
        this.fabPackage = fabPackage;
    }

    public FabService getFabService() {
        return fabService;
    }

    public void setFabService(FabService fabService) {
        this.fabService = fabService;
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

    public List<FabOrderModule> getFabOrderModule() {
        return fabOrderModule;
    }

    public void setFabOrderModule(List<FabOrderModule> fabOrderModule) {
        this.fabOrderModule = fabOrderModule;
    }

    public List<FabTariff> getFabTariff() {
        return fabTariff;
    }

    public void setFabTariff(List<FabTariff> fabTariff) {
        this.fabTariff = fabTariff;
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
        if (!(object instanceof FabModule)) {
            return false;
        }
        FabModule other = (FabModule) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fab.formatic.backend.domain.FabModule[ id=" + id + " ]";
    }
    
}
