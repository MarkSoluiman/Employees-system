/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeessystem;

/**
 *
 * @author marka
 */

import java.io.*;
import javax.swing.*;
import java.util.*;

public class EditJob extends javax.swing.JFrame {

    /**
     * Creates new form EditJob
     */
    
     ArrayList<Job> jobs;
     ArrayList<Employee>employees;
    public EditJob() {
        initComponents();
        
        jobs=new ArrayList<>();
        employees=new ArrayList<>();
        populateJobsArrayList();
        populateEmployeesArrayList();
        saveEmployeesToFile();
        String [] jobsArrayString= new String[jobs.size()];
      
        //We populate the string array with the jobs names to use it in the 
        //jobs combobox
        for(int i=0;i <jobs.size();i++){
            jobsArrayString[i]=jobs.get(i).getName();
        }
        
        jobsCB.setModel(new javax.swing.DefaultComboBoxModel<>( jobsArrayString));
        
        //We do this if no jobs are found
        if(jobs.isEmpty()){
        jobsCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No jobs found to edit" }));
        Salary.setEditable(false);

        }
        else{
            jobsCB.setSelectedIndex(0);
        }
        
    }
    
    //Returns true if text contains numbers,false otherwise.
    
    public boolean containsNumbers(String s){
        return (s.matches(".*[0-9].*"));
    }
        
    //Returns true if text contains a positive number, false otherwise.
        
    public boolean isPositiveInteger(String s) {

    if (s == null) {
        return false;
    }
    int length = s.length();
    if (length == 0) {
        return false;
    }
    if (s.charAt(0) == '-') {
            return false;
    }
    for (int i = 0; i < length; i++) {
        char c = s.charAt(i);
        boolean isDigit = (c >= '0' && c <= '9');
        if (!isDigit) {
            return false;
        }
    }
    return true;
}
    
    //Reads every Employee from the employees.dat file and puts them into the
    // employees arraylist
    public void populateEmployeesArrayList(){
        try{
            FileInputStream file=new FileInputStream("employees.dat");
            ObjectInputStream inputFile=new ObjectInputStream(file);
            boolean endOfFile=false;
            
            //While the file didnt come to an end, we put each employee
            //in the file into the employees arraylist
            while(!endOfFile){
                try{
                    employees.add((Employee)(inputFile.readObject()));
                    
                }
                //When the file reaches an end, we set endOfFile to true
                catch(EOFException e){
                    endOfFile=true;
                }
                //To catch anything that can go wrong 
                catch(Exception f){
                JOptionPane.showMessageDialog(null, f.getMessage(),"Message",JOptionPane.ERROR_MESSAGE);

                }
            }
            inputFile.close();
            
        }
        catch(IOException e){
        JOptionPane.showMessageDialog(null, e.getMessage(),"Message",JOptionPane.ERROR_MESSAGE);

        }
    }
    
    //Reads every employee in the employees arraylist and writes them into the 
    //employees.dat file as employees objects
    public void saveEmployeesToFile(){
        try{
            FileOutputStream file=new FileOutputStream("employees.dat");
            ObjectOutputStream outputfile=new ObjectOutputStream(file);
            for(Employee employee:employees){
                outputfile.writeObject(employee);
            }
    
    }
        catch(IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"Message",JOptionPane.ERROR_MESSAGE);
        }
        
        
    }
    
     //Reads every Job from the jobs.dat file and puts them into the
    // jobs arraylist
    public void populateJobsArrayList(){
        try{
              FileInputStream file=new FileInputStream("jobs.dat");
              ObjectInputStream inputFile=new ObjectInputStream(file);
              
              boolean endOfFile=false;
              
              while(!endOfFile){
                  try{
                      jobs.add((Job)(inputFile.readObject()));
                  }
                  catch(EOFException e){
                      endOfFile=true;
                  }
                  catch(Exception f){
                      JOptionPane.showMessageDialog(null, f.getMessage());
                  }
              }

        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage(),"Message",JOptionPane.ERROR_MESSAGE);

        }
    }
    
    //Reads every job in the jobs arraylist and writes them into the 
    //jobs.dat file as jobs objects
    public void saveJobsToFile(){
        
        try{
             FileOutputStream file=new FileOutputStream("jobs.dat");
              ObjectOutputStream outputFile=new ObjectOutputStream(file); 
              
              for (Job job:jobs){
                  outputFile.writeObject(job);
              }
              outputFile.close();
        }
        
        catch(IOException e){
           JOptionPane.showMessageDialog(null, e.getMessage());

        }
       
       
        
    }
    
    public void setBlanckTextFields(){
        jobName.setText("");
        Salary.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jobsCB = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jobName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Salary = new javax.swing.JTextField();
        EditButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();

        jLabel4.setText("jLabel4");

        jTextField2.setText("jTextField2");

        jTextField3.setText("jTextField3");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Edit Job:");

        jLabel2.setText("Choose Job: ");

        jobsCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jobsCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jobsCBActionPerformed(evt);
            }
        });

        jLabel3.setText("Job name:");

        jobName.setEditable(false);
        jobName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jobNameActionPerformed(evt);
            }
        });

        jLabel5.setText("Job Salary:");

        EditButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/employeessystem/edit.png"))); // NOI18N
        EditButton.setText("Edit");
        EditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditButtonActionPerformed(evt);
            }
        });

        DeleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/employeessystem/exit.png"))); // NOI18N
        DeleteButton.setText("Delete");
        DeleteButton.setActionCommand("");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jobsCB, 0, 191, Short.MAX_VALUE)
                                    .addComponent(jobName)
                                    .addComponent(Salary)))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(EditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jobsCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jobName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(Salary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jobNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jobNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jobNameActionPerformed

    private void EditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditButtonActionPerformed
        // TODO add your handling code here:
        
        String jobSalary=Salary.getText().trim();
        //We check if the user has a valid input to edit the job
        if(!containsNumbers(jobSalary)|| !isPositiveInteger(jobSalary)){
            JOptionPane.showMessageDialog(null, "The job salary has to be only in positive numbers");
        }
        else{
         int index=jobsCB.getSelectedIndex();
        jobs.get(index).setSalary(Double.parseDouble(jobSalary));
        saveJobsToFile();
        
        JOptionPane.showMessageDialog(null, "Job edited successfully !");
        setBlanckTextFields();
        }
        
      
        
        
        
        
        
    }//GEN-LAST:event_EditButtonActionPerformed

    private void jobsCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jobsCBActionPerformed
        // TODO add your handling code here:
        try{
         int intdex= jobsCB.getSelectedIndex();
        
        Salary.setText(jobs.get(intdex).getSalary()+"");
        jobName.setText(jobs.get(intdex).getName());
        }
        catch(IndexOutOfBoundsException e){
         
           JOptionPane.showMessageDialog(null, "Job not found","Message",JOptionPane.ERROR_MESSAGE);
           setBlanckTextFields();
        }
  
        
        
        
        
    }//GEN-LAST:event_jobsCBActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        // TODO add your handling code here:
        
        
        boolean takenJob=false;
        int index=jobsCB.getSelectedIndex();
        //We check if the job that was chosen to be deleted is already taken by
        //one of the employees or not
        for(Employee employee:employees){
            if(jobs.get(index).getName().equalsIgnoreCase(employee.getJob().getName()))
            {
            takenJob=true;
            break;
            }
        }
        //We show a warning message that the job chosen to be deleted is taken
        // by an employee
        if(takenJob){
            JOptionPane.showMessageDialog(null, "Job is taken by one or more employees");
            
        }
        //if the job was not taken by an employee, we delete the job
        else{
        jobs.remove(index);
        saveJobsToFile();
        
       JOptionPane.showMessageDialog(null, "Job deleted successfully !");
       setBlanckTextFields();
       
       this.dispose();
        }
        
  

        
    }//GEN-LAST:event_DeleteButtonActionPerformed

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
            java.util.logging.Logger.getLogger(EditJob.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditJob.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditJob.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditJob.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               new EditJob().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton EditButton;
    private javax.swing.JTextField Salary;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jobName;
    private javax.swing.JComboBox<String> jobsCB;
    // End of variables declaration//GEN-END:variables
}
