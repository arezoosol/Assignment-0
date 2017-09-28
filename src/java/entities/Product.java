/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Daniel
 */
@Entity
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String productName;
    private String feedBack; 
  //  private Bids currentBid;
    private String contactInformation;
    private double sellersRating;
    
    public Product(String productName){
        this.productName=productName;
    }
    //A test product is made here for testing purposes
    public Product() {
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(String feedBack) {
        this.feedBack = feedBack;
    }

//    public Bids getCurrentBid() {
//        return currentBid;
//    }
//
//    public void setCurrentBid(Bids currentBid) {
//        this.currentBid = currentBid;
//    }

    public String getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }

    public double getSellersRating() {
        return sellersRating;
    }

    public void setSellersRating(int sellersRating) {
        this.sellersRating = sellersRating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getProductAsTableRow(){
        String s = "<tr><td>"+productName+"</td><td>"+feedBack+"</td><td>"+contactInformation+"</td><td>"+sellersRating+"</td></tr>";
        return s;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        String string ="";
        string += "productName: " + productName +"\n";
        string += "feedback: " + feedBack +"\n";
    //    string += "currentBid" + currentBid +"\n";
        string += "contactInformation: " + contactInformation +"\n";
        string += "sellers rating: " + sellersRating +"\n";
        return string;
    }
    
}
