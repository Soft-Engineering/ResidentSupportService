/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package residentsupportservice;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Confirmation for an appointment which has been scheduled for a date, is used for taking appointments off of the waiting list and displays an option pane with the relevant information for the client.
 * @author Dean Rimmer
 */
public class ConfirmAssignmentExecute {
    /**
     * Constructor to be accessed and pass information to DatabaseFunctions, acts to separate in layers between interface and logic layers.
     * @param id
     * @param fname
     * @param sname
     * @param date 
     */
    public ConfirmAssignmentExecute(String id, String fname, String sname, String date){ 
        DatabaseFunctions db = new DatabaseFunctions();
        //ArrayList to hold the result.
        ArrayList<String> result = new ArrayList<String>();
        result = db.caseWorkerAvailability(id);
        JOptionPane.showMessageDialog(null, "Appointment scheduled at " + result.get(0) + result.get(1) + result.get(2) + result.get(3));
    }    
}
