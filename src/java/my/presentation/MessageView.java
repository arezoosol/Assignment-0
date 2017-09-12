/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.presentation;

import boundry.messageFacade;
import entities.message;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Daniel
 */
@Named(value = "MessageView")
@RequestScoped
public class MessageView {
    private message message;
    
    public message getMessage(){
        return message;
    }
    
    public int getNumberOfMessages(){
        return messageFacade.findAll().size();
    }
    
    public String postMessage(){
        this.messageFacade.create(message);
        return "theend";
    }

    @EJB
    private messageFacade messageFacade;

    /**
     * Creates a new instance of MessageView
     */
    public MessageView() {
        this.message = new message();
    }
    
}

