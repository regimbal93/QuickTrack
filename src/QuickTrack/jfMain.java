/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuickTrack;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.*;


import QuickTrack.jpRegister;
import java.awt.CardLayout;
import javax.xml.ws.Action;

/**
 *
 * @author David Regimbal, Aras Masalaitis, Jesse Wasko, Sumedh Savanur, Gauri
 * Khawadkar <bk.psu.edu>
 */
public class jfMain extends javax.swing.JFrame {

    //LocalStorage storage = new LocalStorage();
    
    /**
     * Creates new form jfMain
     */
    public jfMain() {
        initComponents();
        checkLogin();
    }
    
    private void checkLogin()
    {
        /*
        String access_token = HTTPService.storage.get("access_token");
        
        if(!access_token.isEmpty())
        {
   
            System.out.println("User already logged in!");
            System.out.println(access_token);

            CardLayout cl = (CardLayout) jpMain.getLayout();
            cl.show(jpMain, "jpOverview");
        }
        */
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpMain = new javax.swing.JPanel();
        jpLogin = new QuickTrack.jpLogin();
        jpRegister = new QuickTrack.jpRegister();
        jpCreateTask = new QuickTrack.jpCreateTask();
        jpOverview = new QuickTrack.jpOverview();
        jpListTasks = new QuickTrack.jpListTasks();
        jpGroups = new QuickTrack.jpGroups();
        jpJoinGroup = new QuickTrack.jpJoinGroup();
        jpManageGroups = new QuickTrack.jpManageGroups();
        jpCreateGroup = new QuickTrack.jpCreateGroup();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpMain.setLayout(new java.awt.CardLayout());
        jpMain.add(jpLogin, "jpLogin");
        jpMain.add(jpRegister, "jpRegister");
        jpMain.add(jpCreateTask, "jpCreateTask");
        jpMain.add(jpOverview, "jpOverview");
        jpMain.add(jpListTasks, "jpListTasks");
        jpMain.add(jpGroups, "jpGroups");
        jpMain.add(jpJoinGroup, "jpJoinGroup");
        jpMain.add(jpManageGroups, "jpManageGroups");
        jpMain.add(jpCreateGroup, "jpCreateGroup");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpMain, javax.swing.GroupLayout.PREFERRED_SIZE, 463, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpMain, javax.swing.GroupLayout.PREFERRED_SIZE, 292, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(jfMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jfMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jfMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jfMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jfMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private QuickTrack.jpCreateGroup jpCreateGroup;
    private QuickTrack.jpCreateTask jpCreateTask;
    private QuickTrack.jpGroups jpGroups;
    private QuickTrack.jpJoinGroup jpJoinGroup;
    private QuickTrack.jpListTasks jpListTasks;
    private QuickTrack.jpLogin jpLogin;
    private javax.swing.JPanel jpMain;
    private QuickTrack.jpManageGroups jpManageGroups;
    private QuickTrack.jpOverview jpOverview;
    private QuickTrack.jpRegister jpRegister;
    // End of variables declaration//GEN-END:variables
}
