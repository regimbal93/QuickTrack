/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuickTrack;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author David Regimbal, Aras Masalaitis, Jesse Wasko, Sumedh Savanur, Gauri
 * Khawadkar <bk.psu.edu>
 */
public class jpGroups extends javax.swing.JPanel {

    /**
     * Creates new form jpGroups
     */
    public jpGroups() {
        initComponents();
    }
    
    public static void setAssignments()
    {
        
        try {

            // Start by calling our server for tasks associated with this user
            JSONObject response = HTTPService.getGroupTasks();
            
            // Grab the response from our call
            JSONArray rows = response.getJSONArray("response");
            
            // Init our JTable for later
            DefaultTableModel model = (DefaultTableModel) jtAssignments.getModel();
            
            // Reset the JTable in case we are back a second time
            model.setColumnCount(0);
            model.setRowCount(0);

            // Declare column headers
            model.addColumn("id");
            model.addColumn("name");
            model.addColumn("description");
            model.addColumn("duedate");
            model.addColumn("notify");
            model.addColumn("");

            // Iterate over our response and add rows
            for(int i = 0; i < rows.length(); i++)
            {
                JSONObject element = rows.getJSONObject(i);
                model.addRow(new Object[] { element.getString("id"), element.getString("name"), element.getString("description"), element.getString("duedate"), element.getString("notify"), "edit"  });
            }

            // Declare our edit action for our JButton
            Action edit = new AbstractAction()
            {
                public void actionPerformed(ActionEvent e)
                {
                    
                    JTable table = (JTable)e.getSource();
                    int modelRow = Integer.valueOf( e.getActionCommand() );
                    // This holds the id to this task
                    int id = Integer.parseInt(table.getModel().getValueAt(modelRow, 0).toString());
             
                    // Do something here like show a popup for edit task
                    
                    
                }


            };

            // Bind our action to the 5th column 
            ButtonColumn buttonColumn = new ButtonColumn(jtAssignments, edit, 5);
            buttonColumn.setMnemonic(KeyEvent.VK_D);


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

        jDatePickerUtil1 = new net.sourceforge.jdatepicker.util.JDatePickerUtil();
        btnGoBack = new javax.swing.JButton();
        btnJoinGroup = new javax.swing.JButton();
        btnManageGroups = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtAssignments = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnCreateGroup = new javax.swing.JButton();

        btnGoBack.setText("Go Back");
        btnGoBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoBackActionPerformed(evt);
            }
        });

        btnJoinGroup.setText("Join");
        btnJoinGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJoinGroupActionPerformed(evt);
            }
        });

        btnManageGroups.setText("Manage");
        btnManageGroups.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageGroupsActionPerformed(evt);
            }
        });

        jtAssignments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtAssignments);

        jLabel1.setText("Group Assignments");

        btnCreateGroup.setText("Create");
        btnCreateGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateGroupActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnManageGroups)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCreateGroup)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnJoinGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGoBack)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGoBack)
                    .addComponent(btnJoinGroup)
                    .addComponent(btnManageGroups)
                    .addComponent(btnCreateGroup)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGoBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoBackActionPerformed
        // Switch the panel
        Container parent = this.getParent(); 
        LayoutManager layout = getParent().getLayout();
        if (layout instanceof CardLayout) {
            CardLayout cardLayout = (CardLayout)layout;
            cardLayout.show(parent, "jpOverview");
        }
    }//GEN-LAST:event_btnGoBackActionPerformed

    private void btnJoinGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJoinGroupActionPerformed
        // Switch the panel
        Container parent = this.getParent(); 
        LayoutManager layout = getParent().getLayout();
        if (layout instanceof CardLayout) {
            CardLayout cardLayout = (CardLayout)layout;
            cardLayout.show(parent, "jpJoinGroup");
        }
    }//GEN-LAST:event_btnJoinGroupActionPerformed

    private void btnManageGroupsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageGroupsActionPerformed
        jpManageGroups.setGroups();
        // Switch the panel
        Container parent = this.getParent(); 
        LayoutManager layout = getParent().getLayout();
        if (layout instanceof CardLayout) {
            CardLayout cardLayout = (CardLayout)layout;
            cardLayout.show(parent, "jpManageGroups");
        }
    }//GEN-LAST:event_btnManageGroupsActionPerformed

    private void btnCreateGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateGroupActionPerformed
        // Switch the panel
        Container parent = this.getParent(); 
        LayoutManager layout = getParent().getLayout();
        if (layout instanceof CardLayout) {
            CardLayout cardLayout = (CardLayout)layout;
            cardLayout.show(parent, "jpCreateGroup");
        }
    }//GEN-LAST:event_btnCreateGroupActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateGroup;
    private javax.swing.JButton btnGoBack;
    private javax.swing.JButton btnJoinGroup;
    private javax.swing.JButton btnManageGroups;
    private net.sourceforge.jdatepicker.util.JDatePickerUtil jDatePickerUtil1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTable jtAssignments;
    // End of variables declaration//GEN-END:variables
}
