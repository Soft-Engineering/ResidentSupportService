package residentsupportservice;

import java.time.LocalDate;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dean Rimmer
 * Appointment class used to store data with get and set methods for each value.
 */
public class Case {
    //setting local variables
    private int id;
    private CaseDepartment caseDepartment;
    private Client client;
    private User user;
    private LocalDate caseOpenDate;
    private String caseCloseDate;
    
    //Constructor for Case class
    public Case(CaseDepartment caseDepartment, Client client, User caseWorker){
        this.caseDepartment = caseDepartment;
        this.client = client;
        this.user = user;
        caseOpenDate = LocalDate.now();
    }
    
    /**
     * Getter for ID 
     * @return ID
     */
    public int getId() {
        return id;
    }
    
    /**
     * Getter for case open date
     * @return Open date
     */
    public LocalDate getCaseOpenDate() {
        return caseOpenDate;
    }
    
    /**
     * Getter for case close date
     * @return Close date
     */
    public String getCaseCloseDate() {
        return caseCloseDate;
    }
    
    /**
     * Getter for client
     * @return Client
     */
    public Client getClient() {
        return client;
    }
    
    /**
     * Getter for user
     * @return User
     */
    public User getUser() {
        return user;
    }
    
    /**
     * Getter for department
     * @return Case department
     */
    public CaseDepartment getCaseDepartment() {
        return caseDepartment;
    }
    
    /**
     * Setter for ID
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Setter for department
     * @param caseDepartment 
     */
    public void setCaseDepartment(CaseDepartment caseDepartment) {
        this.caseDepartment = caseDepartment;
    }
    
    /**
     * Setter for client
     * @param client 
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * Setter for user
     * @param user 
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Setter for case open
     * @param caseOpenDate 
     */
    public void setCaseOpenDate(LocalDate caseOpenDate) {
        this.caseOpenDate = caseOpenDate;
    }
    
    /**
     * Setter for case close
     * @param caseCloseDate 
     */
    public void setCaseCloseDate(String caseCloseDate) {
        this.caseCloseDate = caseCloseDate;
    }
    
    
    
    
    
    
}

