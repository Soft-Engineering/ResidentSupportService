/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package residentsupportservice;

/**
 * Edit appointment class for interface between GUI and DatabaseFunctions
 * @author Dean
 */
public class EditAppointment {
    private String caseID;
    private String firstName;
    private String lastName;
    private String dob;
    
    /**
     * Constructor for the class assuming the user has the case ID.
     * @param caseID 
     */
    public EditAppointment(String caseID){
        caseID = this.caseID;
    }
    
    /**
     * Constructor for the class assuming the user has first name, last name, and dob.
     * @param firstName
     * @param lastName
     * @param dob 
     */
    public EditAppointment(String firstName, String lastName, String dob){
        firstName = this.firstName;
        lastName = this.lastName;
        dob = this.dob;
    }
}
