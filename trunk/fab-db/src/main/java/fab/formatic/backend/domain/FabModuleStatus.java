/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fab.formatic.backend.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author SWG
 */
@Entity
public class FabModuleStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private int status;
    
    @ManyToOne(optional=true)
    private FabModule fabModule;
    
    @ManyToOne(optional = true)
    private FabCustomer fabCustomer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FabCustomer getFabCustomer() {
        return fabCustomer;
    }

    public void setFabCustomer(FabCustomer fabCustomer) {
        this.fabCustomer = fabCustomer;
    }

    public FabModule getFabModule() {
        return fabModule;
    }

    public void setFabModule(FabModule fabModule) {
        this.fabModule = fabModule;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
}
