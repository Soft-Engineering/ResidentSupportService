/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package residentsupportservice;

/**
 * Handler class for CloseCaseGUI, interfaces with DatabaseFunctions
 * @author Dean
 */
public class CloseCase {
    
    private String caseID;
    private String firstName;
    private String lastName;
    private String dob;
    private DatabaseFunctions df = new DatabaseFunctions();

    /**
     * Constructor for CloseCase assuming the caseID is provided.
     * @param caseID 
     */
    public CloseCase(String caseID){
        df.closeCase(caseID);
    }
    
    /**
     * Alternative overloaded constructor for CloseCase assuming that the client details are instead provided.
     * @param firstName
     * @param lastName
     * @param dob 
     */
    public CloseCase(String firstName, String lastName, String dob){
        df.closeCase(firstName, lastName, dob);        
    }
}
