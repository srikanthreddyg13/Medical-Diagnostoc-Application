/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.DoctorRole;

import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.CancerLabOrganization;
import Business.Organization.CardiologyLabOrganization;
import Business.Organization.DoctorOrganization;
import Business.Organization.LabOrganization;
import Business.Organization.NeurologyLabOrganization;
import Business.Organization.Organization;
import Business.Organization.Organization.Type;
import Business.Organization.OrganizationDirectory;
import Business.Organization.RadiologyLabOrganization;
import Business.UserAccount.UserAccount;
import Business.PatientAccount.PatientAccount;
import Business.WorkQueue.CancerLabWorkRequest;
import Business.WorkQueue.DoctorWorkRequest;
import Business.WorkQueue.CardioLabWorkRequest;
import Business.WorkQueue.LabTestWorkRequest;
import Business.WorkQueue.NeuroLabWorkRequest;
import Business.WorkQueue.RadioLabWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicBorders;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Srikanth Reddy
 */
public class DoctorWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form DoctorWorkAreaJPanel
     */
    private JPanel userProcessContainer;
    //private DoctorOrganization organization;
    private Organization organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private PatientAccount patientAccount;
    private OrganizationDirectory directory;
    private LabOrganization labOrganization;
    private EcoSystem business;
    
    public DoctorWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise,EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.organization = (Organization)organization;
        this.enterprise = enterprise;
        this.userAccount = account;
        this.business= business;
        //this.directory = directory;
        //this.patientAccount=patientAccount;
        valueLabel.setText(enterprise.getName());
        accountText.setText(account.getUsername());
        //populateRequestTable();
        populateEnterpriseCombo();
        populateDocCombo();
        populateSecOpinion();
        populatePatientCombo();
    }
    
    private void populatePatientCombo(){

       patientListCombo.removeAllItems();
       patientListCombo1.removeAllItems();
       for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
       for(PatientAccount patientAccount : organization.getPatientAccountDirectory().getPatientAccountList()){
           patientListCombo.addItem(patientAccount);
           patientListCombo1.addItem(patientAccount);
        }
       }
       
    }
    
    private void populateLabCombo(Enterprise enterprise){
       
        
        //Enterprise enterprise = (Enterprise) enterpriseComboBox.getSelectedItem();
                //if(enterprise.getEnterpriseType().toString().equals("Lab")){
                   
                //}
                //else if(enterprise.getEnterpriseType().toString().equals("Hospital")){
                   
                //}  
                
    }
  
     private void populateEnterpriseCombo(){
         
        Organization org = null;
        labComboBox.removeAllItems();
          enterpriseComboBox.removeAllItems();
          for (Network network : business.getNetworkList()) {
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                enterpriseComboBox.addItem(enterprise); 
                //populateLabCombo(enterprise);
                for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                            org = organization;
                            labComboBox.addItem(organization);
                        } 
            } 
        }
          
          
        
    }
    
    
    public void populateRequestTable(Organization organization){
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();
        
        model.setRowCount(0);
        Organization org = (Organization) labComboBox.getSelectedItem();
        
            if (org instanceof CancerLabOrganization)
            {
                for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()){
            Object[] row = new Object[5];
            row[0] = request.getMessage();
            row[1] = request.getReceiver();
            row[2] = request.getStatus();
                String result = ((CancerLabWorkRequest) request).getTestResult();
                row[3] = result == null ? "Waiting" : result;
                row[4] = request.getRequestFor();
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
                row[4] = request.getRequestFor();
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
                row[4] = request.getRequestFor();
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
                row[4] = request.getRequestFor();
                model.addRow(row);
            }
            }
            else if(org instanceof DoctorOrganization){
                for (WorkRequest request : org.getWorkQueue().getWorkRequestList()){
            Object[] row = new Object[5];
            row[0] = request.getMessage();
            row[1] = request.getReceiver();
            row[2] = request.getStatus();
                String result = ((DoctorWorkRequest) request).getTestResult();
                row[3] = result == null ? "Waiting" : result;
                row[4] = request.getRequestFor();
                model.addRow(row);
      
              }
            }
        
    }
    
    /*
    Combo Box and Table for Second Opinion
    */
    
    
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
     
     public void populateEmp(Organization organization){
     docNameCombo.removeAllItems();
        
       // for (UserAccount employee : organization.getEmployeeDirectory().getEmployeeList()){
       for (UserAccount employee : organization.getUserAccountDirectory().getUserAccountList()){
            docNameCombo.addItem(employee);
        }
     }
     
     public void populateSecOpinion(){
         DefaultTableModel model = (DefaultTableModel)workRequestJTable1.getModel();
        
        model.setRowCount(0);
        Organization org = (Organization) doctorComboBox.getSelectedItem();
        if (org instanceof DoctorOrganization ){
        for(WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()){
            Object[] row = new Object[5];
            if (organization instanceof DoctorOrganization){
            row[0] = request.getMessage();
            row[1] = request.getSender().getEmployee().getName();
            row[2] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
            row[3] = request.getStatus();
            row[4] = request.getRequestFor();
            
            model.addRow(row);
            }
        }
        }
     }
     
//     private void populateTable(Organization organization){
//        DefaultTableModel model = (DefaultTableModel) organizationJTable.getModel();
//        
//        model.setRowCount(0);
//        
//        for (Employee employee : organization.getEmployeeDirectory().getEmployeeList()){
//            Object[] row = new Object[2];
//            row[0] = employee.getId();
//            row[1] = employee.getName();
//            model.addRow(row);
//        }
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        enterpriseLabel = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();
        refreshTestJButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        requestTestJButton = new javax.swing.JButton();
        secondOpinionBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        labComboBox = new javax.swing.JComboBox();
        messageJTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        doctorComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        secOpinionMessage = new javax.swing.JTextField();
        viewSecondOpinionBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        docNameCombo = new javax.swing.JComboBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        workRequestJTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        workRequestJTable2 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        accountText = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        enterpriseComboBox = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        patientListCombo = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        patientListCombo1 = new javax.swing.JComboBox();

        setBackground(new java.awt.Color(255, 255, 255));

        enterpriseLabel.setBackground(new java.awt.Color(255, 255, 255));
        enterpriseLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        enterpriseLabel.setForeground(new java.awt.Color(204, 0, 0));
        enterpriseLabel.setText("EnterPrise :");

        valueLabel.setBackground(new java.awt.Color(255, 255, 255));
        valueLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        valueLabel.setForeground(new java.awt.Color(204, 0, 0));
        valueLabel.setText("<value>");

        refreshTestJButton.setBackground(new java.awt.Color(255, 255, 255));
        refreshTestJButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        refreshTestJButton.setForeground(new java.awt.Color(204, 0, 0));
        refreshTestJButton.setText("Refresh");
        refreshTestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshTestJButtonActionPerformed(evt);
            }
        });

        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Message", "Receiver", "Status", "Result", "Patient Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(workRequestJTable);

        requestTestJButton.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        requestTestJButton.setForeground(new java.awt.Color(153, 0, 0));
        requestTestJButton.setText("Request Test");
        requestTestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requestTestJButtonActionPerformed(evt);
            }
        });

        secondOpinionBtn.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        secondOpinionBtn.setForeground(new java.awt.Color(153, 0, 0));
        secondOpinionBtn.setText("Request Second Opinion");
        secondOpinionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secondOpinionBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setText("Choose Lab:");

        labComboBox.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        labComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        labComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                labComboBoxActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Message:");

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

        viewSecondOpinionBtn.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        viewSecondOpinionBtn.setForeground(new java.awt.Color(153, 0, 0));
        viewSecondOpinionBtn.setText("View Second Opinion Requests");
        viewSecondOpinionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewSecondOpinionBtnActionPerformed(evt);
            }
        });

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
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Message", "Sender", "Receiver", "Result", "Patient Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(workRequestJTable1);

        workRequestJTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(workRequestJTable2);

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Request a Test :");

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Request for a Second Opinion :");

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Requests for second opinion to me : ");

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 204));
        jLabel9.setText("Welcome,");

        accountText.setBackground(new java.awt.Color(255, 255, 255));
        accountText.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        accountText.setForeground(new java.awt.Color(0, 0, 204));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel11.setText("Choose type:");

        enterpriseComboBox.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        enterpriseComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        enterpriseComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterpriseComboBoxActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel12.setText("Choose Patient List:");

        patientListCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        patientListCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patientListComboActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel13.setText("Choose Patient List:");

        patientListCombo1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        patientListCombo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patientListCombo1ActionPerformed(evt);
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
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(enterpriseLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(accountText, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(refreshTestJButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(445, 445, 445)
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(patientListCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addGap(97, 97, 97)
                                                .addComponent(secondOpinionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(secOpinionMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(viewSecondOpinionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(62, 62, 62)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel11))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(labComboBox, 0, 216, Short.MAX_VALUE)
                                            .addComponent(enterpriseComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(requestTestJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(messageJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel12)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(patientListCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(doctorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(docNameCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(refreshTestJButton)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(accountText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(enterpriseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valueLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(messageJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(patientListCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(14, 14, 14)
                        .addComponent(requestTestJButton)
                        .addGap(113, 113, 113)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(patientListCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(secOpinionMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(secondOpinionBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(viewSecondOpinionBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(enterpriseComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(labComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(doctorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(docNameCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(69, 69, 69))
        );
    }// </editor-fold>//GEN-END:initComponents

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

    private void requestTestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_requestTestJButtonActionPerformed

//        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
//        userProcessContainer.add("RequestLabTestJPanel", new RequestLabTestJPanel(userProcessContainer, userAccount, enterprise, organization));
//        layout.next(userProcessContainer);

        String message = messageJTextField.getText();
        PatientAccount list = (PatientAccount)patientListCombo.getSelectedItem();
        CancerLabWorkRequest cancerRequest = new CancerLabWorkRequest();
        NeuroLabWorkRequest neuroRequest = new NeuroLabWorkRequest();
        RadioLabWorkRequest radioRequest = new RadioLabWorkRequest();
        CardioLabWorkRequest cardioRequest = new CardioLabWorkRequest();
        DoctorWorkRequest doctorRequest = new DoctorWorkRequest();

        Organization org = (Organization) labComboBox.getSelectedItem();
        //for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
            if (org instanceof CancerLabOrganization ){
                //org = organization;
                cancerRequest.setMessage(message);
                cancerRequest.setSender(userAccount);
                cancerRequest.setRequestFor(list);
                cancerRequest.setStatus("Sent");
                org.getWorkQueue().getWorkRequestList().add(cancerRequest);
                userAccount.getWorkQueue().getWorkRequestList().add(cancerRequest);
                populateRequestTable(org);
                //break;
            }
            if (org instanceof NeurologyLabOrganization ){
                //org = organization;
                neuroRequest.setMessage(message);
                neuroRequest.setSender(userAccount);
                neuroRequest.setRequestFor(list);
                neuroRequest.setStatus("Sent");
                org.getWorkQueue().getWorkRequestList().add(neuroRequest);
                userAccount.getWorkQueue().getWorkRequestList().add(neuroRequest);
                populateRequestTable(org);
                //break;
            }
            if (org instanceof RadiologyLabOrganization ){
                //org = organization;
                radioRequest.setMessage(message);
                radioRequest.setSender(userAccount);
                radioRequest.setRequestFor(list);
                radioRequest.setStatus("Sent");
                org.getWorkQueue().getWorkRequestList().add(radioRequest);
                userAccount.getWorkQueue().getWorkRequestList().add(radioRequest);
                populateRequestTable(org);
                //break;
            }
            if (org instanceof CardiologyLabOrganization ){
                //org = organization;
                cardioRequest.setMessage(message);
                cardioRequest.setSender(userAccount);
                cardioRequest.setRequestFor(list);
                cardioRequest.setStatus("Sent");
                org.getWorkQueue().getWorkRequestList().add(cardioRequest);
                userAccount.getWorkQueue().getWorkRequestList().add(cardioRequest);
                populateRequestTable(org);
                //break;
            }
             if(org instanceof DoctorOrganization){
                doctorRequest.setMessage(message);
                doctorRequest.setSender(userAccount);
                doctorRequest.setRequestFor(list);
                doctorRequest.setStatus("Sent");
                org.getWorkQueue().getWorkRequestList().add(doctorRequest);
                userAccount.getWorkQueue().getWorkRequestList().add(doctorRequest);
                populateRequestTable(org);
            }
    }//GEN-LAST:event_requestTestJButtonActionPerformed

    private void secondOpinionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secondOpinionBtnActionPerformed
        // TODO add your handling code here:
//        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
//        userProcessContainer.add("SecondOpinionMainJPanel", new SecondOpinionMainJPanel(userProcessContainer,directory,enterprise));
//        layout.next(userProcessContainer);
        
        String message = secOpinionMessage.getText();
        PatientAccount list = (PatientAccount)patientListCombo.getSelectedItem();
        DoctorWorkRequest docWork = new DoctorWorkRequest();
        //WorkRequest request : userAccount.getWorkQueue().getWorkRequestList();
        Organization org = (Organization) doctorComboBox.getSelectedItem();
        //UserAccount user = (UserAccount) doctorComboBox.getSelectedItem();
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
            if (org instanceof DoctorOrganization ){
                //org = organization;
//                int selectRow = organizationJTable.getSelectedRow();
//                if (selectRow < 0){
//                    return;
//                }
                docWork.setMessage(message);
                //UserAccount userAccount = (userAccount) organizationJTable.getValueAt(selectRow, 0);
                docWork.setSender(userAccount) ;
                docWork.setReceiver((UserAccount) docNameCombo.getSelectedItem());
                docWork.setRequestFor((PatientAccount)patientListCombo1.getSelectedItem());
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
//            if (org instanceof NeurologyLabOrganization ){
//                org = organization;
//                neuroRequest.setMessage(message);
//                neuroRequest.setSender(userAccount);
//                neuroRequest.setStatus("Sent");
//                org.getWorkQueue().getWorkRequestList().add(neuroRequest);
//                userAccount.getWorkQueue().getWorkRequestList().add(neuroRequest);
//                populateRequestTable(org);
//                //break;
//            }
    }//GEN-LAST:event_secondOpinionBtnActionPerformed

    private void labComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_labComboBoxActionPerformed

        // TODO add your handling code here:
       
        Organization org = (Organization)labComboBox.getSelectedItem();
       for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()){
        if (org instanceof CancerLabOrganization || org instanceof NeurologyLabOrganization    
              || org instanceof CardiologyLabOrganization || org instanceof RadiologyLabOrganization ||org instanceof DoctorOrganization){
          
            populateRequestTable(organization);
            }
        
       }
//        else if(organization instanceof NeurologyLabOrganization    || organization instanceof CardiologyLabOrganization || organization instanceof RadiologyLabOrganization){
//            populateRequestTable(organization);
//        }
//           Enterprise enterprise = (Enterprise) enterpriseComboBox.getSelectedItem();
//        if (enterprise != null){
//            
//            populateLabCombo(enterprise);
//        }

    }//GEN-LAST:event_labComboBoxActionPerformed

    private void doctorComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doctorComboBoxActionPerformed
        // TODO add your handling code here:
        Organization organization = (Organization)doctorComboBox.getSelectedItem();
        if (organization instanceof DoctorOrganization){
            //populateRequestTable(organization);
            populateEmp(organization);
        }
    }//GEN-LAST:event_doctorComboBoxActionPerformed

    private void viewSecondOpinionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewSecondOpinionBtnActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)workRequestJTable2.getModel();
        
        model.setRowCount(0);
        
        for(WorkRequest request : organization.getWorkQueue().getWorkRequestList()){
            if(request.getReceiver().getEmployee().getName() == userAccount.getEmployee().getName()){
            //if(!request.getStatus().equalsIgnoreCase("Sent")){
            
            if (organization instanceof DoctorOrganization){
             Object[] row = new Object[4];   
            row[0] = request.getMessage();
            //row[1] = request.getSender().getEmployee().getName();
            row[2] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
            row[3] = request.getStatus();
            
            model.addRow(row);
            }
            }
        }
        
//        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
//        userProcessContainer.add("ViewSecondOpinionRequests", new ViewSecondOpinionRequestsJPanel(userProcessContainer,userAccount, organization,enterprise));
//        layout.next(userProcessContainer);

    }//GEN-LAST:event_viewSecondOpinionBtnActionPerformed

    private void docNameComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_docNameComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_docNameComboActionPerformed

    private void enterpriseComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterpriseComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enterpriseComboBoxActionPerformed

    private void patientListComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientListComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_patientListComboActionPerformed

    private void patientListCombo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientListCombo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_patientListCombo1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accountText;
    private javax.swing.JComboBox docNameCombo;
    private javax.swing.JComboBox doctorComboBox;
    private javax.swing.JComboBox enterpriseComboBox;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JComboBox labComboBox;
    private javax.swing.JTextField messageJTextField;
    private javax.swing.JComboBox patientListCombo;
    private javax.swing.JComboBox patientListCombo1;
    private javax.swing.JButton refreshTestJButton;
    private javax.swing.JButton requestTestJButton;
    private javax.swing.JTextField secOpinionMessage;
    private javax.swing.JButton secondOpinionBtn;
    private javax.swing.JLabel valueLabel;
    private javax.swing.JButton viewSecondOpinionBtn;
    private javax.swing.JTable workRequestJTable;
    private javax.swing.JTable workRequestJTable1;
    private javax.swing.JTable workRequestJTable2;
    // End of variables declaration//GEN-END:variables
}
