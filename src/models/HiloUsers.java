/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class HiloUsers implements Runnable{

   SocketController socket;

    public HiloUsers(SocketController socket) {
        this.socket = socket;
    }
   
   
    
    @Override
    public void run() {
        while(true){
            try {
                socket.WriteText("getusers");
                socket.WriteText("numofusers");
                Thread.sleep(2000);
                
                
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloUsers.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
