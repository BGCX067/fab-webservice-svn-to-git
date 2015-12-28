/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fab.formatic.backend.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Hokcay
 */
@Entity
@Table(uniqueConstraints={
		@UniqueConstraint(columnNames="loginEmail"),
		@UniqueConstraint(columnNames="loginService"),
		@UniqueConstraint(columnNames="sessionID")
})
public class FabLogin implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(length=30, unique=true)
    private String sessionID;
    
    @Column(unique=true)
    private String loginEmail;
    
    @Column(unique=true)
    private String loginService;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date loginTime;
    
    private boolean expired=true;
   
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
  
    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    public String getSessionID() {
        return sessionID;
    }

    public String getLoginEmail() {
		return loginEmail;
	}

	public void setLoginEmail(String loginEmail) {
		this.loginEmail = loginEmail;
	}

	public String getLoginService() {
		return loginService;
	}

	public void setLoginService(String loginService) {
		this.loginService = loginService;
	}

	public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }
    
    public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
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
        if (!(object instanceof FabLogin)) {
            return false;
        }
        FabLogin other = (FabLogin) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "fab.formatic.backend.domain.FabLogin[id=" + id + "]";
    }

}
