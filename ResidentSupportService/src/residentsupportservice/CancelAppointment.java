/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package residentsupportservice;

/**
 *
 * @author Dean
 */
public class CancelAppointment {
    
    private String caseID;
    private String firstName;
    private String lastName;
    private String dob;
    
    public CancelAppointment(String caseID){
        caseID = this.caseID;
    }
    
    public CancelAppointment(String firstName, String lastName, String dob){
        firstName = this.firstName;
        lastName = this.lastName;
        dob = this.dob;
    }
}
