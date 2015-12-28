package fab.formatic.backend.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class FabUrl implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    private String urlID;
    
    private String urlName;
    
    @ManyToOne(optional=true)
    private FabCustomer fabCustomer;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUrlID() {
		if(urlID==null){
    		urlID=getUrlName().toUpperCase();
    	}
        return urlID;
	}

	public void setUrlID(String urlID) {
		this.urlID = urlID;
	}

	public String getUrlName() {
		return urlName;
	}

	public void setUrlName(String urlName) {
		this.urlName = urlName;
	}

	public FabCustomer getFabCustomer() {
		return fabCustomer;
	}

	public void setFabCustomer(FabCustomer fabCustomer) {
		this.fabCustomer = fabCustomer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((fabCustomer == null) ? 0 : fabCustomer.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((urlID == null) ? 0 : urlID.hashCode());
		result = prime * result + ((urlName == null) ? 0 : urlName.hashCode());
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
		FabUrl other = (FabUrl) obj;
		if (fabCustomer == null) {
			if (other.fabCustomer != null)
				return false;
		} else if (!fabCustomer.equals(other.fabCustomer))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (urlID == null) {
			if (other.urlID != null)
				return false;
		} else if (!urlID.equals(other.urlID))
			return false;
		if (urlName == null) {
			if (other.urlName != null)
				return false;
		} else if (!urlName.equals(other.urlName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FabUrl [id=" + id + ", urlID=" + urlID + ", urlName=" + urlName
				+ ", fabCustomer=" + fabCustomer + "]";
	}        
}
