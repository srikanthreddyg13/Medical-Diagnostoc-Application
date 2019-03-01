/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Doctor.DoctorDirectory;
import Business.Employee.Employee;
import Business.Employee.EmployeeDirectory;
import Business.PatientAccount.PatientAccount;
import Business.PatientAccount.PatientAccountDirectory;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public abstract class Organization {

    private String name;
    private WorkQueue workQueue;
    private EmployeeDirectory employeeDirectory;
    private PatientAccountDirectory patientAccountDirectory;
    private DoctorDirectory doctorDirectory;
    private UserAccountDirectory userAccountDirectory;
    private UserAccount userAccount;
    private int organizationID;
    private static int counter=0;
    
    public enum Type{
        Admin("Admin Organization"), Doctor("Doctor Organization"), 
        Lab("Lab Organization"), CancerLab("Cancer Lab"),CardioLab("Cardiology Lab"), 
        NeuroLab("Neurology Lab"), RadioLab("Radiology Lab"),Patient("Patient Organization");
        private String value;
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }

    public Organization(String name) {
        this.name = name;
        //this.orgName = orgName;
        workQueue = new WorkQueue();
        employeeDirectory = new EmployeeDirectory();
        userAccountDirectory = new UserAccountDirectory();
        patientAccountDirectory = new PatientAccountDirectory();
        doctorDirectory = new DoctorDirectory();
        userAccount = new UserAccount();
        organizationID = counter;
        ++counter;
    }

    public abstract ArrayList<Role> getSupportedRole();
    
    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }
    
    

    public int getOrganizationID() {
        return organizationID;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }

    public PatientAccountDirectory getPatientAccountDirectory() {
        return patientAccountDirectory;
    }

    public DoctorDirectory getDoctorDirectory() {
        return doctorDirectory;
    }

    public String getName() {
        return name;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }
    public boolean searchEmployeeName(String name){
        for(Employee emp : this.employeeDirectory.getEmployeeList()){
            if(emp.getName().equalsIgnoreCase(name)){
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
}
