/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.presentation;

import boundary.BidsFacade;
import entities.Bids;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;

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
    
    @ManagedProperty(value="#{AuctionUserView}")
    private AuctionUserView auctionUserView;

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
    
    public void publish(ActionEvent event){
        this.bidsFacade.publish(auctionUserView);
    }

    public AuctionUserView getAuctionUserView() {
        return auctionUserView;
    }

    public void setAuctionUserView(AuctionUserView auctionUserView) {
        this.auctionUserView = auctionUserView;
    }
    
    public List<Bids> getMostRecentBids(){
        List<Bids> recentBids = bidsFacade.findRecent();
        if (recentBids.size()>10)
            return recentBids.subList(0, 10);
        return recentBids;
    }
    
    public void bid(Bids bid){
        System.out.println("Trying to print bid");
        if (bid!=null)
        System.out.println(bid.getId());
    }
    
    private String asTable(List<Bids> list){
        if (list==null)
            return "null";
        String s ="<table><tr><td>Current Bid</td><td>Time left</td></tr>";
        for (Bids b : list){
            s+="<tr><td>"+b.getBid()+"</td><td>"+b.getBidDuration()+"</td></tr>";
        }
        s+="</table>";
        return s;
    }
    /**
     * Creates a new instance of BidsView
     */
    public BidsView() {
        bids = new Bids();
    }
    
}
