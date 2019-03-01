/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.CancerLabAssistantRole;
import Business.Role.LabAssistantRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author vish1
 */
public class CancerLabOrganization extends Organization{
   public CancerLabOrganization() {
        super(Organization.Type.CancerLab.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new CancerLabAssistantRole());
        return roles;
    } 
    
}
