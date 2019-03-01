 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.UserAccount.UserAccount;
import Business.UserAccount.UserAccountDirectory;

/**
 *
 * @author MyPC1
 */
public abstract class Enterprise extends Organization{
    
    private EnterpriseType enterpriseType;
    private OrganizationDirectory organizationDirectory;
    private UserAccountDirectory userAccDir;
            
    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }

    public UserAccountDirectory getUserAccDir() {
        return userAccDir;
    }
    
    
    public enum EnterpriseType{
        Hospital("Hospital"),
        Lab("Lab");
        private String value;
        
        private EnterpriseType(String value){
            this.value=value;
        }
        public String getValue() {
            return value;
        }
        @Override
        public String toString(){
        return value;
    }
    }

    public EnterpriseType getEnterpriseType() {
        return enterpriseType;
    }

    public void setEnterpriseType(EnterpriseType enterpriseType) {
        this.enterpriseType = enterpriseType;
    }
    
    public Enterprise(String name,EnterpriseType type){
        super(name);
        this.enterpriseType=type;
        organizationDirectory=new OrganizationDirectory();
        userAccDir = new UserAccountDirectory();
    }
    
    public boolean searchOrgname(String name){
        for(Organization org : this.organizationDirectory.getOrganizationList()){
            if(org.getName().equalsIgnoreCase(name)){
                return false;
            }
        }
        return true;
    }
    
    public boolean searchUserAccname(String name){
        for(UserAccount acc : this.userAccDir.getUserAccountList()){
            if(acc.getUsername().equalsIgnoreCase(name)){
                return false;
            }
        }
        return true;
    }
    
}
