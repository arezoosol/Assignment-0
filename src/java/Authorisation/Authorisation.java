/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Authorisation;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Daniel
 */
@ManagedBean(name = "Authorisation")
@RequestScoped
public class Authorisation implements Serializable {

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    private String username;
    private String password;

    /**
     * Creates a new instance of Authorisation
     */
    public Authorisation() {
    }
    
}
