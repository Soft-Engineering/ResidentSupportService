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
public class Client {
    private int id;
    private String forename, surname, dob, address, phone, email;
    private LocalDate joinDate;
    
    public Client(String forename, String surname, String dob, String address, String phone, String email)
    {
        this.forename = forename;
        this.surname = surname;
        this.dob = dob;
        this.address = address;
        this.phone = phone;
        this.email = email;
        joinDate = LocalDate.now();
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
    public LocalDate getJoinDate() {
        return joinDate;
    }

    public String getForename() {
        return forename;
    }

    public String getSurname() {
        return surname;
    }

    public String getDOB() {
        return dob;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
    
    
   
    
}
