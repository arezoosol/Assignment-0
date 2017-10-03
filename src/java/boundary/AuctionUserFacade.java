/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import entities.AuctionUser;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Daniel
 */
@Stateless
public class AuctionUserFacade extends AbstractFacade<AuctionUser> {

    @PersistenceContext(unitName = "SimpleEE6AppPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AuctionUserFacade() {
        super(AuctionUser.class);
    }
    
    public boolean ifUserExist(AuctionUser auctionUser){
        if (auctionUser == null)
            return false;
        System.out.println(em.isOpen());
        TypedQuery<AuctionUser> query = em.createQuery("Select u from AuctionUser u where u.username = '" + auctionUser.getUsername() + "'",AuctionUser.class);
        AuctionUser u = null;
        try {
        u = query.getSingleResult();
        } catch(Exception e){
            
        }
        return u!= null && u.getUsername().equals(auctionUser.getUsername());
    }
    //TODO
    public boolean authenticate(AuctionUser auctionUser){;
//        Query query = em.createQuery("SELECT x FROM User x WHERE x.username = '" + user.getUsername() + "'");
//        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery(User.class);
//        CriteriaQuery select = cq.select(cq.from(User.class));
        boolean validLogin = false;
        TypedQuery<AuctionUser> query = em.createQuery("Select u from AuctionUser u where u.username = '" + auctionUser.getUsername() + "'",AuctionUser.class);
        AuctionUser u = null;
        try {
        u = query.getSingleResult();
        } catch(Exception e){
            System.out.println(e);
        }
        if (u!= null){
            validLogin =  u.getUsername().equals(auctionUser.getUsername()) && u.getPassword().equals(auctionUser.getPassword());
        }
        if (validLogin){
            auctionUser = u;
        }
        return validLogin;
    }
    
}
