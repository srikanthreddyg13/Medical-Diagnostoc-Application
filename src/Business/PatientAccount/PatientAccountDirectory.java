/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.PatientAccount;

import Business.Role.Role;
import java.util.ArrayList;
/**
 *
 * @author Vishaka
 */
public class PatientAccountDirectory {
    private ArrayList<PatientAccount> patientAccountList;
    
    public PatientAccountDirectory(){
        patientAccountList = new ArrayList();
    }

    public ArrayList<PatientAccount> getPatientAccountList() {
        return patientAccountList;
    }

    public void setPatientAccountList(ArrayList<PatientAccount> patientAccountList) {
        this.patientAccountList = patientAccountList;
    }
    
    public PatientAccount authenticatePatient(String username, String password){
        for (PatientAccount pa : patientAccountList)
            if (pa.getPatientEmail().equals(username) && pa.getPatientPassword().equals(password)){
                return pa;
            }
        return null;
    }
    
    public PatientAccount createPatientAccount(String username){
        PatientAccount patientAccount = new PatientAccount();
        patientAccount.setPatientName(username);
        patientAccountList.add(patientAccount);
        return patientAccount;
    }
    
}
