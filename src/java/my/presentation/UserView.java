/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.presentation;

import boundary.UserFacade;
import entities.AuctionUser;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Daniel
 */
@ManagedBean(name = "UserView")
@RequestScoped
public class UserView {
    
    
    @EJB
    private UserFacade userFacade;
    private AuctionUser auctionUser;
    /**
     * Creates a new instance of UserView
     */
    public UserView() {
        auctionUser = new AuctionUser();
     }

    public AuctionUser getAuctionUser() {
        return auctionUser;
    }

    public void setUser(AuctionUser auctionUser) {
        this.auctionUser = auctionUser;
    }

    public UserFacade getUserFacade() {
        return userFacade;
    }

    public void setUserFacade(UserFacade userFacade) {
        this.userFacade = userFacade;
    }
    
    public String register(){
        if (userFacade.ifUserExist(auctionUser)){
            return "index";
        }
        else {
            userFacade.create(auctionUser);
            return authenticate();
        }
    }
    
    public String authenticate(){
        if (userFacade.authenticate(auctionUser))
            return "theend";
        return "index";
    }
    
    public String test(){
        return "indexOld";
    }
    
}
