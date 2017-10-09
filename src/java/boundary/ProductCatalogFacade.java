/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import entities.Product;
import entities.ProductCatalog;
import entities.ProductCatalog_;
import entities.Product_;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import my.presentation.AuctionUserView;

/**
 *
 * @author Daniel
 */
@Stateless
public class ProductCatalogFacade extends AbstractFacade<ProductCatalog> {

    @PersistenceContext(unitName = "SimpleEE6AppPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductCatalogFacade() {
        super(ProductCatalog.class);
    }

    public void Publish(AuctionUserView auctionUserView) {
//        CriteriaBuilder builder = em.getCriteriaBuilder();
//        CriteriaUpdate<Product> update = builder.createCriteriaUpdate(Product.class);
//        Root<Product> e = update.from(Product.class);
//        e.join(Product_.productCatalog);
//        update.set(Product_.published, true);
//        update.where(builder.equal(e.get((Product_.productCatalog)).get(ProductCatalog_.id).as(Long.class),(catalog.getId())));
//        this.em.createQuery(update).executeUpdate();
        TypedQuery<Product> query = em.createQuery("UPDATE Product SET published = "+true+" where productCatalog.id = '" + auctionUserView.getAuctionUser().getProductCatalog().getId()+"'",Product.class);
        query.executeUpdate();
        
    }
    
}
