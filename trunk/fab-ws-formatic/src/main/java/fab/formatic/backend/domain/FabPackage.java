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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class FabPackage implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
        
    private String packageID;
    
    private String packageName;
    
    @Column(length=500)
    private String packageDesc;
    
    @OneToMany(mappedBy="fabPackage", cascade={CascadeType.PERSIST, CascadeType.MERGE})
    private List<FabOrder> fabOrders = new ArrayList<FabOrder>();
    
    @ManyToOne(optional=true)
    private FabHost fabHost;
    
    @ManyToOne(optional=true)
    private FabPromo fabPromo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPackageID() {
		if(packageID==null){
    		packageID=getPackageName().toUpperCase();
    	}
        return packageID;
	}

	public void setPackageID(String packageID) {
		this.packageID = packageID;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getPackageDesc() {
		return packageDesc;
	}

	public void setPackageDesc(String packageDesc) {
		this.packageDesc = packageDesc;
	}

	public List<FabOrder> getFabOrders() {
		return fabOrders;
	}

	public void setFabOrders(List<FabOrder> fabOrders) {
		this.fabOrders = fabOrders;
	}

	public FabHost getFabHost() {
		return fabHost;
	}

	public void setFabHost(FabHost fabHost) {
		this.fabHost = fabHost;
	}

	public FabPromo getFabPromo() {
		return fabPromo;
	}

	public void setFabPromo(FabPromo fabPromo) {
		this.fabPromo = fabPromo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((packageDesc == null) ? 0 : packageDesc.hashCode());
		result = prime * result
				+ ((packageID == null) ? 0 : packageID.hashCode());
		result = prime * result
				+ ((packageName == null) ? 0 : packageName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FabPackage other = (FabPackage) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (packageDesc == null) {
			if (other.packageDesc != null)
				return false;
		} else if (!packageDesc.equals(other.packageDesc))
			return false;
		if (packageID == null) {
			if (other.packageID != null)
				return false;
		} else if (!packageID.equals(other.packageID))
			return false;
		if (packageName == null) {
			if (other.packageName != null)
				return false;
		} else if (!packageName.equals(other.packageName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FabPackage [id=" + id + ", packageID=" + packageID
				+ ", packageName=" + packageName + ", packageDesc="
				+ packageDesc + "]";
	}     
}
