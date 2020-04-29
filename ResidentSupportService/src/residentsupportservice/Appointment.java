/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package residentsupportservice;

/**
 *
 * @author kyler
 */
public class Appointment {
    private int appointmentID, caseID;
    private String caseWorkerName, clientName, time, date, notes;
public Appointment(){
    
}

    public void setAppointmentID(int appointmentID) {
        this.appointmentID = appointmentID;
    }

    public void setCaseID(int caseID) {
        this.caseID = caseID;
    }

    public void setCaseWorkerName(String caseWorkerName) {
        this.caseWorkerName = caseWorkerName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getAppointmentID() {
        return appointmentID;
    }

    public int getCaseID() {
        return caseID;
    }

    public String getCaseWorkerName() {
        return caseWorkerName;
    }

    public String getClientName() {
        return clientName;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }

    public String getNotes() {
        return notes;
    }
}

