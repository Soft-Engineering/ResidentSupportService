/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package residentsupportservice;

import java.util.ArrayList;
import javax.swing.JLabel;

/**
 *Handler class to interface with DatabaseFunctions and get all cases.
 * @author Dean
 */
public class ViewAllCases {
    public ArrayList<JLabel> labelArray = new ArrayList<JLabel>();
    /**
     * Constructor to get all cases.
     */
    public ViewAllCases(){
        DatabaseFunctions db = new DatabaseFunctions();
        labelArray = db.getAllCases();       
        
    }
}
