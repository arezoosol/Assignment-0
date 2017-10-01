/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.presentation;

import boundary.ProductFacade;
import entities.Product;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Daniel
 */
@ManagedBean(name = "ProductView")
@RequestScoped
public class ProductView {
    @EJB
    private ProductFacade productFacade;
    private Product product;

    /**
     * Creates a new instance of ProductView
     */
    public ProductView() {
        this.product = new Product();
    }
    
    public Product getProduct(){
        return product;
    }
    
    public String getAllProducts(){
        String s = "";
        for (Product p: productFacade.findAll()){
            s+=p.toString();
        }
        return s;
    }
    
    public String getAllProductsAsTable(){
                String s = "<table><tr><td>Product name</td><td>Feedback</td><td>Contact information</td><td>Sellers rating</td></tr>";
                for (Product p : productFacade.findAll())
                    s+=p.getProductAsTableRow();
                s+="</table>";
                return s;
    }
    
    public int getNumberOfProducts(){
        return productFacade.findAll().size();
    }
    
    public String postProduct(){
        return "theend";
    }
    
}
