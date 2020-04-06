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
public class CreateNewCase {
    private String firstName;
    private String lastName;
    private String dob;
    private String phoneNumber;
    private String email;
    private String reason;
    
    public CreateNewCase(String firstName, String lastName, String email, String phoneNumber, String dob, String reason){
        firstName = this.firstName;
        lastName = this.lastName;
        email = this.email;
        phoneNumber = this.phoneNumber;
        dob = this.dob;
        reason = this.reason;
    } 
}
