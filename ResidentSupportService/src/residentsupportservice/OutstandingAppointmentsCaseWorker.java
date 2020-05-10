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
public class OutstandingAppointmentsCaseWorker {
    public ArrayList<JLabel> labelArray = new ArrayList<JLabel>();
    public OutstandingAppointmentsCaseWorker(){      
        
    }
    /**
     * Main constructor for the class instantiates the GUI class
     * @param id
     * @param firstName
     * @param lastName 
     */
    public void createFrame(String id, String firstName, String lastName){
        OutstandingAppointmentsCaseWorkerGUI newgui = new OutstandingAppointmentsCaseWorkerGUI();
        String[] arguments = new String[] {id, firstName, lastName};
        newgui.main(arguments);
    }
    
    /**
     * Gets the outstanding appointments for the case worker
     * @param caseWorker 
     */
    public void getAppointments(String caseWorker){
        DatabaseFunctions db = new DatabaseFunctions();
        labelArray = db.outstandingAppointmentsCaseWorker(caseWorker);
    }
    
    /**
     * Gets past appointments for the case worker.
     * @param appointment 
     */
    public void getPastAppointments(String appointment){
        DatabaseFunctions db = new DatabaseFunctions();
        labelArray = db.pastAppointmentsCaseWorker(appointment);
    }
}
