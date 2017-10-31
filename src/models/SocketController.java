/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class SocketController {
    
    int port;
    String host;
    private Socket thesocket = null;
    private PrintWriter out = null;
    private BufferedReader in = null;

    public SocketController(int port, String host) {
        this.port = port;
        this.host = host;
        
    }
    
       public void Open() {    
        try {
            this.thesocket = new Socket(this.host, this.port);
            this.out = new PrintWriter(this.thesocket.getOutputStream(), true);
            this.in = new BufferedReader(new InputStreamReader(
                    this.thesocket.getInputStream(), "UTF-8"));
        } catch (IOException ex) {
            Logger.getLogger(SocketController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Close() {
        try {
            this.out.close();
            this.in.close();
        } catch (IOException ex) {
            Logger.getLogger(SocketController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        public void WriteText(String text) {
        this.out.println(text);
    }

    public String ReadText() {
        try {
            return this.in.readLine();
        } catch (IOException ex) {
            Logger.getLogger(SocketController.class.getName()).log(Level.SEVERE, null, ex);

        }
        return null;
    }


    
    
    
}
