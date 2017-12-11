/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diazadvjavaproject5;

import javax.swing.JFrame;

/**
 *
 * @author Dave
 */
public class DiazADVJavaProject5 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        
       GUI myGUI = new GUI();
       myGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       myGUI.setResizable(false);
       myGUI.setSize(850, 775);
       myGUI.setVisible(true);
    }
    
    
}
