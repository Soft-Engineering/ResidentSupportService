package residentsupportservice;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kyle
 */
public class CaseDepartment {
    private int id;
    private String departmentName;
    
    public CaseDepartment(String departmentName){
        this.departmentName = departmentName;
    }

    public int getId() {
        return id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    
}
