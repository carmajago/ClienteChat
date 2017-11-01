/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.LinkedList;
import java.util.List;
import javax.swing.JPanel;
import views.Texto;


public class User {
    
    private int id;
    private String username;
    public Texto jpanel;

    LinkedList<Mensaje> mensajes;
    
    public User(int id, String username,Texto jPanel) {
        this.id = id;
        this.username = username;
        this.jpanel=jPanel;
        mensajes=new LinkedList<Mensaje>();
    }

    public JPanel getJpanel() {
        return jpanel;
    }

    public void setJpanel(Texto jpanel) {
        this.jpanel = jpanel;
    }

    public LinkedList<Mensaje> getMensajes() {
        return mensajes;
    }

    public void addMensaje(Mensaje m){
       
        mensajes.add(m);
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
