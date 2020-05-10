/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package residentsupportservice;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Handles all of the logic from OpenNewCaseGUI and interfaces with DatabaseFunctions.
 * @author Dean
 */
public class CreateNewCase {
    private String firstName;
    private String lastName;
    private String dob;
    private String phoneNumber;
    private String email;
    private int reason;
    private int client_id;
    private Client newClient;
    private DatabaseFunctions db = new DatabaseFunctions();

    /**
     * Constructor for the CreateNewCaseClass used to call DatabaseFunctions.
     * @param firstName
     * @param lastName
     * @param email
     * @param phoneNumber
     * @param dob
     * @param reason
     * @param address 
     */
    public CreateNewCase(String firstName, String lastName, String email, String phoneNumber, String dob, int reason, String address){
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
     * Empty Constructor for class which can be sued to call alternative methods from other classes, used if an error occurs or the user decides not to commit their new case to the database.
     */
    public CreateNewCase(){
    }

    /**
     * Called in in the constructor, will check if a client already exists and create one if it does not. As well as creating a case for the client.
     * @param newClient
     */
    private void checkAndCreate(Client newClient){
        int exists = db.checkIfExists(newClient);
        if(exists != -1){
            boolean similarity = db.checkReason(exists, String.valueOf(reason));
            if(similarity = true){
                System.out.println("A user with these details and case reason already exists, please forward to case worker.");
            }else{
                client_id = exists;
                lockFields();
                createNewCase();
            }

        eraseFields();
        }
    }

    /**
     * Calls the DatabaseFunctions class to interface with the database for creating a new case.
     */
    private void createNewCase(){
        try {
            db.createNewCase(reason, client_id);
        } catch (SQLException ex) {
            Logger.getLogger(CreateNewCase.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        OpenNewCaseGUI.reason.setSelectedIndex(0);
        OpenNewCaseGUI.address.setText("");
    }
}
