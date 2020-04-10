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
    private Client newClient;
    private int client_id;
    
    private DatabaseFunctions db = new DatabaseFunctions();
    
    public CreateNewCase(String firstName, String lastName, String email, String phoneNumber, String dob, String reason, String address){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.dob = dob;
        this.reason = reason;
        
        newClient = new Client(firstName, lastName, dob, address, phoneNumber, email);
        checkAndCreate(newClient);
    }
    public void checkAndCreate(Client newClient){
        int exists = db.checkIfExists(newClient);
        if(exists != -1){
            boolean similarity = db.checkReason(exists, reason);
            if(similarity = true){
                System.out.println("A user with these details and case reason already exists, please forward to case worker.");
            }else{
                System.out.println(client_id);
                client_id = exists;
                lockFields();
                createNewCase();
            }
        }else{
            System.out.println(client_id);
            lockFields();
            createNewClient();
            createNewCase();
        }
    }
    
    private boolean createNewCase(){
        System.out.println(client_id);
        db.createNewCase(reason, client_id);
        return false;
    }
    
    private boolean createNewClient(){
        System.out.println(client_id);
        client_id = db.createNewClient(newClient);
        return false;
    }
    
    private void lockFields(){
        OpenNewCaseGUI.createNew.setEnabled(true);
        OpenNewCaseGUI.check.setEnabled(false);
        OpenNewCaseGUI.edit.setEnabled(true);
        OpenNewCaseGUI.edit.setVisible(true);
        OpenNewCaseGUI.address.setEnabled(false);
        OpenNewCaseGUI.caseID.setEnabled(false);
        OpenNewCaseGUI.firstName.setEnabled(false);
        OpenNewCaseGUI.lastName.setEnabled(false);
        OpenNewCaseGUI.email.setEnabled(false);
        OpenNewCaseGUI.phoneNumber.setEnabled(false);
        OpenNewCaseGUI.dob.setEnabled(false);
        OpenNewCaseGUI.reason.setEnabled(false);
    }
}
