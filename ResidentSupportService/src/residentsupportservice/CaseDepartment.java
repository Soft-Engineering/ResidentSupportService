package residentsupportservice;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Case department class used for storing and accessing the name and ID assigned to a case worker's department. Mainly used in the User class.
 * @author Dean Rimmer
 */
public class CaseDepartment {
    private int id;
    private String departmentName;
    
    /**
     * Constructor for the CaseDepartment class
     * @param departmentName 
     */
    public CaseDepartment(String departmentName){
        this.departmentName = departmentName;
    }
    
    /**
     * Getter for ID
     * @return ID
     */
    public int getId() {
        return id;
    }

    /**
     * Getter for department name
     * @return Department name
     */
    public String getDepartmentName() {
        return departmentName;
    }
    
    /**
     * Setter for the ID
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Setter for the department name
     * @param departmentName 
     */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
