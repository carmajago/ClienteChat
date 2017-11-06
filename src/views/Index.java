/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import com.sun.management.jmx.Trace;
import java.awt.BorderLayout;
import java.awt.List;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.LinkedList;
import java.util.Optional;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.ListCellRenderer;
import javax.swing.border.Border;
import models.HiloUsers;
import models.ListRender;
import models.Mensaje;
import models.Respuestas;
import models.SocketController;
import models.User;

/**
 *
 * @author User
 */
public class Index extends javax.swing.JFrame implements Runnable{

    DefaultListModel modelolista;
    SocketController socket;
    Thread hilo;
    LinkedList<User> users;
    String myuser;
    int contador_users;
     LinkedList<UserView> listaUserView; 
     User msgViewtemp;
     
     UserView userViewActico;
    public Index() {
        listaUserView=new LinkedList<>();
        initComponents();
        users=new LinkedList<User>();
        modelolista=new DefaultListModel(); 
        setSize(669, 575);
        setResizable(false);
        contador_users=0;
        agregarValores("$todos");
        this.users.add(new User(Integer.parseInt("000"),"",new Texto()));
        cerrar();
        
//        JScrollBar sb = this.jScrollPane1.getVerticalScrollBar();
//        sb.setUI(new MyScrollbarUI());
        
    }
    
    //Agrega jpanel con la informacion del ususrio conectado
    public void agregarValores(String user){
       
       UserView view= new UserView();
       view.setSize(260, 65);
       view.setLocation(0,contador_users);
       
       if(!user.equals("$todos"))
       view.setUser(user);
       else{
           view.setUser("");
           view.setunserText("Todos");
       }
       view.setIndex(this);
       this.contador_users+=65;
      this.jPanel4.add(view);
       
      
       this.jPanel4.revalidate();
       this.jPanel4.repaint();
       
       this.listaUserView.add(view);
    }
    
    public void toogleListUserView(UserView view){
        
        for(UserView item:listaUserView){
            item.Desactivar();
        }
        view.Activar();
        userViewActico=view;
    }
    


    public void setSocket(SocketController socket) {
        this.socket = socket;
        this.hilo=new Thread(this);
        this.hilo.start();
        HiloUsers hilouser=new HiloUsers(socket);
        Thread hilo2=new Thread(hilouser);
        hilo2.start();
        
    }

    public String getMyuser() {
        return myuser;
    }

    public void setMyuser(String myuser) {
        this.myuser = myuser;
    }
    
    
    public void addUserList(String cadena){
        
        String vector[]=cadena.split(";");
        boolean bandera=false;
        for (int i = 0; i < vector.length; i++) {
            bandera=false;
            String id_temp[]=vector[i].split(" ");
            if(!myuser.toUpperCase().equals(id_temp[1].toUpperCase())){
            for (User item :this.users){
                if(item.getId()==Integer.parseInt(id_temp[0])){
                    bandera=true;
                }
            }
            if(!bandera){
            this.users.add(new User(Integer.parseInt(id_temp[0]),id_temp[1],new Texto()));
            agregarValores(id_temp[1]);
            }
            }
            }
    }
    //Cambioa el jpanel de cada chat 
    public void cambiarChat(String username){
        
        for(User item: users){
            if(item.getUsername().toUpperCase().equals(username.toUpperCase())){
                 
            item.jpanel.setSize(this.mainPanel.getWidth(),this.mainPanel.getHeight());
            item.jpanel.setVisible(true);
             item.jpanel.setLocation(0,0);
        
            this.mainPanel.removeAll();
            this.mainPanel.add(item.jpanel);
            this.mainPanel.revalidate();
            this.mainPanel.repaint();
            this.Actual.setText(username);
            }
        }
    }
    public void send(){
        
         String salida=this.entrydata.getText();
         
        if(!salida.equals("")){
        
             
             
             //temporal-----------------------------------
           if(userViewActico!=null){
            
           for (User item:users) {
            if(item.getUsername().toUpperCase().equals(this.userViewActico.getUser().trim().toUpperCase())){
               
                if(!userViewActico.getUser().equals("")){
                this.socket.WriteText("send "+item.getUsername()+" "+salida);
                
                }else{
                    this.socket.WriteText("sendall "+salida);
                   
                
                }
                 
                  
                       msgViewtemp=item;
                 
            }
                }
          
              
            
       }
        }
    }
    public void confirmarSalida(){
        
        int valor=JOptionPane.showConfirmDialog(this,"Esta seguro de salir","Adventencia",JOptionPane.YES_NO_OPTION);
            
        if(valor==JOptionPane.YES_OPTION){
            socket.WriteText("QUIT");
            System.exit(0);
        }else{
            
        }
    }
    
    public void cerrar(){
        try {
            this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e){
                    confirmarSalida();
                }
});
            this.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        panelEntry = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        entrydata = new javax.swing.JTextField();
        btnsend = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        Actual = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        numusers = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setAlignmentX(0.0F);
        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 273, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 498, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel4);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(0, 57, 275, 490);

        jPanel2.setBackground(new java.awt.Color(97, 152, 190));
        jPanel2.setAlignmentX(0.0F);
        jPanel2.setLayout(null);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/emoticon.png"))); // NOI18N

        entrydata.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        entrydata.setText("Escribe un mensaje");
        entrydata.setBorder(null);
        entrydata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrydataActionPerformed(evt);
            }
        });
        entrydata.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                entrydataKeyPressed(evt);
            }
        });

        btnsend.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/send.png"))); // NOI18N
        btnsend.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnsendMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelEntryLayout = new javax.swing.GroupLayout(panelEntry);
        panelEntry.setLayout(panelEntryLayout);
        panelEntryLayout.setHorizontalGroup(
            panelEntryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEntryLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(entrydata, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnsend)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        panelEntryLayout.setVerticalGroup(
            panelEntryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEntryLayout.createSequentialGroup()
                .addGroup(panelEntryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(entrydata, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(btnsend, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14, 14, 14))
        );

        jPanel2.add(panelEntry);
        panelEntry.setBounds(0, 496, 400, 60);

        jPanel5.setBackground(new java.awt.Color(242, 240, 240));

        Actual.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(Actual, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(183, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Actual, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel5);
        jPanel5.setBounds(0, 0, 390, 60);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );

        jPanel2.add(mainPanel);
        mainPanel.setBounds(0, 50, 390, 450);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(279, 0, 390, 554);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Username");

        numusers.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        numusers.setText("Usuarios activos:0");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jSeparator2)
                .addGap(31, 31, 31))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(numusers))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 164, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(numusers))
                    .addComponent(jSeparator1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel6);
        jPanel6.setBounds(0, 0, 280, 60);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void entrydataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrydataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_entrydataActionPerformed

    private void btnsendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsendMouseClicked
        
        send();
    
    }//GEN-LAST:event_btnsendMouseClicked

    private void entrydataKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_entrydataKeyPressed
        
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            send();
        }
    }//GEN-LAST:event_entrydataKeyPressed

    public void mensajeNuevo(String id,String mensaje){
        
        User temp=buscarUser(Integer.parseInt(id.substring(0,3)));
        System.out.println(Integer.parseInt(id.substring(0,3)));
        if(temp!=null){
            MensajeView aux=temp.jpanel.AgregarEntrante(mensaje,id);
            aux.setIndex(this);
            temp.addMensaje(aux);
        }
        
    }
    
    public void removeMsg(String id){
        User temp=buscarUser(Integer.parseInt(id.substring(0,3)));
        
        temp.eliminarMsg(id);
        
        
    }
    
    public User buscarUser(int id){
        
        for(User item: users){
            System.out.println(item.getId()+"......"+id);
            if(item.getId()==id){
                
                return item;
                
            }
        }
        return null;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Index().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Actual;
    private javax.swing.JLabel btnsend;
    private javax.swing.JTextField entrydata;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel numusers;
    private javax.swing.JPanel panelEntry;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
 
    while(true){
        String llegada=socket.ReadText();
        String temp[]=llegada.split(" ");
    
        if(temp.length>1 && temp[0].length()==17){
           
            mensajeNuevo(temp[0],llegada.substring(18));
                        
        }else{
        
        String response=llegada.substring(0,3);
        
        if(Respuestas.geUsers(response)){
            addUserList(llegada.substring(4));
        
        }else if(Respuestas.isMsg(response)){
            String salida=this.entrydata.getText();
            MensajeView aux=msgViewtemp.jpanel.AgregarSaliente(salida,llegada.substring(4));
            aux.setIndex(this);
           msgViewtemp.addMensaje(aux);
            this.entrydata.setText("");
        }else if(llegada.startsWith("REMOVEMSG")){
            System.out.println("remove msg");
            removeMsg(llegada.substring(10).trim());
        }else if(Respuestas.numerouser(response)){
            this.numusers.setText("Usuarios activos: "+(Integer.parseInt(llegada.substring(4).trim())-1));
        }
        else
            System.out.println(llegada);
        
        }
    }
    }
}
