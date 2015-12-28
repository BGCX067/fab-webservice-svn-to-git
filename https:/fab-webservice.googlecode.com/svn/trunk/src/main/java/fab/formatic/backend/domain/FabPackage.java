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
 * @author Hokcay
 */
@Entity
public class FabPackage implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length=30)
    private String packageName;
    
    @Column(length=500)
    private String packageDesc;
    
    @Column(length=20)
    private String typeCharging;
    
    @Column(length=100)
    private String typeChargingDesc;
    
    @ManyToOne(optional=true)
    private FabService fabService;
    
    @ManyToMany(mappedBy="fabPackages", cascade={CascadeType.PERSIST, CascadeType.MERGE})
    private List<FabModule> fabModules = new ArrayList<FabModule>();
    
    @OneToMany(mappedBy="fabPackage", cascade={CascadeType.PERSIST, CascadeType.MERGE})
    private List<FabTariff> fabTariffs = new ArrayList<FabTariff>();      
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
   
    public String getPackageDesc() {
        return packageDesc;
    }

    public void setPackageDesc(String packageDesc) {
        this.packageDesc = packageDesc;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
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

	public FabService getFabService() {
		return fabService;
	}

	public void setFabService(FabService fabService) {
		this.fabService = fabService;
	}

	public List<FabModule> getFabModules() {
		return fabModules;
	}

	public void setFabModules(List<FabModule> fabModules) {
		this.fabModules = fabModules;
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
        if (!(object instanceof FabPackage)) {
            return false;
        }
        FabPackage other = (FabPackage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fab.formatic.backend.domain.FabPackage[id=" + id + "]";
    }

}
