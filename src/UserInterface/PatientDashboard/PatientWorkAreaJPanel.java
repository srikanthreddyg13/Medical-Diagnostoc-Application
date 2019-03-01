/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.PatientDashboard;

import Business.Enterprise.Enterprise;
import Business.Organization.CancerLabOrganization;
import Business.Organization.CardiologyLabOrganization;
import Business.Organization.DoctorOrganization;
import Business.Organization.PatientOrganization;
import Business.Organization.LabOrganization;
import Business.Organization.NeurologyLabOrganization;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.Organization.RadiologyLabOrganization;
import Business.PatientAccount.PatientAccount;
import Business.PatientAccount.SendEmail;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.CancerLabWorkRequest;
import Business.WorkQueue.CardioLabWorkRequest;
import Business.WorkQueue.DoctorWorkRequest;
import Business.WorkQueue.LabTestWorkRequest;
import Business.WorkQueue.NeuroLabWorkRequest;
import Business.WorkQueue.RadioLabWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Srikanth Reddy
 */
public class PatientWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form PatientWorkAreaJPanel
     */
    private JPanel userProcessContainer;
    private Organization organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    //private PatientAccount patientAccount;
    //private OrganizationDirectory directory;
    //private LabOrganization labOrganization;
    
    public PatientWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.organization = (Organization)organization;
        this.enterprise = enterprise;
        this.userAccount = account;
        //this.directory = directory;
        //this.patientAccount=patientAccount;
        valueLabel.setText(account.getUsername());
        //populateRequestTable();
        populateCombo();
        populateDocCombo();
        populateSecOpinion();
        
    }
    
    private void populateDocCombo(){
      doctorComboBox.removeAllItems();
      Organization org = null;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()
                ){
            if (organization instanceof DoctorOrganization){
                org = organization;
                doctorComboBox.addItem(org);
                populateEmp(org);
            }
        }
    }
    
    public void populateRequestTable(Organization organization){
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();
        //PatientAccount patientAccount = new PatientAccount();
        model.setRowCount(0);
        Organization org = (Organization) labComboBox.getSelectedItem();
        
            if (org instanceof CancerLabOrganization)
            {
                for (WorkRequest request : org.getWorkQueue().getWorkRequestList()){
                    Object[] row = new Object[5];
                    row[0] = request.getMessage();
                    row[1] = request.getReceiver();
                    row[2] = request.getStatus();
                    String result = ((CancerLabWorkRequest) request).getTestResult();
                    row[3] = result == null ? "Waiting" : result;
                    model.addRow(row);
            }
                
            
            }
            if(org instanceof NeurologyLabOrganization)
            {
                for (WorkRequest request : org.getWorkQueue().getWorkRequestList()){
                    Object[] row = new Object[5];
                    row[0] = request.getMessage();
                    row[1] = request.getReceiver();
                    row[2] = request.getStatus();
                    String result = ((NeuroLabWorkRequest) request).getTestResult();
                    row[3] = result == null ? "Waiting" : result;
                    model.addRow(row);
            }
                
            }
            else if(org instanceof RadiologyLabOrganization)
            {
                for (WorkRequest request : org.getWorkQueue().getWorkRequestList()){
                    Object[] row = new Object[5];
                    row[0] = request.getMessage();
                    row[1] = request.getReceiver();
                    row[2] = request.getStatus();
                    String result = ((RadioLabWorkRequest) request).getTestResult();
                    row[3] = result == null ? "Waiting" : result;
                    model.addRow(row);
            }
            }
            else if(org instanceof CardiologyLabOrganization)
            {
                for (WorkRequest request : org.getWorkQueue().getWorkRequestList()){
                    Object[] row = new Object[5];
                    row[0] = request.getMessage();
                    row[1] = request.getReceiver();
                    row[2] = request.getStatus();
                    String result = ((CardioLabWorkRequest) request).getTestResult();
                    row[3] = result == null ? "Waiting" : result;
                    model.addRow(row);
            }
            }

        
    }
    
    public void populateSecOpinion(){
         DefaultTableModel model = (DefaultTableModel)workRequestJTable1.getModel();
        
        model.setRowCount(0);
        Organization org = (Organization) doctorComboBox.getSelectedItem();
        if (org instanceof DoctorOrganization )
        {
        for(WorkRequest request : userAccount.getWorkQueue().getWorkRequestList())
        {
            Object[] row = new Object[4];
           // if (organization instanceof DoctorOrganization)
           // {
            row[0] = request.getMessage();
            row[1] = request.getSender().getPatientAccount().getPatientName();
            row[2] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
            row[3] = request.getStatus();
            
            model.addRow(row);
            //}
        }
        }
     }
    
    public void populateEmp(Organization organization){
     docNameCombo.removeAllItems();
        
       // for (UserAccount employee : organization.getEmployeeDirectory().getEmployeeList()){
       for (UserAccount employee : organization.getUserAccountDirectory().getUserAccountList()){
            docNameCombo.addItem(employee);
        }
     }
    
    private void populateCombo(){
      labComboBox.removeAllItems();
      Organization org = null;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
            if (organization instanceof CancerLabOrganization || organization instanceof NeurologyLabOrganization 
                    || organization instanceof CardiologyLabOrganization || organization instanceof RadiologyLabOrganization){
                org = organization;
                labComboBox.addItem(org);
                //populateRequestTable(org);
            }
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

        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        requestTestJButton = new javax.swing.JButton();
        enterpriseLabel = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();
        refreshTestJButton = new javax.swing.JButton();
        labComboBox = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        messageJTextField = new javax.swing.JTextField();
        secondOpinionBtn = new javax.swing.JButton();
        doctorComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        secOpinionMessage = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        docNameCombo = new javax.swing.JComboBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        workRequestJTable1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Message", "Receiver", "Status", "Result"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(workRequestJTable);

        requestTestJButton.setBackground(new java.awt.Color(153, 0, 0));
        requestTestJButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        requestTestJButton.setForeground(new java.awt.Color(255, 255, 255));
        requestTestJButton.setText("Request Test");
        requestTestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestTestJButtonActionPerformed(evt);
            }
        });

        enterpriseLabel.setBackground(new java.awt.Color(255, 255, 255));
        enterpriseLabel.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        enterpriseLabel.setForeground(new java.awt.Color(0, 0, 153));
        enterpriseLabel.setText("Welcome,");

        valueLabel.setBackground(new java.awt.Color(255, 255, 255));
        valueLabel.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        valueLabel.setForeground(new java.awt.Color(0, 0, 153));
        valueLabel.setText("<value>");

        refreshTestJButton.setBackground(new java.awt.Color(204, 0, 0));
        refreshTestJButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        refreshTestJButton.setForeground(new java.awt.Color(255, 255, 255));
        refreshTestJButton.setText("Refresh");
        refreshTestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshTestJButtonActionPerformed(evt);
            }
        });

        labComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        labComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                labComboBoxActionPerformed(evt);
            }
        });

        jLabel1.setText("Choose Lab:");

        jLabel2.setText("Message");

        secondOpinionBtn.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        secondOpinionBtn.setForeground(new java.awt.Color(153, 0, 0));
        secondOpinionBtn.setText("Request Second Opinion");
        secondOpinionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secondOpinionBtnActionPerformed(evt);
            }
        });

        doctorComboBox.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        doctorComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        doctorComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doctorComboBoxActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("Doctor Organization :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setText("Message :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setText("Doctor Name :");

        docNameCombo.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        docNameCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        docNameCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                docNameComboActionPerformed(evt);
            }
        });

        workRequestJTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Message", "Sender", "Receiver", "Result"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(workRequestJTable1);

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Request for a Second Opinion :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(enterpriseLabel)
                .addGap(7, 7, 7)
                .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(877, 877, 877)
                .addComponent(refreshTestJButton))
            .addGroup(layout.createSequentialGroup()
                .addGap(485, 485, 485)
                .addComponent(jLabel1)
                .addGap(69, 69, 69)
                .addComponent(labComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(485, 485, 485)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(593, 593, 593)
                .addComponent(jLabel2)
                .addGap(43, 43, 43)
                .addComponent(messageJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(612, 612, 612)
                .addComponent(requestTestJButton))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(secondOpinionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(secOpinionMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(doctorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(docNameCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(enterpriseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(refreshTestJButton))
                .addGap(148, 148, 148)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel1))
                    .addComponent(labComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel2))
                    .addComponent(messageJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(requestTestJButton)
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(secOpinionMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(secondOpinionBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(doctorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(docNameCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(197, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void requestTestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestTestJButtonActionPerformed

//        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
//        userProcessContainer.add("RequestLabTestJPanel", new PatientLabTestRequestJPanel(userProcessContainer, userAccount, enterprise, organization));
//        layout.next(userProcessContainer);
        
        String message = messageJTextField.getText();

        CancerLabWorkRequest cancerRequest = new CancerLabWorkRequest();
        NeuroLabWorkRequest neuroRequest = new NeuroLabWorkRequest();
        RadioLabWorkRequest radioRequest = new RadioLabWorkRequest();
        CardioLabWorkRequest cardioRequest = new CardioLabWorkRequest();

        Organization org = (Organization) labComboBox.getSelectedItem();
        //for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
       
            if (org instanceof CancerLabOrganization ){
                 //org = organization;
                cancerRequest.setMessage("For "+userAccount.getPatientAccount().getPatientName()+" "+message);
                cancerRequest.setSender(userAccount);
                cancerRequest.setStatus("Sent");
                cancerRequest.setCancerReceiverEmail(userAccount.getPatientAccount().getPatientEmail());
                org.getWorkQueue().getWorkRequestList().add(cancerRequest);
                userAccount.getWorkQueue().getWorkRequestList().add(cancerRequest);
                populateRequestTable(org);
                SendEmail send  = new SendEmail(cancerRequest.getCancerSenderEmail(),cancerRequest.getPassword(),userAccount.getPatientAccount().getPatientEmail(),"hello "+userAccount.getPatientAccount().getPatientName(),"Your Cancer Lab request has been raised");
                 //break;
            }
            if (org instanceof NeurologyLabOrganization ){
                
                //orgSendEmail end  = new SendEmail(email,"hello","how are you"); = organization;
                neuroRequest.setMessage("For "+userAccount.getPatientAccount().getPatientName()+" "+message);
                neuroRequest.setSender(userAccount);
                neuroRequest.setStatus("Sent");
                neuroRequest.setNeuroReceiverEmail(userAccount.getPatientAccount().getPatientEmail());
                org.getWorkQueue().getWorkRequestList().add(neuroRequest);
                userAccount.getWorkQueue().getWorkRequestList().add(neuroRequest);
                populateRequestTable(org);
                SendEmail send  = new SendEmail(neuroRequest.getNeuroSenderEmail(),neuroRequest.getPassword(),userAccount.getPatientAccount().getPatientEmail(),"hello "+userAccount.getPatientAccount().getPatientName(),"Your Neurology Lab request has been raised");

                //break;
            }
            if (org instanceof RadiologyLabOrganization ){
                //org = organization;
                radioRequest.setMessage("For "+userAccount.getPatientAccount().getPatientName()+" "+message);
                radioRequest.setSender(userAccount);
                radioRequest.setStatus("Sent");
                radioRequest.setRadioReceiverEmail(userAccount.getPatientAccount().getPatientEmail());
                org.getWorkQueue().getWorkRequestList().add(radioRequest);
                userAccount.getWorkQueue().getWorkRequestList().add(radioRequest);
                populateRequestTable(org);
                SendEmail send  = new SendEmail(radioRequest.getRadioSenderEmail(),radioRequest.getPassword(),userAccount.getPatientAccount().getPatientEmail(),"hello "+userAccount.getPatientAccount().getPatientName(),"Your Radiology Lab request has been raised");

                //break;
            }
            if (org instanceof CardiologyLabOrganization ){
                //org = organization;
                cardioRequest.setMessage("For "+userAccount.getPatientAccount().getPatientName()+" "+message);
                cardioRequest.setSender(userAccount);
                cardioRequest.setStatus("Sent");
                cardioRequest.setCardioReceiverEmail(userAccount.getPatientAccount().getPatientEmail());
                org.getWorkQueue().getWorkRequestList().add(cardioRequest);
                userAccount.getWorkQueue().getWorkRequestList().add(cardioRequest);
                populateRequestTable(org);
                SendEmail send  = new SendEmail(cardioRequest.getCardioSenderEmail(),radioRequest.getPassword(),userAccount.getPatientAccount().getPatientEmail(),"hello "+userAccount.getPatientAccount().getPatientName(),"Your Cardiology Lab request has been raised");

                //break;
            }

        //}
    }//GEN-LAST:event_requestTestJButtonActionPerformed

    private void refreshTestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshTestJButtonActionPerformed

        Organization org = null;
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
            if (organization instanceof CancerLabOrganization || organization instanceof NeurologyLabOrganization
                    || organization instanceof CardiologyLabOrganization || organization instanceof RadiologyLabOrganization){
                org = organization;
                //labComboBox.addItem(org);
                populateRequestTable(org);
            }
        }
    }//GEN-LAST:event_refreshTestJButtonActionPerformed

    private void labComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_labComboBoxActionPerformed

        // TODO add your handling code here:
        Organization organization = (Organization)labComboBox.getSelectedItem();
        if (organization instanceof CancerLabOrganization || organization instanceof NeurologyLabOrganization
                || organization instanceof CardiologyLabOrganization || organization instanceof RadiologyLabOrganization){
            populateRequestTable(organization);
        }

    }//GEN-LAST:event_labComboBoxActionPerformed

    private void secondOpinionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secondOpinionBtnActionPerformed
        // TODO add your handling code here:
        //        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        //        userProcessContainer.add("SecondOpinionMainJPanel", new SecondOpinionMainJPanel(userProcessContainer,directory,enterprise));
        //        layout.next(userProcessContainer);

        String message = secOpinionMessage.getText();

        DoctorWorkRequest docWork = new DoctorWorkRequest();
        //WorkRequest request : userAccount.getWorkQueue().getWorkRequestList();
        Organization org = (Organization) doctorComboBox.getSelectedItem();
        //UserAccount user = (UserAccount) doctorComboBox.getSelectedItem();
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
            if (org instanceof DoctorOrganization ){
                docWork.setMessage(message);
                //UserAccount userAccount = (userAccount) organizationJTable.getValueAt(selectRow, 0);
                docWork.setSender(userAccount) ;
                docWork.setReceiver((UserAccount) docNameCombo.getSelectedItem());
                docWork.setStatus("Sent");
                org.getWorkQueue().getWorkRequestList().add(docWork);
                userAccount.getWorkQueue().getWorkRequestList().add(docWork);
                //                ViewSecondOpinionRequestsJPanel viewSecPanel = new ViewSecondOpinionRequestsJPanel(userProcessContainer, userAccount, organization, enterprise);
                //                viewSecPanel.populateTable();
                populateSecOpinion();
                //                populateTable(org);
                break;
            }
        }
    }//GEN-LAST:event_secondOpinionBtnActionPerformed

    private void doctorComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doctorComboBoxActionPerformed
        // TODO add your handling code here:
        Organization organization = (Organization)doctorComboBox.getSelectedItem();
        if (organization instanceof DoctorOrganization){
            //populateRequestTable(organization);
            populateEmp(organization);
        }
    }//GEN-LAST:event_doctorComboBoxActionPerformed

    private void docNameComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_docNameComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_docNameComboActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox docNameCombo;
    private javax.swing.JComboBox doctorComboBox;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JComboBox labComboBox;
    private javax.swing.JTextField messageJTextField;
    private javax.swing.JButton refreshTestJButton;
    private javax.swing.JButton requestTestJButton;
    private javax.swing.JTextField secOpinionMessage;
    private javax.swing.JButton secondOpinionBtn;
    private javax.swing.JLabel valueLabel;
    private javax.swing.JTable workRequestJTable;
    private javax.swing.JTable workRequestJTable1;
    // End of variables declaration//GEN-END:variables
}
