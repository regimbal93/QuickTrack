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
        label5 = new java.awt.Label();

        setBackground(new java.awt.Color(0, 153, 153));

        btnGoBack.setBackground(new java.awt.Color(51, 51, 51));
        btnGoBack.setForeground(new java.awt.Color(204, 204, 204));
        btnGoBack.setText("Cancel");
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });

        jtaTaskDescription.setColumns(20);
        jtaTaskDescription.setRows(5);
        jScrollPane1.setViewportView(jtaTaskDescription);

        jlTaskDueDate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlTaskDueDate.setText("Due Date ");

        jlTaskName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlTaskName.setText("Name");

        jlTaskDescription.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlTaskDescription.setText("Description");

        btnUpdate.setBackground(new java.awt.Color(51, 51, 51));
        btnUpdate.setForeground(new java.awt.Color(204, 204, 204));
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        txtTask.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTask.setText("Task ID");

        label5.setFont(new java.awt.Font("Modern No. 20", 0, 36)); // NOI18N
        label5.setText("Quick Track");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(117, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlTaskDueDate)
                            .addComponent(jlTaskDescription)
                            .addComponent(jlTaskName))
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(btnUpdate)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnGoBack)
                                    .addContainerGap())
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jdfTaskDueDate, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(62, 62, 62)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtTask)
                        .addGap(153, 153, 153))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(182, 182, 182))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(txtTask)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlTaskName))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jdfTaskDueDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlTaskDueDate))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnUpdate)
                            .addComponent(btnGoBack)))
                    .addComponent(jlTaskDescription))
                .addContainerGap())
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
    private java.awt.Label label5;
    private javax.swing.JTextField txtName;
    private javax.swing.JLabel txtTask;
    // End of variables declaration//GEN-END:variables
}