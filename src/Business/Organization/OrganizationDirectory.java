/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Employee.Employee;
import Business.Employee.EmployeeDirectory;
import Business.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;
    

    public OrganizationDirectory() {
        organizationList = new ArrayList();
        
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(Type type){
        Organization organization = null;
        if (type.getValue().equals(Type.Doctor.getValue())){
            organization = new DoctorOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Lab.getValue())){
            organization = new LabOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.Patient.getValue())){
            organization = new PatientOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.CancerLab.getValue())){
            organization = new CancerLabOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.NeuroLab.getValue())){
            organization = new NeurologyLabOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.RadioLab.getValue())){
            organization = new RadiologyLabOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.CardioLab.getValue())){
            organization = new CardiologyLabOrganization();
            organizationList.add(organization);
        }
        return organization;
    }
    
    
    
}