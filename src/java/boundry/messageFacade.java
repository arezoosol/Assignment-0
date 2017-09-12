/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundry;

import entities.message;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Arezoo Sol
 */
@Stateless
public class messageFacade extends AbstractFacade<message> {

    @PersistenceContext(unitName = "Assignment_0PU lab setup")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public messageFacade() {
        super(message.class);
    }
    
}
