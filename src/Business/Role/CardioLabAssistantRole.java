/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.CardiologyLabOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.LabAssistantRole.CardioLabAssistantWorkAreaJPanel;
import UserInterface.LabAssistantRole.CancerSendRequestsLabJPanel_1;
import UserInterface.LabAssistantRole.LabAssistantWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Srikanth Reddy
 */
public class CardioLabAssistantRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new CardioLabAssistantWorkAreaJPanel(userProcessContainer, account, (CardiologyLabOrganization)organization,enterprise, business);
    }
    
}
