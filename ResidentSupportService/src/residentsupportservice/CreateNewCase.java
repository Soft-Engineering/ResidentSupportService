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
    
    /**
     * Empty Constructor for classes that want to call methods from outside the class
     */
    public CreateNewCase(){}
    
    /**
     * Main constructor for the body of the class, triggered will automatically create a case and if needed, a client.
     * @param firstName
     * @param lastName
     * @param email
     * @param phoneNumber
     * @param dob
     * @param reason
     * @param address 
     */
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
    
    /**
     * Called in in the constructor, will check if a client already exists and create one if it does not. As well as creating a case for the client.
     * @param newClient 
     */
    private void checkAndCreate(Client newClient){
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
        unlockFields();
        eraseFields();
    }
    
    /**
     * Calls the DatabaseFunctions class to interface with the database for creating a new case.
     */
    private void createNewCase(){
        db.createNewCase(reason, client_id);
    }
    
    /**
     * Calls the DatabaseFunctions class to interface with the database for creating a new case.
     */
    private void createNewClient(){
        client_id = db.createNewClient(newClient);
    }
    
    /**
     * Locks all of the fields in the GUI, now allowing them to be changed while creating a case
     */
    public void lockFields(){
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
    
    /**
     * Unlocks all of the fields in the GUI upon completion or undo
     */
    public void unlockFields(){
        OpenNewCaseGUI.createNew.setEnabled(false);
        OpenNewCaseGUI.check.setEnabled(true);
        OpenNewCaseGUI.edit.setEnabled(false);
        OpenNewCaseGUI.edit.setVisible(false);
        OpenNewCaseGUI.address.setEnabled(true);
        OpenNewCaseGUI.caseID.setEnabled(true);
        OpenNewCaseGUI.firstName.setEnabled(true);
        OpenNewCaseGUI.lastName.setEnabled(true);
        OpenNewCaseGUI.email.setEnabled(true);
        OpenNewCaseGUI.phoneNumber.setEnabled(true);
        OpenNewCaseGUI.dob.setEnabled(true);
        OpenNewCaseGUI.reason.setEnabled(true);
    }
    
    /**
     * Empties all of the fields in the GUI upon completion or undo
     */
    public void eraseFields(){
        OpenNewCaseGUI.firstName.setText("");
        OpenNewCaseGUI.lastName.setText("");
        OpenNewCaseGUI.email.setText("");
        OpenNewCaseGUI.phoneNumber.setText("");
        OpenNewCaseGUI.dob.setText("");
        OpenNewCaseGUI.reason.setText("");
        OpenNewCaseGUI.address.setText("");
    }
}
