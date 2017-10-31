/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javax.swing.JPanel;
import views.Texto;

/**
 *
 * @author User
 */
public class User {
    
    private int id;
    private String username;
    public Texto jpanel;

    public User(int id, String username,Texto jPanel) {
        this.id = id;
        this.username = username;
        this.jpanel=jPanel;
    }

    public JPanel getJpanel() {
        return jpanel;
    }

    public void setJpanel(Texto jpanel) {
        this.jpanel = jpanel;
    }

    
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }
    
    
    
}
