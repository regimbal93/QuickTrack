/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuickTrack;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.apache.commons.lang3.time.DateUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author jrw367
 */
public class Calendars extends javax.swing.JFrame {

    JSONArray tasks;

    
    DefaultListModel taskList = new DefaultListModel();
    
    public Calendars() {

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Calendars.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Calendars.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Calendars.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Calendars.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        initComponents();
        
    }
    
    
    
    private JSONArray getTasks()
    {
        try
        {
            return HTTPService.getTasks().getJSONArray("response");
        } catch (IOException ex) {

            // Fatal error; The program could not render/compile
            Logger.getLogger(jpOverview.class.getName()).log(Level.SEVERE, null, ex);

        }
        
        return null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Cal = new com.toedter.calendar.JCalendar();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 153, 153));

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        Cal.setWeekOfYearVisible(false);
        Cal.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                CalPropertyChange(evt);
            }
        });

        jScrollPane1.setViewportView(jList1);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jButton1.setText("VIEW");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Details:");

        jLabel1.setText("Tasks:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(325, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Cal, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jButton1))
                        .addGap(77, 77, 77))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(71, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Cal, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CalPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_CalPropertyChange
        // TODO add your handling code here:
      //  String test = Cal.getDate().toString();
        //        System.out.println(test);
        taskList.removeAllElements();
        jTextArea1.setText(null);
        Date date = Cal.getDate();
       // java.sql.Date sqlDate = Cal.getDate();
       //System.out.println("CalDate = " + date);
       Date truncatedDate = DateUtils.truncate(date, Calendar.DATE);
      //  System.out.println("Truncated date = " + truncatedDate);
       
        long time = truncatedDate.getTime()/1000;
     //   System.out.println("" + time);
        changeList(time);
        
    }//GEN-LAST:event_CalPropertyChange

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        jTextArea1.setText(null);
        String choice = jList1.getSelectedValue().toString();
        if("Project Proposal".equals(choice))
        {
            jTextArea1.append("A group proposal for our project");
        }
        else if("Initial Design".equals(choice))
        {
            jTextArea1.append("The initial design for the project");
        }
        else if("System, Users, Tasks".equals(choice))
        {
            jTextArea1.append("Characteristics of the system, users, and tasks");
        }
        if("UML Diagrams".equals(choice))
        {
            jTextArea1.append("We need to make UML diagram of our system");
        }
        if("Revised Design".equals(choice))
        {
            jTextArea1.append("An updated to our design based on feedback.");
        }
        if("Final Document".equals(choice))
        {
            jTextArea1.append("The final document is a combination of the other docs");
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * This method will compare the value of the time parameter to the due date value of a task.
     * Then it will update the listModel to show the tasks for that date.
     * For demonstration purposes, values have been hard coded in.
     * @param selectedTime
     */
    public void changeList(long selectedTime)
    {

        tasks = getTasks();
        System.out.println("tasks = " + tasks);
        
        for(int i = 0; i < tasks.length(); i++)
        {
            JSONObject element = tasks.getJSONObject(i);
           
            Date now = new Date(selectedTime*1000L); 
            Date duedate = new Date(Integer.parseInt(element.getString("duedate"))*1000L); 
            
            SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");

            if(  fmt.format(now).equals(fmt.format(duedate))  )
            {
                System.out.println("Found tasks for this day!");
                taskList.addElement(element.getString("name"));
              
            }
            
        }
        
        jList1.setModel(taskList);  

        /*
        if (selectedTime == 1462334400)  // wednesday may 4th
        {
            taskList.addElement("Project Proposal");
            taskList.addElement("Initial Design");
            jList1.setModel(taskList);      
        }
        else if (selectedTime == 1463112000)  // friday may 13th
        {
            taskList.addElement("System, Users, Tasks");
            taskList.addElement("UML Diagrams");
            jList1.setModel(taskList);      
        }
        else if (selectedTime == 1464753600)  // wednesday june 1st
        {
            taskList.addElement("Revised Design");
            taskList.addElement("Final Document");
            jList1.setModel(taskList);      
        }
        */
        
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
            java.util.logging.Logger.getLogger(Calendars.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Calendars.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Calendars.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Calendars.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Calendars().setVisible(true);
                
                
                
            }
        });
        
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static com.toedter.calendar.JCalendar Cal;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
