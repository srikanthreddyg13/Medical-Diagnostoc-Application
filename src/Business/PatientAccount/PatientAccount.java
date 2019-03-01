/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.PatientAccount;

import Business.Employee.Employee;
import Business.Role.Role;
import Business.WorkQueue.WorkQueue;

/**
 *
 * @author Vishaka
 */
public class PatientAccount {
    private String patientName;
    private String patientID; //Assign ID once patient account is created.
    private String patientPhone;
    private String patientEmail; //Use as the username for logging in.
    private String patientPassword;
    private String isACorporateEmployee;
    //private Role role;
    //private WorkQueue workQueue;
    private int id;
    private static int count = 1;
    
    public PatientAccount(){
        //workQueue = new WorkQueue();
        id = count;
        count++;
    }

    public int getId() {
        return id;
    }

    
    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getPatientPhone() {
        return patientPhone;
    }

    public void setPatientPhone(String patientPhone) {
        this.patientPhone = patientPhone;
    }

    public String getPatientEmail() {
        return patientEmail;
    }

    public void setPatientEmail(String patientEmail) {
        this.patientEmail = patientEmail;
    }

    public String getPatientPassword() {
        return patientPassword;
    }

    public void setPatientPassword(String patientPassword) {
        this.patientPassword = patientPassword;
    }

    public String getIsACorporateEmployee() {
        return isACorporateEmployee;
    }

    public void setIsACorporateEmployee(String isACorporateEmployee) {
        this.isACorporateEmployee = isACorporateEmployee;
    }

//    public Role getRole() {
//        return role;
//    }
//
//    public void setRole(Role role) {
//        this.role = role;
//    }

//    public WorkQueue getWorkQueue() {
//        return workQueue;
//    }
//
//    public void setWorkQueue(WorkQueue workQueue) {
//        this.workQueue = workQueue;
//    }
    
    @Override
    public String toString() {
        return patientName;
    }    
}
