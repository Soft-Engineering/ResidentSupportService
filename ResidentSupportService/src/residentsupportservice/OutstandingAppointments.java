/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package residentsupportservice;

import java.util.ArrayList;
import javax.swing.JLabel;

/**
 *
 * @author Dean
 */
public class OutstandingAppointments {
    public ArrayList<JLabel> stringArray = new ArrayList<JLabel>();
    public OutstandingAppointments(){
        DatabaseFunctions db = new DatabaseFunctions();
        ArrayList<JLabel> stringArray = db.outstandingAppointments();
        for(int i = 0; i < stringArray.size(); i++){
            System.out.println(stringArray.get(i));
        }
        
        
    }
    public void createFrame(String id, String firstName, String lastName){
        OutstandingAppointmentsGUI newgui = new OutstandingAppointmentsGUI();
        String[] arguments = new String[] {id, firstName, lastName};
        newgui.main(arguments);
    }
}
