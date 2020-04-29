package residentsupportservice;

import java.time.LocalDate;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kyle
 */
public class Case {
    private int id;
    private CaseDepartment caseDepartment;
    private Client client;
    private User user;
    private LocalDate caseOpenDate;
    private String caseCloseDate;
    
    public Case(CaseDepartment caseDepartment, Client client, User caseWorker){
        this.caseDepartment = caseDepartment;
        this.client = client;
        this.user = user;
        caseOpenDate = LocalDate.now();
    }

    public int getId() {
        return id;
    }
    
    public LocalDate getCaseOpenDate() {
        return caseOpenDate;
    }

    public String getCaseCloseDate() {
        return caseCloseDate;
    }
    

    public Client getClient() {
        return client;
    }

    public User getUser() {
        return user;
    }

    public CaseDepartment getCaseDepartment() {
        return caseDepartment;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCaseDepartment(CaseDepartment caseDepartment) {
        this.caseDepartment = caseDepartment;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCaseOpenDate(LocalDate caseOpenDate) {
        this.caseOpenDate = caseOpenDate;
    }

    public void setCaseCloseDate(String caseCloseDate) {
        this.caseCloseDate = caseCloseDate;
    }
    
    
    
    
    
    
}

