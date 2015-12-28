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

@Entity
public class FabPromo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    private String promoID;
    
    private String promoName;
    
    @Column(length=100)
    private String promoDesc;
    
    @OneToMany(mappedBy="fabPromo", cascade={CascadeType.PERSIST, CascadeType.MERGE})
    private List<FabPackage> fabpPackages = new ArrayList<FabPackage>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPromoID() {
		if(promoID==null){
    		promoID=getPromoName().toUpperCase();
    	}
        return promoID;
	}

	public void setPromoID(String promoID) {
		this.promoID = promoID;
	}

	public String getPromoName() {
		return promoName;
	}

	public void setPromoName(String promoName) {
		this.promoName = promoName;
	}

	public String getPromoDesc() {
		return promoDesc;
	}

	public void setPromoDesc(String promoDesc) {
		this.promoDesc = promoDesc;
	}

	public List<FabPackage> getFabpPackages() {
		return fabpPackages;
	}

	public void setFabpPackages(List<FabPackage> fabpPackages) {
		this.fabpPackages = fabpPackages;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((promoDesc == null) ? 0 : promoDesc.hashCode());
		result = prime * result + ((promoID == null) ? 0 : promoID.hashCode());
		result = prime * result
				+ ((promoName == null) ? 0 : promoName.hashCode());
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
		FabPromo other = (FabPromo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (promoDesc == null) {
			if (other.promoDesc != null)
				return false;
		} else if (!promoDesc.equals(other.promoDesc))
			return false;
		if (promoID == null) {
			if (other.promoID != null)
				return false;
		} else if (!promoID.equals(other.promoID))
			return false;
		if (promoName == null) {
			if (other.promoName != null)
				return false;
		} else if (!promoName.equals(other.promoName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FabPromo [id=" + id + ", promoID=" + promoID + ", promoName="
				+ promoName + ", promoDesc=" + promoDesc + "]";
	}        
}
