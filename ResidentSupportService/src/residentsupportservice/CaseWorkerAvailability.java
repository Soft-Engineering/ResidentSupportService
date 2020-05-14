/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package residentsupportservice;

/**
 *Class created to hold and access a case worker's availability.
 * @author Kyle Ranaghan
 */
public class CaseWorkerAvailability {
    private int caseWorkerID;
    private String date, time;
    
    /**
     * Constructor for the CaseWorkerAvailability class.
     * @param caseWorkerID
     * @param date
     * @param time 
     */
    public CaseWorkerAvailability(int caseWorkerID, String date, String time){
        this.caseWorkerID = caseWorkerID;
        this.date = date;
        this.time = time;
    }
    
    /**
     * Getter for caseWorkerID.
     * @return caseWorkerID
     */
    public int getCaseWorkerID() {
        return caseWorkerID;
    }
    
    /**
     * Getter for date
     * @return Date
     */
    public String getDate() {
        return date;
    }
    
    /**
     * Getter for time
     * @return Time
     */
    public String getTime() {
        return time;
    }

    /**
     * Setter for caseWorkerID
     * @param caseWorkerID 
     */
    public void setCaseWorkerID(int caseWorkerID) {
        this.caseWorkerID = caseWorkerID;
    }
    
    /**
     * Setter for date
     * @param date 
     */
    public void setDate(String date) {
        this.date = date;
    }
    
    /**
     * Setter for time
     * @param time 
     */
    public void setTime(String time) {
        this.time = time;
    }
}