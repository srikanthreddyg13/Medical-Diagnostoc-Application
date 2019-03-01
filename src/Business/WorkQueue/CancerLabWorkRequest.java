/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.UserAccount.UserAccount;

/**
 *
 * @author Vishaka
 */
public class CancerLabWorkRequest extends WorkRequest{
    
    private String testResult;
    private String cancerSenderEmail;
    private String cancerReceiverEmail;
    private String password;
    private String rbc;
    private String wbc;
    private String plateletCount;
    private UserAccount userAccount;
    
    public CancerLabWorkRequest(){
        //userAccount = new UserAccount();
        cancerSenderEmail = "techietribe@gmail.com";
        password = "parasites";
    }

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }
    
    public String getPassword() {
        return password;
    }

    public String getCancerSenderEmail() {
        return cancerSenderEmail;
    }

    public String getCancerReceiverEmail() {
        return cancerReceiverEmail;
    }

    public void setCancerReceiverEmail(String cancerReceiverEmail) {
        this.cancerReceiverEmail = cancerReceiverEmail;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public String getRbc() {
        return rbc;
    }

    public void setRbc(String rbc) {
        this.rbc = rbc;
    }

    public String getWbc() {
        return wbc;
    }

    public void setWbc(String wbc) {
        this.wbc = wbc;
    }

    public String getPlateletCount() {
        return plateletCount;
    }

    public void setPlateletCount(String plateletCount) {
        this.plateletCount = plateletCount;
    }
    

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }
    
    
  
}
