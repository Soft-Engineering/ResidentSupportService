package residentsupportservice;

import java.time.LocalDate;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Client class which holds all information about a client. Does not include setter methods for any variable except ID as all others should be specified upon creation of the object.
 * @author Dean Rimmer
 */
public class Client {
    private int id;
    private String forename, surname, dob, address, phone, email;
    private LocalDate joinDate;
    
    /**
     * Constructor for the Client class
     * @param forename
     * @param surname
     * @param dob
     * @param address
     * @param phone
     * @param email 
     */
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

    /**
     * Setter for ID
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Getter for ID
     * @return ID
     */
    public int getId() {
        return id;
    }
    
    /**
     * Getter for join date
     * @return Join date
     */
    public LocalDate getJoinDate() {
        return joinDate;
    }

    /**
     * Getter for forename
     * @return Forename
     */
    public String getForename() {
        return forename;
    }

    /**
     * Getter for surname
     * @return Surname
     */
    public String getSurname() {
        return surname;
    }
    
    /**
     * Getter for dob
     * @return DOB
     */
    public String getDOB() {
        return dob;
    }

    /**
     * Getter for address
     * @return Address
     */
    public String getAddress() {
        return address;
    }
    
    /**
     * Getter for phone number
     * @return Phone number
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Getter for email
     * @return email
     */
    public String getEmail() {
        return email;
    }
}
