/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.NeurologyLabOrganization;
import Business.Organization.Organization;
import Business.Organization.RadiologyLabOrganization;
import Business.UserAccount.UserAccount;
import UserInterface.LabAssistantRole.LabAssistantWorkAreaJPanel;
import UserInterface.LabAssistantRole.RadioLabAssistantWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Srikanth Reddy
 */
public class RadioLabAssistantRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new RadioLabAssistantWorkAreaJPanel(userProcessContainer, account, (RadiologyLabOrganization)organization,enterprise, business);
    }
    
}
