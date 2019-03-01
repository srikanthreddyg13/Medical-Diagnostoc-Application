/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.SignUpScreenLoginScreen;

import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.Organization.PatientOrganization;
import Business.PatientAccount.PatientAccount;
import Business.PatientAccount.PatientAccountDirectory;
import Business.PatientAccount.SendEmail;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Vishaka
 */
public class SignUpPanel extends javax.swing.JPanel {

    /**
     * Creates new form SignUpPanel
     */
    private Enterprise enterprise;
    private JPanel userProcessContainer;

    public SignUpPanel(JPanel userProcessContainer, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        populateOrganizationComboBox();
        popData();
    }
    
    private void errorNotify() {
        this.userName.setForeground(Color.RED);
        this.password.setForeground(Color.RED);
        this.patientName.setForeground((Color.RED));
        this.emailName.setForeground(Color.RED);
        this.phoneNumber.setForeground(Color.RED);
    }
    private void updateNotify() {
        this.userName.setForeground(Color.BLACK);
        this.password.setForeground(Color.BLACK);
        this.patientName.setForeground((Color.BLACK));
        this.emailName.setForeground(Color.BLACK);
        this.phoneNumber.setForeground(Color.BLACK);
        
    }
    private boolean passwordPatternCorrect()
    {
        Pattern p = Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$");
        Matcher m = p.matcher(passwordJTextfield.getText());
        boolean b = m.matches();
        //boolean b = m.find();
        if(b==true)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    private boolean usernamePatternCorrect()
    {
        Pattern p = Pattern.compile("^[a-zA-Z0-9]([._](?![._])|[a-zA-Z0-9]){6,18}[a-zA-Z0-9]$");
        Matcher m = p.matcher(userNameTextField.getText());
        boolean b = m.matches();
        //boolean b = m.find();
        if(b==true)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    private boolean emailPatternCorrect()
    {
        Pattern p = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
        Matcher m = p.matcher(emailIDTextField.getText());
        boolean b = m.matches();
        //boolean b = m.find();
        if(b==true)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    private boolean phonePatternCorrect()
    {
        Pattern p = Pattern.compile("^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]\\d{3}[\\s.-]\\d{4}$");
        Matcher m = p.matcher(phoneNumberTextField.getText());
        boolean b = m.matches();
        //boolean b = m.find();
        if(b==true)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    
    
    public void popData() {

        DefaultTableModel model = (DefaultTableModel) userJTable.getModel();

        model.setRowCount(0);

        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (organization instanceof PatientOrganization){
                for (UserAccount ua : organization.getUserAccountDirectory().getUserAccountList()) {
                     Object row[] = new Object[4];
                     row[0] = ua;
                     row[1] = ua.getRole();
                     row[2] = ua.getPatientAccount();
                     row[3] = ua.getPatientAccount().getPatientEmail();
                     ((DefaultTableModel) userJTable.getModel()).addRow(row);
                 }
            }
        }
    }

    public void populateOrganizationComboBox(){
        organizationEmpJComboBox.removeAllItems();
        //Organization org = null;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (organization instanceof PatientOrganization)
                //org = organization;
                organizationEmpJComboBox.addItem(organization);
                populateRoleComboBox(organization);
        }
    }
    
    private void populateRoleComboBox(Organization organization){
        roleJComboBox.removeAllItems();
        //Organization org = (Organization) organizationEmpJComboBox.getSelectedItem();
        for (Role role : organization.getSupportedRole()){
            roleJComboBox.addItem(role);
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

        jPanel1 = new javax.swing.JPanel();
        patientName = new javax.swing.JLabel();
        emailName = new javax.swing.JLabel();
        phoneNumber = new javax.swing.JLabel();
        password = new javax.swing.JLabel();
        patientNameTextField = new javax.swing.JTextField();
        emailIDTextField = new javax.swing.JTextField();
        phoneNumberTextField = new javax.swing.JTextField();
        userNameTextField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        organizationEmpJComboBox = new javax.swing.JComboBox();
        roleJComboBox = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        userName = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        userJTable = new javax.swing.JTable();
        backJButton = new javax.swing.JButton();
        passwordJTextfield = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        patientName.setText("Patient Name:");

        emailName.setText("Email ID :");

        phoneNumber.setText("Phone Number :");

        password.setText("Password");

        patientNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patientNameTextFieldActionPerformed(evt);
            }
        });

        userNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameTextFieldActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Sign me up!");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setText("Organization");

        organizationEmpJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        organizationEmpJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                organizationEmpJComboBoxActionPerformed(evt);
            }
        });

        jLabel9.setText("Role");

        userName.setText("Username");

        userJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User Name", "Role", "Patient", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(userJTable);

        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        passwordJTextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordJTextfieldActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 8)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setText("**Minimum 8 characters|Atleast one Uppercase|Atleast one Lowercase|Atleast one Number|Atleast one special character.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel7)
                .addGap(71, 71, 71)
                .addComponent(organizationEmpJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(roleJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(698, 698, 698))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 741, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(464, 464, 464)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(backJButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phoneNumber)
                    .addComponent(emailName)
                    .addComponent(patientName))
                .addGap(73, 73, 73)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(emailIDTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                    .addComponent(patientNameTextField, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phoneNumberTextField))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(userName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(563, 563, 563))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordJTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(organizationEmpJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)
                        .addComponent(roleJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(115, 115, 115)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(patientName)
                            .addComponent(patientNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emailName)
                            .addComponent(emailIDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(userNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userName))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(phoneNumber)
                        .addComponent(phoneNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(password)
                        .addComponent(passwordJTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jButton1)
                .addGap(98, 98, 98)
                .addComponent(backJButton)
                .addContainerGap(363, Short.MAX_VALUE))
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void patientNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientNameTextFieldActionPerformed
        // TODO add your handling code here:
        
        
        //popData();
        
    }//GEN-LAST:event_patientNameTextFieldActionPerformed

    private void organizationEmpJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_organizationEmpJComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_organizationEmpJComboBoxActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
          
            String patientName = patientNameTextField.getText();
            String email = emailIDTextField.getText();
            String phoneNumber = phoneNumberTextField.getText();
            String userName = userNameTextField.getText();
            String password = passwordJTextfield.getText();
            
            if(patientNameTextField.getText().isEmpty() || emailIDTextField.getText().isEmpty() || 
                    phoneNumberTextField.getText().isEmpty() || userNameTextField.getText().isEmpty()
                    || passwordJTextfield.getText().isEmpty())
            {
                errorNotify();
                JOptionPane.showMessageDialog(null, "Enter inputs for all fields");
                return;
            }
            else
            {
                
                 if(passwordPatternCorrect() && usernamePatternCorrect() && emailPatternCorrect())// && phonePatternCorrect())
                    {
                        if(!enterprise.getUserAccountDirectory().checkIfUsernameIsUnique(userName))
                            {
                                    this.userName.setForeground(Color.RED);
                                    JOptionPane.showMessageDialog(null, "Username unavailable. Already in use.", "Patient Account username unavailable", JOptionPane.ERROR_MESSAGE);

                            }
                        else{
                                    
                                    Organization organization = (Organization) organizationEmpJComboBox.getSelectedItem();
                                    PatientAccount patient = organization.getPatientAccountDirectory().createPatientAccount(patientName);
                                    patient.setPatientName(patientName);
                                    patient.setPatientEmail(email);
                                    patient.setPatientPhone(phoneNumber);

                                    Role role = (Role) roleJComboBox.getSelectedItem();

                                    organization.getUserAccountDirectory().createPatientAccount(userName, password, patient, role);

                                    SendEmail send  = new SendEmail("techietribe007@gmail.com","parasites",patient.getPatientEmail(),"Hi "+patient.getPatientName(),"Your user account has been created");

                                    JOptionPane.showMessageDialog(null,"User Account Created!");
                                    popData();
                            }
                   }
                    else
                    {
                            this.userName.setForeground(Color.RED);
                            this.password.setForeground(Color.RED);
                            this.emailName.setForeground(Color.RED);
                            this.phoneNumber.setForeground(Color.RED);
                            JOptionPane.showMessageDialog(null, "Username or Password does not comply with the requirements!");
                            return;
                    }
            }
            
            updateNotify();
            patientNameTextField.setText("");
            emailIDTextField.setText("");
            phoneNumberTextField.setText("");
            userNameTextField.setText("");
            passwordJTextfield.setText("");
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void passwordJTextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordJTextfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordJTextfieldActionPerformed

    private void userNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userNameTextFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JTextField emailIDTextField;
    private javax.swing.JLabel emailName;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox organizationEmpJComboBox;
    private javax.swing.JLabel password;
    private javax.swing.JPasswordField passwordJTextfield;
    private javax.swing.JLabel patientName;
    private javax.swing.JTextField patientNameTextField;
    private javax.swing.JLabel phoneNumber;
    private javax.swing.JTextField phoneNumberTextField;
    private javax.swing.JComboBox roleJComboBox;
    private javax.swing.JTable userJTable;
    private javax.swing.JLabel userName;
    private javax.swing.JTextField userNameTextField;
    // End of variables declaration//GEN-END:variables

    
}
