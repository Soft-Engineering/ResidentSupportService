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
    private Client newClient;
    private DatabaseFunctions db = new DatabaseFunctions();
    
    /**
     * Main constructor for the body of the class, triggered will automatically create a case and if needed, a client.
     */
    public CreateNewCase(String firstName, String lastName, String email, String phoneNumber, String dob, String reason, String address){   
        newClient = new Client(firstName, lastName, dob, address, phoneNumber, email);
        checkAndCreate(newClient);
    }
    
    /**
     * Called in in the constructor, will check if a client already exists and create one if it does not. As well as creating a case for the client.
     * @param newClient 
     */
    private void checkAndCreate(Client newClient){
        int exists = db.checkIfExists(newClient);
        if(exists == -1){
            System.out.println("Client doesn't exist.");
            db.addNewClient(newClient);
            }
        else{
            System.out.println(exists); 
            
        }
        eraseFields();
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
