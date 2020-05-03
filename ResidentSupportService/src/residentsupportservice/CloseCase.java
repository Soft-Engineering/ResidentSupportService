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
public class CloseCase {
    
    private String caseID;
    private String firstName;
    private String lastName;
    private String dob;
    private DatabaseFunctions df = new DatabaseFunctions();

    
    public CloseCase(String caseID){
        df.closeCase(caseID);
    }
    
    public CloseCase(String firstName, String lastName, String dob){
        df.closeCase(firstName, lastName, dob);        
    }
}
