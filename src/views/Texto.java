/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Label;
import javafx.scene.paint.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.Border;
import sun.awt.image.PixelConverter;

/**
 *
 * @author User
 */
public class Texto extends javax.swing.JPanel {

    

    
    int contador;
    GridLayout grid;
    public Texto() {
        initComponents();
         
          grid=new GridLayout(0, 2, 2, 2);
        
        jPanel1.setLayout(grid);

    }
    
    public void agregarRecibido(String texto){
         this.jPanel1.add(new JLabel(""));
         JButton temp=new JButton(texto);
         
        
         temp.setBackground(java.awt.Color.red);
        this.jPanel1.add(temp);
       
        this.grid.setRows(this.grid.getRows()+1);
        this.jPanel1.revalidate();
        this.jPanel1.repaint();
     
    }
    public void AgregarEnviado(String texto){
         
       JButton temp=new JButton(texto);
       temp.setSize(100,20);
       temp.setBorder(null);
        this.jPanel1.add(temp);
         this.jPanel1.add(new JLabel(""));
 this.grid.setRows(this.grid.getRows()+1);
        this.jPanel1.revalidate();
        this.jPanel1.repaint();
        
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();

        jLabel1.setText("jLabel1");

        setBackground(new java.awt.Color(210, 200, 250));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel1.setBackground(new java.awt.Color(51, 255, 204));
        jPanel1.setMaximumSize(new java.awt.Dimension(253, 32767));
        jPanel1.setLayout(new java.awt.GridLayout());
        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        
        JLabel lbl=new JLabel("carlos mario");
        
       
        
        this.revalidate();
        this.repaint();
    }//GEN-LAST:event_formMouseClicked

  

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
