/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fab.formatic.backend.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Puradidjaja
 */
@Entity
@Table(uniqueConstraints={
		@UniqueConstraint(columnNames="url")
})
public class FabServiceStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length=6)
    private int status;
    
    @Column(length=50, unique=true)
    private String url;

    @Column(length=50)
    private String databaseName;
    
    private int limit1;
    private int limit2;
    private int limit3;
   
    @ManyToOne(optional=true)
    private FabOrder fabOrder;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDatabaseName() {
		return databaseName;
	}

	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

	public int getLimit1() {
		return limit1;
	}

	public void setLimit1(int limit1) {
		this.limit1 = limit1;
	}

	public int getLimit2() {
		return limit2;
	}

	public void setLimit2(int limit2) {
		this.limit2 = limit2;
	}

	public int getLimit3() {
		return limit3;
	}

	public void setLimit3(int limit3) {
		this.limit3 = limit3;
	}

	public FabOrder getFabOrder() {
		return fabOrder;
	}

	public void setFabOrder(FabOrder fabOrder) {
		this.fabOrder = fabOrder;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((databaseName == null) ? 0 : databaseName.hashCode());
		result = prime * result
				+ ((fabOrder == null) ? 0 : fabOrder.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + limit1;
		result = prime * result + limit2;
		result = prime * result + limit3;
		result = prime * result + status;
		result = prime * result + ((url == null) ? 0 : url.hashCode());
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
		FabServiceStatus other = (FabServiceStatus) obj;
		if (databaseName == null) {
			if (other.databaseName != null)
				return false;
		} else if (!databaseName.equals(other.databaseName))
			return false;
		if (fabOrder == null) {
			if (other.fabOrder != null)
				return false;
		} else if (!fabOrder.equals(other.fabOrder))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (limit1 != other.limit1)
			return false;
		if (limit2 != other.limit2)
			return false;
		if (limit3 != other.limit3)
			return false;
		if (status != other.status)
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FabServiceStatus [id=" + id + ", status=" + status + ", url="
				+ url + ", databaseName=" + databaseName + ", limit1=" + limit1
				+ ", limit2=" + limit2 + ", limit3=" + limit3 + ", fabOrder="
				+ fabOrder + "]";
	}
    
    
    
}
