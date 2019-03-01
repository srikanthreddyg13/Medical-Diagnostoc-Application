/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Doctor;

import java.util.ArrayList;

/**
 *
 * @author Srikanth Reddy
 */
public class DoctorDirectory {
    private ArrayList<Doctor> doctorList;
    

    public DoctorDirectory() {
        doctorList = new ArrayList();
        
    }

    public ArrayList<Doctor> getDoctorList() {
        return doctorList;
    }
    
    public Doctor createDoctor(String name){
        Doctor doctor = new Doctor();
        doctor.setName(name);
        doctorList.add(doctor);
        return doctor;
    }
    
}
