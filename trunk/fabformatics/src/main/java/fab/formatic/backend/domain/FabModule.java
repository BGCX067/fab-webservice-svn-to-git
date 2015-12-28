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
    
    @Column(length=20)
    private String typeCharging;
    
    @Column(length=100)
    private String typeChargingDesc;
    
    @ManyToMany
    private List<FabPackage> fabPackages = new ArrayList<FabPackage>();
    
    @ManyToMany(mappedBy="fabModules", cascade={CascadeType.PERSIST, CascadeType.MERGE})
    private List<FabOrder> fabOrders = new ArrayList<FabOrder>();
    
    @ManyToOne(optional=true)
    private FabService fabService;
    
    @OneToMany(mappedBy="fabModule", cascade={CascadeType.PERSIST, CascadeType.MERGE})
    private List<FabTariff> fabTariffs = new ArrayList<FabTariff>();
    
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

	public List<FabOrder> getFabOrders() {
		return fabOrders;
	}

	public void setFabOrders(List<FabOrder> fabOrders) {
		this.fabOrders = fabOrders;
	}

	public FabService getFabService() {
		return fabService;
	}

	public void setFabService(FabService fabService) {
		this.fabService = fabService;
	}

	public List<FabTariff> getFabTariffs() {
		return fabTariffs;
	}

	public void setFabTariffs(List<FabTariff> fabTariffs) {
		this.fabTariffs = fabTariffs;
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
