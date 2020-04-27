/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package residentsupportservice;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Dean
 */
public class ConfirmAssignmentExecute {
    public ConfirmAssignmentExecute(String id, String fname, String sname, String date){
        DatabaseFunctions db = new DatabaseFunctions();
        ArrayList<String> result = new ArrayList<String>();
        result = db.caseWorkerAvailability(id);
        JOptionPane.showMessageDialog(null, "Appointment scheduled at " + result.get(0) + result.get(1) + "\n" + "With" + result.get(2) + " " + result.get(3));
    }    
}
