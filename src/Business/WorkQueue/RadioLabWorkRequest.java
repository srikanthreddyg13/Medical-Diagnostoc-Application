/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author Vishaka
 */
public class RadioLabWorkRequest extends WorkRequest{
    
    private String testResult;
    private String radioSenderEmail;
    private String radioReceiverEmail;
    private String password;

    public RadioLabWorkRequest() {
        radioSenderEmail = "techietribe007@gmail.com";
        password = "parasites";
    }
    
    

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }

    public String getRadioSenderEmail() {
        return radioSenderEmail;
    }

    public void setRadioReceiverEmail(String radioReceiverEmail) {
        this.radioReceiverEmail = radioReceiverEmail;
    }
    
    

    public String getRadioReceiverEmail() {
        return radioReceiverEmail;
    }

    public String getPassword() {
        return password;
    }
    
    
    
}
