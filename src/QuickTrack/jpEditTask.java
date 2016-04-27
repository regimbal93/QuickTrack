/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuickTrack;

import java.awt.Window;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.json.JSONObject;

/**
 *
 * @author David Regimbal, Aras Masalaitis, Jesse Wasko, Sumedh Savanur, Gauri
 * Khawadkar <bk.psu.edu>
 */
public class jpEditTask extends javax.swing.JPanel {

    private int taskId; 
    /**
     * Creates new form jpEditTask
     */
    public jpEditTask(int id) {
        initComponents();
        taskId = id;
        
        txtTask.setText("Task ID " + id);
        
        try {
            setTask();
        } catch (ParseException ex) {
            Logger.getLogger(jpEditTask.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void setTask() throws ParseException
    {
        try {
            // Start by calling our server for task associated with this user
            JSONObject response = HTTPService.getTask(taskId);
            
            // Grab the response from our call
            JSONObject row = response.getJSONObject("response");
            
            txtName.setText(row.getString("name"));
            jtaTaskDescription.setText(row.getString("description"));
            
            java.util.Date date = new java.util.Date((long)Integer.parseInt(row.getString("duedate"))*1000);
            jdfTaskDueDate.setDate(date);
        
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

        btnGoBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaTaskDescription = new javax.swing.JTextArea();
        jlTaskDueDate = new javax.swing.JLabel();
        jdfTaskDueDate = new org.jdesktop.swingx.JXDatePicker();
        jlTaskName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jlTaskDescription = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        txtTask = new javax.swing.JLabel();

        btnGoBack.setText("Cancel");
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });

        jtaTaskDescription.setColumns(20);
        jtaTaskDescription.setRows(5);
        jScrollPane1.setViewportView(jtaTaskDescription);

        jlTaskDueDate.setText("Due Date ");

        jlTaskName.setText("Name");

        jlTaskDescription.setText("Description");

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        txtTask.setText("Task ID");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(214, Short.MAX_VALUE)
                .addComponent(btnUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGoBack)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(txtTask)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jlTaskName)
                        .addComponent(jlTaskDescription)
                        .addComponent(jlTaskDueDate))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jdfTaskDueDate, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(16, 16, 16)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(txtTask)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 239, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGoBack)
                    .addComponent(btnUpdate)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(50, 50, 50)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlTaskName))
                    .addGap(13, 13, 13)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addComponent(jlTaskDescription)))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jdfTaskDueDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlTaskDueDate))
                    .addContainerGap(91, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        // TODO add your handling code here:
        ((Window) getRootPane().getParent()).dispose();
    }//GEN-LAST:event_btnGoBackActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        
        try {

            // start by calling our server to add a task
            JSONObject response = HTTPService.editTask(taskId, txtName.getText(), jtaTaskDescription.getText(), jdfTaskDueDate.getDate());
            System.out.println("response = " + response);
            // Display a message and returns us home on success
            if("error".equals(response.getString("status")))
            {
                JFrame PopUp = new JFrame();
                JOptionPane.showMessageDialog(PopUp,"There was a problem updating this task. Try again!");               
            }
            else
            {
                // Update List Tasks
                jpListTasks.setTasks();
                jpGroups.setAssignments();
                
                // Let them know about it
                JFrame PopUp = new JFrame();
                JOptionPane.showMessageDialog(PopUp,"Task Updated");
                
                // Close the popup
                ((Window) getRootPane().getParent()).dispose();

            }
            
        } catch (IOException ex) {
            Logger.getLogger(jpCreateTask.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnUpdateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGoBack;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXDatePicker jdfTaskDueDate;
    private javax.swing.JLabel jlTaskDescription;
    private javax.swing.JLabel jlTaskDueDate;
    private javax.swing.JLabel jlTaskName;
    private javax.swing.JTextArea jtaTaskDescription;
    private javax.swing.JTextField txtName;
    private javax.swing.JLabel txtTask;
    // End of variables declaration//GEN-END:variables
}
