/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import Business.PatientAccount.PatientAccount;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class EmployeeDirectory {
    
    private ArrayList<Employee> employeeList;
    private ArrayList<PatientAccount> patientAccountList;

    public EmployeeDirectory() {
        employeeList = new ArrayList();
        patientAccountList = new ArrayList();
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    public ArrayList<PatientAccount> getPatientAccountList() {
        return patientAccountList;
    }
    
    
    
    public Employee createEmployee(String name){
        Employee employee = new Employee();
        employee.setName(name);
        employeeList.add(employee);
        return employee;
    }
}