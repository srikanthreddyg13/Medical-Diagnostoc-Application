/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.CardioLabAssistantRole;
import Business.Role.LabAssistantRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author vish1
 */
public class CardiologyLabOrganization extends Organization{
   public CardiologyLabOrganization() {
        super(Organization.Type.CardioLab.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new CardioLabAssistantRole());
        return roles;
    } 
    
}
