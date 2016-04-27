/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuickTrack;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.LayoutManager;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;

/**
 *
 * @author David Regimbal, Aras Masalaitis, Jesse Wasko, Sumedh Savanur, Gauri
 * Khawadkar <bk.psu.edu>
 */
public class jpOverview extends javax.swing.JPanel {
    
    public static JSONObject aboutme;

    /**
     * Creates new form jpOverview
     */
    public jpOverview() 
    {
        initComponents();
    }
    
    /**
     * getAboutMe.
     * This will get basic details about the user and create a nice
     * welcome message in the overview panel
     */
    public static void getAboutMe()
    {
        
        try {
            
            // Call our HTTP Service
            JSONObject response = new HTTPService().getDetails();
            
            // Assign to a local variable
            aboutme = response.getJSONObject("response");
            
            // Greet the user!
            lblWelcomeMessage.setText("Welcome back, " + aboutme.getString("email") + "!");
            
        } catch (IOException ex) {
            
            // Fatal error; The program could not render/compile
            Logger.getLogger(jpOverview.class.getName()).log(Level.SEVERE, null, ex);
            
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

        lblWelcomeMessage = new javax.swing.JLabel();
        btnAddTask = new javax.swing.JButton();
        btnListTasks = new javax.swing.JButton();
        btnGroups = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

        lblWelcomeMessage.setText("Welcome back!");

        btnAddTask.setText("Add Task");
        btnAddTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddTaskActionPerformed(evt);
            }
        });

        btnListTasks.setText("List Tasks");
        btnListTasks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListTasksActionPerformed(evt);
            }
        });

        btnGroups.setText("Groups");
        btnGroups.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGroupsActionPerformed(evt);
            }
        });

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblWelcomeMessage)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGroups)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnListTasks, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddTask)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExit)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblWelcomeMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 234, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddTask)
                    .addComponent(btnListTasks)
                    .addComponent(btnGroups)
                    .addComponent(btnExit))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddTaskActionPerformed

        jpCreateTask.setjcbGroups();
        // Switch the panel to jpOverview
        Container parent = this.getParent(); 
        LayoutManager layout = getParent().getLayout();
        if (layout instanceof CardLayout) {
            CardLayout cardLayout = (CardLayout)layout;
            cardLayout.show(parent, "jpCreateTask");
        }
    }//GEN-LAST:event_btnAddTaskActionPerformed

    private void btnListTasksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListTasksActionPerformed

        jpListTasks.setTasks();
        
        // Switch the panel to jpOverview
        Container parent = this.getParent(); 
        LayoutManager layout = getParent().getLayout();
        if (layout instanceof CardLayout) {
            CardLayout cardLayout = (CardLayout)layout;
            cardLayout.show(parent, "jpListTasks");
        }
    }//GEN-LAST:event_btnListTasksActionPerformed

    private void btnGroupsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGroupsActionPerformed
        
        jpGroups.setAssignments();

        // Switch the panel
        Container parent = this.getParent(); 
        LayoutManager layout = getParent().getLayout();
        if (layout instanceof CardLayout) {
            CardLayout cardLayout = (CardLayout)layout;
            cardLayout.show(parent, "jpGroups");
        }
    }//GEN-LAST:event_btnGroupsActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddTask;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnGroups;
    private javax.swing.JButton btnListTasks;
    private static javax.swing.JLabel lblWelcomeMessage;
    // End of variables declaration//GEN-END:variables
}
