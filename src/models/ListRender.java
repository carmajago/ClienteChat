/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.awt.Component;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author User
 */
public class ListRender extends JLabel implements ListCellRenderer{

    public final Image imagen=new ImageIcon(getClass().getResource("../Images/icons8_customer_32px_1.png")).getImage();
    public  final ImageIcon icon=new ImageIcon(imagen);
    
    @Override
    public Component getListCellRendererComponent(JList jlist, Object e, int i, boolean isSelected, boolean bln1) {
 String valor=e.toString();
        setText(valor);
 if(!valor.equals("")){
     setIcon(icon);
 }
 if(isSelected){
     setBackground(jlist.getBackground());
     setForeground(jlist.getForeground());
     
 }else{
     setEnabled(jlist.isEnabled());
     setFont(jlist.getFont());
     setOpaque(true);
 }
    return  this;
    }
    
}
