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
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Hokcay
 */
@Entity
@Table(uniqueConstraints={
		@UniqueConstraint(columnNames="serviceID"),
		@UniqueConstraint(columnNames="serviceName")
})
public class FabService implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length=30,unique=true)
    private String serviceName;

    @Column(unique=true)
    private String serviceID ;

    @Column(length=500)
    private String serviceDesc;
    
    private String serviceType;
    
    @Column(length=20)
    private String typeCharging;
    
    @Column(length=100)
    private String typeChargingDesc;
    
    @OneToMany(mappedBy="fabService", cascade={CascadeType.PERSIST, CascadeType.MERGE})
    private List<FabOrder> faborders = new ArrayList<FabOrder>();
    
    @OneToMany(mappedBy="fabService", cascade={CascadeType.PERSIST, CascadeType.MERGE})
    private List<FabModule> fabModules = new ArrayList<FabModule>();
    
    @OneToMany(mappedBy="fabService", cascade={CascadeType.PERSIST, CascadeType.MERGE})
    private List<FabPackage> fabPackages = new ArrayList<FabPackage>();
    
    @OneToMany(mappedBy="fabService", cascade={CascadeType.PERSIST, CascadeType.MERGE})
    private List<FabTariff> fabTariffs = new ArrayList<FabTariff>();
        
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
   
    public String getServiceDesc() {
        return serviceDesc;
    }

    public void setServiceDesc(String serviceDesc) {
        this.serviceDesc = serviceDesc;
    }

    public String getServiceID() {
    	if(serviceID==null){
    		serviceID=getServiceName().toUpperCase();
    	}
        return serviceID;
    }

    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }        
    
    public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
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

	public List<FabOrder> getFaborders() {
		return faborders;
	}

	public void setFaborders(List<FabOrder> faborders) {
		this.faborders = faborders;
	}
	
	public List<FabModule> getFabModules() {
		return fabModules;
	}

	public void setFabModules(List<FabModule> fabModules) {
		this.fabModules = fabModules;
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

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FabService)) {
            return false;
        }
        FabService other = (FabService) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fab.formatic.backend.domain.FabService[id=" + id + "]";
    }

}
