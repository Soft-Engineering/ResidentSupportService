/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package residentsupportservice;

/**
 * Appointment class used to store data with get and set methods for each value.
 *
 * @author Dean Rimmer
 * @version 1.2
 */
public class Appointment {
    
    private int appointmentID, caseID;
    private String caseWorkerName, clientName, time, date, notes;
    
    public Appointment(){
    }
    
    /**
     * Sets the appointment ID in the class
     * @param appointmentID 
     */
    public void setAppointmentID(int appointmentID) {
        this.appointmentID = appointmentID;
    }
    
    /**
     * Sets the case ID in the class
     * @param caseID 
     */
    public void setCaseID(int caseID) {
        this.caseID = caseID;
    }
    
    /**
     * Sets the case worker name in the class
     * @param caseWorkerName 
     */
    public void setCaseWorkerName(String caseWorkerName) {
        this.caseWorkerName = caseWorkerName;
    }
    
    /**
     * Sets the client name in the class
     * @param clientName 
     */
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
    
    /**
     * Sets the time in the class
     * @param time 
     */
    public void setTime(String time) {
        this.time = time;
    }
    
    /**
     * Sets the date in the class
     * @param date 
     */
    public void setDate(String date) {
        this.date = date;
    }
    
    /**
     * Sets the notes in the class
     * @param notes 
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * Returns the appointment ID of the class
     * @return The appointment ID associated with the class
     */
    public int getAppointmentID() {
        return appointmentID;
    }
    
    /**
     * Returns the case ID
     * @return The case ID associated with the class
     */
    public int getCaseID() {
        return caseID;
    }
    
    /**
     * Returns the case worker name
     * @return The case worker name associated with the class
     */
    public String getCaseWorkerName() {
        return caseWorkerName;
    }
    
    /**
     * Returns the client name
     * @return The client name associated with the class
     */
    public String getClientName() {
        return clientName;
    }

    /**
     * Returns the time
     * @return The time associated with the class
     */
    public String getTime() {
        return time;
    }

    /**
     * Returns the date
     * @return The date associated with the class
     */
    public String getDate() {
        return date;
    }

    /**
     * Returns the notes
     * @return The notes associated with the class
     */
    public String getNotes() {
        return notes;
    }
}

