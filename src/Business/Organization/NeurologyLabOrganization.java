/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.LabAssistantRole;
import Business.Role.NeuroLabAssistantRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author vish1
 */
public class NeurologyLabOrganization extends Organization{
   public NeurologyLabOrganization() {
        super(Organization.Type.NeuroLab.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new NeuroLabAssistantRole());
        return roles;
    } 
    
}
