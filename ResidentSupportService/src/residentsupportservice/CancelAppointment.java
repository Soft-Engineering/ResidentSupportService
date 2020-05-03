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
    
    private DatabaseFunctions df = new DatabaseFunctions();

    
    public CancelAppointment(String caseID){
        df.CancelAppointment(caseID);
    }
    
    public CancelAppointment(String firstName, String lastName, String dob){
        df.CancelAppointment(firstName, lastName, dob);        
    }
}
