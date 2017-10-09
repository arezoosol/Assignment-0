/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.presentation;

import boundary.ProductCatalogFacade;
import entities.ProductCatalog;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Daniel
 */
@ManagedBean(name = "ProductCatalogView")
@RequestScoped
public class ProductCatalogView {

    @EJB
    private ProductCatalogFacade productCatalogFacade;
    private ProductCatalog productCatalog;
    
    @ManagedProperty(value="#{AuctionUserView}")
    private AuctionUserView auctionUserView;

    public AuctionUserView getAuctionUserView() {
        return auctionUserView;
    }

    public void setAuctionUserView(AuctionUserView auctionUserView) {
        this.auctionUserView = auctionUserView;
    }
    
    public void createCatalog(){
        if (auctionUserView.getAuctionUser().getProductCatalog()==null){
        productCatalog = new ProductCatalog();
        this.auctionUserView.getAuctionUser().setProductCatalog(productCatalog);
        productCatalogFacade.create(productCatalog);
        this.auctionUserView.getUserFacade().save(auctionUserView.getAuctionUser());}
    }

    public ProductCatalogFacade getProductCatalogFacade() {
        return productCatalogFacade;
    }

    public void setProductCatalogFacade(ProductCatalogFacade productCatalogFacade) {
        this.productCatalogFacade = productCatalogFacade;
    }

    public ProductCatalog getProductCatalog() {
        return productCatalog;
    }
    
    public void publish(){
        System.out.println("Trying to publish catalog!");
        productCatalogFacade.Publish(auctionUserView);
        auctionUserView.update();
    }

    public void setProductCatalog(ProductCatalog productCatalog) {
        this.productCatalog = productCatalog;
    }
    /**
     * Creates a new instance of ProductCatalogView
     */
    public ProductCatalogView() {
        productCatalog = new ProductCatalog();
    }
    
}
