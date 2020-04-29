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
public class CaseWorkerAvailability {
    private int caseWorkerID;
    private String date, time;
    
    public CaseWorkerAvailability(int caseWorkerID, String date, String time){
        this.caseWorkerID = caseWorkerID;
        this.date = date;
        this.time = time;
    }

    public int getCaseWorkerID() {
        return caseWorkerID;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public void setCaseWorkerID(int caseWorkerID) {
        this.caseWorkerID = caseWorkerID;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
    public String toString(){
        return "";
    }
    
    
    
}
