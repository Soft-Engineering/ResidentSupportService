/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package residentsupportservice;

import java.util.ArrayList;

/**
 *
 * @author Dean
 */
public class OutstandingAppointments {
    public OutstandingAppointments(){
        DatabaseFunctions db = new DatabaseFunctions();
        ArrayList<String> outstandingAppointments = db.outstandingAppointments();
        for(int i = 0; i < outstandingAppointments.size(); i++){
            System.out.println(outstandingAppointments.get(i));
        }
        
        
        ViewAllCasesGUI newgui = new ViewAllCasesGUI();
        String[] arguments = new String[] {"123"};
        newgui.main(arguments);
    }
}
