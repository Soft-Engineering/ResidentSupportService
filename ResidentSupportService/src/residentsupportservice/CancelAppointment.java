/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package residentsupportservice;

/**
 * Acts as a intermediary between DatabaseFunctions and CancelAppointmentGUI, arguments are input by the user and sent here.
 * @author Dean
 */
public class CancelAppointment {
    
    //Initialises the DatabaseFunctions for the class
    private DatabaseFunctions df = new DatabaseFunctions();
    
    /**
     * Constructor for CancelAppointment which runs in the case that the user decides to use the caseID search method.
     * @param caseID 
     */
    public CancelAppointment(String caseID){
        df.cancelAppointment(caseID);
    }
    
    /**
     * Overloads the constructor for CancelAppointment which gives the user the option to provide first name, last name, or date of birth instead of caseID.
     * @param firstName
     * @param lastName
     * @param dob 
     */
    public CancelAppointment(String firstName, String lastName, String dob){
        df.cancelAppointment(firstName, lastName, dob);        
    }
}
