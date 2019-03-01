/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.PatientAccount.PatientAccount;
import Business.UserAccount.UserAccount;
import java.util.Date;

/**
 *
 * @author raunak
 */
public abstract class WorkRequest {

    private String message;
    private UserAccount sender;
    private UserAccount receiver;
    private String status;
    private PatientAccount requestFor;
    private Date requestDate;
    private Date resolveDate;
    private String rbc;
    private String wbc;
    private String plateletCount;
    private String hemoglobin;
    private String hematocrit;
    private String pulse;
    private String carpelTunnel;
    private String nerveMotor;
    private String nerveSensory;
    
    
    public WorkRequest(){
        requestDate = new Date();
    }
    
    public PatientAccount getRequestFor() {
        return requestFor;
    }

    public void setRequestFor(PatientAccount requestFor) {
        this.requestFor = requestFor;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserAccount getSender() {
        return sender;
    }

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }

    public UserAccount getReceiver() {
        return receiver;
    }

    public void setReceiver(UserAccount receiver) {
        this.receiver = receiver;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
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

    public String getHemoglobin() {
        return hemoglobin;
    }

    public void setHemoglobin(String hemoglobin) {
        this.hemoglobin = hemoglobin;
    }

    public String getHematocrit() {
        return hematocrit;
    }

    public void setHematocrit(String hematocrit) {
        this.hematocrit = hematocrit;
    }

    public String getPulse() {
        return pulse;
    }

    public void setPulse(String pulse) {
        this.pulse = pulse;
    }

    public String getCarpelTunnel() {
        return carpelTunnel;
    }

    public void setCarpelTunnel(String carpelTunnel) {
        this.carpelTunnel = carpelTunnel;
    }

    public String getNerveMotor() {
        return nerveMotor;
    }

    public void setNerveMotor(String nerveMotor) {
        this.nerveMotor = nerveMotor;
    }

    public String getNerveSensory() {
        return nerveSensory;
    }

    public void setNerveSensory(String nerveSensory) {
        this.nerveSensory = nerveSensory;
    }
    
    

    @Override
    public String toString(){
        return message;
    }
}
