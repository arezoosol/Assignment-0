/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.presentation;

import boundary.BidsFacade;
import entities.Bids;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Daniel
 */
@ManagedBean(name = "BidsView")
@RequestScoped
public class BidsView {

    @EJB
    private BidsFacade bidsFacade;
    private Bids bids;

    public BidsFacade getBidsFacade() {
        return bidsFacade;
    }

    public void setBidsFacade(BidsFacade bidsFacade) {
        this.bidsFacade = bidsFacade;
    }

    public Bids getBids() {
        return bids;
    }

    public void setBids(Bids bids) {
        this.bids = bids;
    }
    /**
     * Creates a new instance of BidsView
     */
    public BidsView() {
        bids = new Bids();
    }
    
}
