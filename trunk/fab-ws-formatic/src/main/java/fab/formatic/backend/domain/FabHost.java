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
public class FabHost implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String hostID;
    
    private String hostName;
    
    @Column(length=500)
    private String hostDesc;
    
    @OneToMany(mappedBy="fabHost", cascade={CascadeType.PERSIST, CascadeType.MERGE})
    private List<FabPackage> fabpPackages = new ArrayList<FabPackage>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHostID() {
		if(hostID==null){
    		hostID=getHostName().toUpperCase();
    	}
        return hostID;
	}

	public void setHostID(String hostID) {
		this.hostID = hostID;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getHostDesc() {
		return hostDesc;
	}

	public void setHostDesc(String hostDesc) {
		this.hostDesc = hostDesc;
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
		result = prime * result
				+ ((hostDesc == null) ? 0 : hostDesc.hashCode());
		result = prime * result + ((hostID == null) ? 0 : hostID.hashCode());
		result = prime * result
				+ ((hostName == null) ? 0 : hostName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		FabHost other = (FabHost) obj;
		if (hostDesc == null) {
			if (other.hostDesc != null)
				return false;
		} else if (!hostDesc.equals(other.hostDesc))
			return false;
		if (hostID == null) {
			if (other.hostID != null)
				return false;
		} else if (!hostID.equals(other.hostID))
			return false;
		if (hostName == null) {
			if (other.hostName != null)
				return false;
		} else if (!hostName.equals(other.hostName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FabHost [id=" + id + ", hostID=" + hostID + ", hostName="
				+ hostName + ", hostDesc=" + hostDesc + "]";
	}
    
        
}
