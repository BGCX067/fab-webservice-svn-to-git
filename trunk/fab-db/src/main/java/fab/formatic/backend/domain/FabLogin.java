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
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Hokcay
 */
@Entity
public class FabLogin implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(length=500, unique=true)
    private String sessionID;
    
    private String loginEmail;
    
    private String loginService;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date loginTime;
    
    private boolean expired=true;
   
    @ManyToOne(optional=true)
    private FabCustomer fabCustomer;
    
    @ManyToOne(optional=true)
    private FabService fabService;

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

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public FabCustomer getFabCustomer() {
        return fabCustomer;
    }

    public void setFabCustomer(FabCustomer fabCustomer) {
        this.fabCustomer = fabCustomer;
    }

    public FabService getFabService() {
        return fabService;
    }

    public void setFabService(FabService fabService) {
        this.fabService = fabService;
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

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FabLogin other = (FabLogin) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if ((this.sessionID == null) ? (other.sessionID != null) : !this.sessionID.equals(other.sessionID)) {
            return false;
        }
        if ((this.loginEmail == null) ? (other.loginEmail != null) : !this.loginEmail.equals(other.loginEmail)) {
            return false;
        }
        if ((this.loginService == null) ? (other.loginService != null) : !this.loginService.equals(other.loginService)) {
            return false;
        }
        if (this.loginTime != other.loginTime && (this.loginTime == null || !this.loginTime.equals(other.loginTime))) {
            return false;
        }
        if (this.expired != other.expired) {
            return false;
        }
        if (this.fabCustomer != other.fabCustomer && (this.fabCustomer == null || !this.fabCustomer.equals(other.fabCustomer))) {
            return false;
        }
        if (this.fabService != other.fabService && (this.fabService == null || !this.fabService.equals(other.fabService))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 37 * hash + (this.sessionID != null ? this.sessionID.hashCode() : 0);
        hash = 37 * hash + (this.loginEmail != null ? this.loginEmail.hashCode() : 0);
        hash = 37 * hash + (this.loginService != null ? this.loginService.hashCode() : 0);
        hash = 37 * hash + (this.loginTime != null ? this.loginTime.hashCode() : 0);
        hash = 37 * hash + (this.expired ? 1 : 0);
        hash = 37 * hash + (this.fabCustomer != null ? this.fabCustomer.hashCode() : 0);
        hash = 37 * hash + (this.fabService != null ? this.fabService.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "FabLogin{" + "id=" + id + ", sessionID=" + sessionID + ", loginEmail=" + loginEmail + ", loginService=" + loginService + ", loginTime=" + loginTime + ", expired=" + expired + ", fabCustomer=" + fabCustomer + ", fabService=" + fabService + '}';
    }
    
   
}
