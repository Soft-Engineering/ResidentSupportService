package residentsupportservice;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


/**
 *
 * @author Dean Rimmer / Kyle James Ranaghan
 * This class contains all the necessary database functions and queries
 * for the Resident Support Service application.
 */
public class DatabaseFunctions {
    private DatabaseConnection dbConnection;
    public static User loggedInUser;

    /**
     * Constructor for DatabaseFunctions, initialises a database connection used by methods.
     */
    public DatabaseFunctions(){
      dbConnection = new DatabaseConnection();
      dbConnection.connect();
    }

    /**
     * Add new client department to the database.
     * @param newClient
     * @return true if insertion query was successful or false if not.
     */
    public boolean addNewClient(Client newClient){
        //Inserts into Client using the Client class.
        String newClientSQL = "INSERT INTO Client VALUES("+null+",'"+newClient.getForename()+"' ,'"+newClient.getSurname()+"' , '"+newClient.getDOB()+"' , '"+newClient.getAddress()+"' , '"+newClient.getPhone()+"' , "
        + "'"+newClient.getEmail()+"', '"+newClient.getJoinDate().toString()+"');" + "";

        boolean newClientSuccess = dbConnection.runSQL(newClientSQL);

        if(!newClientSuccess){
            System.out.print("Failed to add new case department to the database. ");
            return false;
        }
        return true;
    }
   
    /**
     * Add new case department to the database.
     * @param caseDepartment
     * @return true if insertion query was successful or false if not.
     */
    public boolean addCaseDepartment(CaseDepartment caseDepartment){
        //Inserts into case department incase a new department is added.
        String newCaseDepartmentSQL = "INSERT INTO Case_Department VALUES("+null+",'"+caseDepartment.getDepartmentName()+"');" + "";

        boolean newCaseDepartmentSuccess = dbConnection.runSQL(newCaseDepartmentSQL);

        if(!newCaseDepartmentSuccess){
            System.out.print("Failed to add new case department to the database. ");
            return false;
        }
        return true;
    }

    /**
     *  if a client already exists in the database
     *
     * @param client
     * @return Returns the userID of the user if they already exist within the database.
     */
    public int checkIfExists(Client client){
        //Check if a client already exists using the Client class.
        String checkClientSQL = "SELECT client_id FROM Client WHERE client_forename = '"+ client.getForename() +"' AND client_surname = '" + client.getSurname() + "' AND client_address = '" + client.getAddress() +"';";
        ResultSet user = dbConnection.runSQLQuery(checkClientSQL);
        try{
            if(user.next()){
                return user.getInt("client_id");
            }
            else{
                return -1;
            }
        }
        catch(SQLException error){
            System.out.println(error.getMessage());
        }
        return -1;
    }

    /**
     * Checks if the reason the user is creating a case is the same as the creation reason provided currently.
     * @param user
     * @param reason
     * @return returns true if the user entry already exists in the same capacity of the current creation.
     */
    public boolean checkReason(int user, String reason){
        //Checks if the existing client has the same department as the new one specified.
        String checkReasonSQL = "SELECT case_department FROM Client_Case JOIN User on case_client = user_id WHERE user_id = '" + user + "';";
        ResultSet selected = dbConnection.runSQLQuery(checkReasonSQL);

        if(selected != null){
            if(selected.equals(reason)){
                return true;
            }
            return false;
        }
        return false;
    }
    
    /**
     *
     * @param ID
     * @return Returns an ArrayList containing a list of strings representing dates
     * that the case worker is scheduled to work.
     */
    public ArrayList<String> seeAvailability (int ID){
        //Selects dates from case_worker_availability in a specific case worker.
        String availabilitySQL = "SELECT DISTINCT date FROM Case_Worker_Availability WHERE fk_case_worker = '"+ID+"'";
        ResultSet timeSlots = dbConnection.runSQLQuery(availabilitySQL);
        ArrayList<String> dates = new ArrayList<String>();
        try{
            while(timeSlots.next()){
                dates.add(new String(timeSlots.getString("date")));
            }
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return dates;
    }
    
    /**
     * Removes a date from the case worker availability.
     * @param date
     * @return returns a boolean depending on success of the query.
     */
    public boolean removeAvailability(String date){
        //Deletes a specific availability from a case worker.
        String removeDate = "DELETE FROM Case_Worker_Availability WHERE date = '"+date+"'";
        boolean removeDateSuccess = dbConnection.runSQL(removeDate);
        if(!removeDateSuccess){
            System.out.println("Couldn't remove date. SQL failed.");
            return false;
        }
        return true;
    }

    /**
     * Alternate creation of a client for case generation afterwards
     *
     * @param client
     * @return Will return the id of the client that has been created in order to link their id to a case if they wish to proceed.
     */
    public int createNewClient(Client client){
        //Inserts into client and returns depending on whether the client now exists, alternate usage.
        String newCaseSQL = "INSERT INTO Client VALUES(null,'"+client.getForename()+"' ,'"+client.getSurname()+"' , '"+client.getDOB()+"' , '"+client.getAddress()+"' , '"+client.getPhone()+"' , '"+client.getEmail()+"' , '"+java.time.LocalDateTime.now()+"');";
        boolean newCaseSuccess = dbConnection.runSQL(newCaseSQL);

        if(newCaseSuccess){
            return checkIfExists(client);
        }
        return -1;
    }

    /**
     * Alternate creation of cases assuming the department is a string instead of an integer so the CaseDepartment object is unable to be used.
     *
     * @param department
     * @param client_id
     * @return returns true is the case is successfully created.
     */
    public boolean createNewCase(int department, int client_id) throws SQLException{

        int ph = 1;
        String caseId = "";
        System.out.println(client_id);

        int caseid = -1;
        //Slects the same ID from a client.
        String checkcase = "SELECT case_id FROM Client_Case WHERE fk_case_client = '"+client_id+"';";
        ResultSet idcase = dbConnection.runSQLQuery(checkcase);
        try{
            caseid = idcase.getInt("case_id");
        }catch(Exception e){
        }
        
        caseid +=1;
        System.out.println(caseid);
        //Gets the next case_id usable.
        String getID = "SELECT MAX(case_id)+1 AS max_id FROM Client_Case";
        int nextID =0;
        try {
            ResultSet maxIDSuccess = dbConnection.runSQLQuery(getID);
            if(maxIDSuccess.getInt("max_id") == 0){
                nextID = 1;
            }
            else{
                nextID = maxIDSuccess.getInt("max_id");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        //Inserts into Client_Case with no case worker (on waiting list).
        String newCaseSQL = "INSERT INTO Client_Case VALUES('"+nextID+"','"+ department +"' ,'"+client_id+"' , '"+ph+"' , '"+java.time.LocalDateTime.now()+"' , null );" + "";

        boolean newCaseSuccess = dbConnection.runSQL(newCaseSQL);

        if(!newCaseSuccess){
            System.out.print("Failed to add new to the database.");
            return false;
        }
        //Gets case_if from newly added client.
        String checkid = "SELECT case_id FROM Client_Case WHERE fk_case_client = '"+client_id+"' and fk_case_department = '"+department+"';";
        ResultSet user = dbConnection.runSQLQuery(checkid);
        try{
            caseId = Integer.toString(user.getInt("case_id"));
        }catch(Exception e){
        }

        int appointmentid = 0;
        //Selects the next available appointmenr_id.
        String checkids = "SELECT Count(*) AS appointment_next FROM Appointment";
        try {
            ResultSet AppointmentIDSuccess = dbConnection.runSQLQuery(checkids);
            if(AppointmentIDSuccess.getInt("appointment_next") == 0){
                appointmentid = 1;
            }
            else{
                appointmentid = AppointmentIDSuccess.getInt("appointment_next");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(appointmentid);

        int waitingListCW = -1;
        //Inserts into Appointment with no case worker (on waiting list).
        String waitingList = "INSERT INTO Appointment VALUES("+appointmentid+",'"+ caseId +"' ,'"+client_id+"' , '"+waitingListCW+"' , '"+java.time.LocalDate.now()+"' , '"+java.time.LocalTime.now()+"' , null );";
        boolean waitingListAdd = dbConnection.runSQL(waitingList);
        dbConnection.close();
        return true;
    }
    
    /**
     * Add new case to the database.
     * @param newCase
     * @return true if insertion query was successful or false if not.
     */
    public boolean addCase(Case newCase){
        //Inserts into Case using the Case class.
        String newCaseSQL = "INSERT INTO Client_Case VALUES("+null+",'"+newCase.getCaseDepartment().getId()+"' ,'"+newCase.getClient().getId()+"' , '"+newCase.getUser().getId()+"' , '"+newCase.getCaseOpenDate()+"' , '"+newCase.getCaseCloseDate()+"');" + "";

        boolean newCaseSuccess = dbConnection.runSQL(newCaseSQL);

        if(!newCaseSuccess){
            System.out.print("Failed to add new to the database. ");
            return false;
        }
        return true;
    }

    /**
     * Will find all cases on the waiting list and return them.
     * @return An ArrayList of waiting list cases
     */
    public ArrayList<JLabel> outstandingAppointments(){
        //Gets appointment details where clients are on the waiting list.
        String outstandingAppointmentSQL = "SELECT appointment_id, client_forename, client_surname, appointment_date, fk_case_worker FROM Appointment JOIN Client ON fk_client = client_id WHERE fk_case_worker = -1";
        ResultSet appointments = dbConnection.runSQLQuery(outstandingAppointmentSQL);
        ArrayList<JLabel> result = new ArrayList();
        JLabel j = new JLabel("");
        try{
             while(appointments.next()){
                 j.setText(appointments.getString("appointment_id") + "\n" + appointments.getString("client_forename") + "\n" + appointments.getString("client_surname")
                 + "\n" + appointments.getString("appointment_date"));
                 result.add(j);
//                j.setText(appointments.getString("client_forename"));
//                result.add(j);
//                j.setText(appointments.getString("client_surname"));
//                result.add(j);
//                j.setText(appointments.getString("appointment_date"));
//                result.add(j);
            }
            return result;

        }catch(Exception e){
        }
        return result;
    }

    /**
     * Returns all appointments for a case worker within the next two weeks.
     * @param caseWorker
     * @return Client details in a JLabel ready for addition to a panel.
     */
    public ArrayList<JLabel> outstandingAppointmentsCaseWorker(String caseWorker){

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);
        Date currentDatePlusOne = c.getTime();
        String cd = dateFormat.format(currentDatePlusOne);
        System.out.println(currentDatePlusOne);
        //Selects appointments that are in the future or today for the case worker.
        String outstandingAppointmentSQL = "SELECT fk_case, appointment_id, client_forename, client_surname, appointment_date, appointment_time, fk_case_worker FROM Appointment JOIN Client ON fk_client = client_id WHERE fk_case_worker = '"+caseWorker+"' AND "
               + "appointment_date >= '"+cd+"';";
        ResultSet appointments = dbConnection.runSQLQuery(outstandingAppointmentSQL);
        ArrayList<JLabel> result = new ArrayList();
        try{
            while(appointments.next()){
                JLabel j = new JLabel("");
                j.setText(appointments.getString("client_forename") + " " +"\n" + appointments.getString("client_surname") + " " + "\n" + appointments.getString("appointment_date") + " "
                + "\n" + appointments.getString("appointment_time") + " " + "\n" + appointments.getString("fk_case"));
                result.add(j);
            }
            return result;

        }catch(Exception e){
        }
        return result;
    }

    /**
     * Returns all previous appointments for a case worker.
     * @param caseWorker
     * @return Client details in a JLabel ready for addition to a panel.
     */
    public ArrayList<JLabel> pastAppointmentsCaseWorker(String caseID){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);
        Date currentDatePlusOne = c.getTime();
        String cd = dateFormat.format(currentDatePlusOne);
        //Gets past appointments for a specific case worker.
        String outstandingAppointmentSQL = "SELECT appointment_id, appointment_date, appointment_time, appointment_notes FROM Appointment WHERE fk_case = '"+caseID+"' AND appointment_date <= '"+cd+"';";
        ResultSet appointments = dbConnection.runSQLQuery(outstandingAppointmentSQL);
        ArrayList<JLabel> result = new ArrayList();
        try{
            while(appointments.next()){
                JLabel j = new JLabel("");
                j.setText(appointments.getString("appointment_date") + " " +"\n" + appointments.getString("appointment_id") + " " +"\n" + appointments.getString("appointment_time") + " " + "\n"+  appointments.getString("appointment_notes"));
                result.add(j);
            }
            return result;

        }catch(Exception e){
        }
        return result;
    }

    /**
     * Amends the notes of a case 
     * @param notesText
     * @param appointmentID
     * @return True if successful.
     */
    public boolean ammendNotes(String notesText, String appointmentID){
        //Ammends notes on a specific appointment.
        String ammendSQL = "UPDATE Appointment SET appointment_notes = '"+notesText+"' WHERE appointment_id = '"+appointmentID+"';";
        boolean ammendSuccess = dbConnection.runSQL(ammendSQL);
        //On a successful comment allows the case worker to close the case.
        if(ammendSuccess){
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "Would you also like to close this case?", "Title on Box", dialogButton);
            if(dialogResult == 0) {
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date currentDate = new Date();
                Calendar c = Calendar.getInstance();
                c.setTime(currentDate);
                Date currentDatePlusOne = c.getTime();
                String cd = dateFormat.format(currentDatePlusOne);
                String caseID = "";
                //Gets the whole case from the appointment.
                String caseIDSQL = "SELECT fk_case FROM Appointment WHERE appointment_id = '"+appointmentID+"';";
                ResultSet appointmenttype = dbConnection.runSQLQuery(caseIDSQL);
                try {
                    caseID = appointmenttype.getString("fk_case");
                } catch (SQLException ex) {
                    Logger.getLogger(DatabaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
                }
                //Closes the case.
                String closeCaseSQL = "UPDATE Client_Case SET case_close_date = '"+cd+"' WHERE case_id = '"+caseID+"';";
                boolean closeCase = dbConnection.runSQL(closeCaseSQL);
            } else {
                return true;
            }
           return true;
        }
        return false;
    }

    /**
     * Given an appointment_id will find a viable case worker and assign their availability (assuming it exists) will assign them an appointment.
     * @param appointmentID
     * @return Details of the new appointment.
     */
    public ArrayList<String> caseWorkerAvailability(String appointmentID){
        ArrayList<String> result = new ArrayList<String>();

        //get type of appointment for assignment
        String type = "";
        String caseID = "";
        String appointmenttypeSQL = "SELECT fk_case_department, appointment_id, case_id FROM Client_Case JOIN Appointment ON fk_case = case_id WHERE appointment_id = '"+appointmentID+"';";
        ResultSet appointmenttype = dbConnection.runSQLQuery(appointmenttypeSQL);
        try {
            type = appointmenttype.getString("fk_case_department");
            caseID = appointmenttype.getString("case_id");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }

        //cross reference type of appointment with available case workers
        String caseworkerid = "";
        String availabilityid = "";
        String date ="";
        String time = "";
        
        //Date formatting to what is added into the database.
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);
        c.add(Calendar.DAY_OF_MONTH, 1);
        Date currentDatePlusOne = c.getTime();
        c.add(Calendar.DAY_OF_MONTH, 13);
        Date currentDatePlusTwoWeeks = c.getTime();
        String cd = dateFormat.format(currentDatePlusOne);
        String ld = dateFormat.format(currentDatePlusTwoWeeks);

        //Selects a case worker's availability within the next two weeks for the corresponding case type.
        String caseworkersSQL = "SELECT a.availability_id, a.fk_case_worker, b.fk_dep_id, a.date, a.time "
                + "FROM Case_Worker_Availability AS 'a' "
                + "JOIN Case_Department_Members AS 'b' "
                + "on a.fk_case_worker = b.fk_case_worker "
                + "WHERE date "
                + "BETWEEN '"+cd+"' and '"+ld+"' "
                + "and fk_dep_id = "+type+";";
        ResultSet caseworkers = dbConnection.runSQLQuery(caseworkersSQL);
        try {
            caseworkerid = caseworkers.getString("fk_case_worker");
            availabilityid = caseworkers.getString("availability_id");
            date = caseworkers.getString("date");
            time = caseworkers.getString("time");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }

        String fname = "";
        String lname = "";
        //Selects the vase worker's name from the ID
        String caseWorkerName = "SELECT user_forename, user_surname FROM User WHERE user_id = '"+caseworkerid+"';";
        ResultSet cwname = dbConnection.runSQLQuery(caseWorkerName);
        try {
            fname = cwname.getString("user_forename");
            lname = cwname.getString("user_surname");
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Series of 3 queries which assign the case worker to both the client and the appointment and delete the availability from the database.
        String appointmentUpdateSQL = "UPDATE Appointment SET fk_case_worker = '"+caseworkerid+"', appointment_date = '"+date+"', appointment_time = '"+time+"' WHERE appointment_id = '"+appointmentID+"';";
        boolean appointmentSuccess = dbConnection.runSQL(appointmentUpdateSQL);
        String caseUpdateSQL = "UPDATE Client_Case SET fk_case_worker = '"+caseworkerid+"' WHERE case_id = '"+caseID+"';";
        boolean caseSuccess = dbConnection.runSQL(caseUpdateSQL);
        String deleteAppointment = "DELETE FROM Case_Worker_Availability WHERE availability_id = '"+availabilityid+"';";
        boolean deleteappointment = dbConnection.runSQL(deleteAppointment);
        try {
            dbConnection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }
        result.add(date);
        result.add(time);
        result.add(fname);
        result.add(lname);
        return result;
    }

    /**
     * Processes the details entered in the username and password fields of the LoginGUI
     * and returns the User and their details if the values they entered were correct.
     * Returns null if the details are incorrect and no user record is found.
     * @param username
     * @param password
     * @return User
     * 
     */
    public User logIn(String username, String password){
        //Selects the correct login details for the user.
        String loginSQL = "SELECT * FROM User WHERE user_username = '"+username+"' and user_password = '"+password+"';";

        ResultSet user = dbConnection.runSQLQuery(loginSQL);

        try{
            if(user.next()){
                loggedInUser = new User(user.getString("user_forename"), user.getString("user_surname"), user.getString("user_username"), user.getString("user_password"), user.getString("user_email"), user.getString("user_type"));
                loggedInUser.setId(user.getInt("user_id"));
                dbConnection.close();
                return loggedInUser;
            }
            else{
                //System.out.println("Your username or password was incorrect. Please try again.");
                return null;
            }
        }
        catch(SQLException error){
            System.out.println(error.getMessage());

        }
        return null;
    }

    /**
     * Creates a follow up appointment.
     * @param caseID
     * @return True if successful.
     */
    public boolean createFollowUpWithID(String caseID){
        String client = "";
        String caseWorker = "";
        String availabilityID = "";
        //Gets the client and case worker of a case.
        String followUpSQL = "SELECT fk_case_client, fk_case_worker FROM Client_Case WHERE case_id = '"+caseID+"';";
        ResultSet followUpIds = dbConnection.runSQLQuery(followUpSQL);
        try {
            if(followUpIds.next()){
                client = followUpIds.getString("fk_case_client");
                caseWorker = followUpIds.getString("fk_case_worker");
            }else{
                JOptionPane.showMessageDialog(null, "No client with caseID: " + caseID + " Found.\nPlease contact support service admin.");
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Selects the next appointment_id available.
        String getID = "SELECT COUNT(*) AS max_id FROM Appointment";
        int nextID =0;
        try {

            ResultSet maxIDSuccess = dbConnection.runSQLQuery(getID);
            if(maxIDSuccess.getInt("max_id") == 0){
                nextID = 1;
            }
            else{
                nextID = maxIDSuccess.getInt("max_id");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        String date ="";
        String time = "";
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);
        c.add(Calendar.DAY_OF_MONTH, 1);
        Date currentDatePlusOne = c.getTime();
        c.add(Calendar.DAY_OF_MONTH, 13);
        Date currentDatePlusTwoWeeks = c.getTime();
        String cd = dateFormat.format(currentDatePlusOne);
        String ld = dateFormat.format(currentDatePlusTwoWeeks);
        //Selects availability for next two weeks of a case worker.
        String caseworkersSQL = "SELECT availability_id, date, time FROM Case_Worker_Availability WHERE date BETWEEN '"+cd+"' and '"+ld+"' and fk_Case_Worker = '"+caseWorker+"';";
        ResultSet caseworkers = dbConnection.runSQLQuery(caseworkersSQL);
        try {
            if(caseworkers.next()){
            date = caseworkers.getString("date");
            time = caseworkers.getString("time");
            availabilityID = caseworkers.getString("availability_id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Inserts a new appointment
        String appointmentUpdateSQL = "INSERT INTO Appointment VALUES('"+nextID+"','"+caseID+"','"+client+"','"+caseWorker+"','"+date+"','"+time+"','');";
        boolean appointmentSuccess = dbConnection.runSQL(appointmentUpdateSQL);

        if(appointmentSuccess){
            //Deleted the availability used.
            String deleteAppointment = "DELETE FROM Case_Worker_Availability WHERE availability_id = '"+availabilityID+"';";
            boolean deleteappointment = dbConnection.runSQL(deleteAppointment);
        }

        try {
            dbConnection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }
        return appointmentSuccess;
    }

    /**
     * Creates a follow up appointment.
     * @param firstName
     * @param lastName
     * @param dob
     * @return True if successful.
     */
    public boolean createFollowUpWithoutID(String firstName, String lastName, String dob){
        String client = "";
        String caseWorker = "";
        String caseID = "";
        String availabilityID = "";
        //selects client and case using user details.
        String followUpSQL = "SELECT case_id, fk_case_client, fk_case_worker FROM Client JOIN Client_Case ON client_id = fk_case_client WHERE client_forename = '"+firstName+"' AND client_surname = '"+lastName+"' AND client_dob='"+dob+"';";
        ResultSet followUpWithCase = dbConnection.runSQLQuery(followUpSQL);

        try {
            if(followUpWithCase.next()){
                client = followUpWithCase.getString("fk_case_client");
                caseWorker = followUpWithCase.getString("fk_case_worker");
                caseID = followUpWithCase.getString("case_ID");
            }else{
                JOptionPane.showMessageDialog(null, "No client with credentials: " + firstName + " " + lastName + "\n" + "DOB: " + dob + " Found.\nPlease contact support service admin.");
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Selects next available appointment_id.
        String getID = "SELECT COUNT(*) AS max_id FROM Appointment";
        int nextID =0;
        try {
            ResultSet maxIDSuccess = dbConnection.runSQLQuery(getID);

            if(maxIDSuccess.getInt("max_id") == 0){
                nextID = 1;
            }
            else{
                nextID = maxIDSuccess.getInt("max_id");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        String date ="";
        String time = "";
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);
        c.add(Calendar.DAY_OF_MONTH, 1);
        Date currentDatePlusOne = c.getTime();
        c.add(Calendar.DAY_OF_MONTH, 13);
        Date currentDatePlusTwoWeeks = c.getTime();
        String cd = dateFormat.format(currentDatePlusOne);
        String ld = dateFormat.format(currentDatePlusTwoWeeks);
        //Seletc availability details of a case worker for the next 2 weeks
        String caseworkersSQL = "SELECT availability_id, date, time FROM Case_Worker_Availability WHERE date BETWEEN '"+cd+"' and '"+ld+"' and fk_Case_Worker = '"+caseWorker+"';";
        ResultSet caseworkers = dbConnection.runSQLQuery(caseworkersSQL);
        try {
            if(caseworkers.next()){
            date = caseworkers.getString("date");
            time = caseworkers.getString("time");
            availabilityID = caseworkers.getString("availability_id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Inserts the new appointment
        String appointmentUpdateSQL = "INSERT INTO Appointment VALUES('"+nextID+"','"+caseID+"','"+client+"','"+caseWorker+"','"+date+"','"+time+"','');";
        boolean appointmentSuccess = dbConnection.runSQL(appointmentUpdateSQL);

        if(appointmentSuccess){
            //Deletes the used availability.
            String deleteAppointment = "DELETE FROM Case_Worker_Availability WHERE availability_id = '"+availabilityID+"';";
            boolean deleteappointment = dbConnection.runSQL(deleteAppointment);
        }

        try {
            dbConnection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }
        return appointmentSuccess;
    }

    /**
     * Closes a case
     * @param caseID
     * @return true if successful
     */
    public boolean closeCase(String caseID){
        String client = "";
        String caseWorker = "";
        String availabilityID = "";
        Date currentDate = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);
        Date currentDatePlusOne = c.getTime();
        String cd = dateFormat.format(currentDatePlusOne);
        //Closes the case given a case_id
        String closeSQL = "UPDATE Client_Case SET case_close_date = '"+cd+"' WHERE case_id = '"+caseID+"';";

        boolean closeCase = dbConnection.runSQL(closeSQL);
        try {
            dbConnection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }
        return closeCase;
    }
    
    /**
     * Closes a case.
     * @param firstName
     * @param lastName
     * @param dob
     * @return True if successful.
     */
    public boolean closeCase(String firstName, String lastName, String dob){
        String client = "";
        String caseWorker = "";
        String caseID = "";
        String availabilityID = "";
        Date currentDate = new Date();
        Calendar c = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        c.setTime(currentDate);
        Date currentDatePlusOne = c.getTime();
        String cd = dateFormat.format(currentDatePlusOne);
        //Gets the case_id given user details
        String getIDSQL = "SELECT case_id FROM Client JOIN Client_Case ON client_id = fk_case_client WHERE client_forename = '"+firstName+"' AND client_surname = '"+lastName+"' AND client_dob='"+dob+"';";
        ResultSet getID = dbConnection.runSQLQuery(getIDSQL);

        try {
            if(getID.next()){
                caseID = getID.getString("case_ID");
            }else{
                JOptionPane.showMessageDialog(null, "No client with credentials: " + firstName + " " + lastName + "\n" + "DOB: " + dob + " Found.\nPlease contact support service admin.");
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Closes the case given a case_id 
        String closeCaseSQL = "UPDATE Client_Case SET case_close_date = '"+cd+"' WHERE case_id = '"+caseID+"';";
        boolean closeCase = dbConnection.runSQL(closeCaseSQL);
        try {
            dbConnection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }
        return closeCase;
    }
   
    /**
     * Gets all case workers.
     * @return List of all case workers.
     */
    public ArrayList<String> getAllCaseWorkers(){
        dbConnection = new DatabaseConnection();
        //Selects all case workers
        String getCaseWorkersSQL = "SELECT * FROM User WHERE user_type = 'Case worker';";
        ResultSet caseWorkers = dbConnection.runSQLQuery(getCaseWorkersSQL);
        ArrayList<String> caseWorkerNames = new ArrayList<String>();
        try {
            while(caseWorkers.next()){
                caseWorkerNames.add(caseWorkers.getString("user_forename") + " " + caseWorkers.getString("user_surname"));
            }
        } 
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            dbConnection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }
        return caseWorkerNames;
    }

    /**
     * Finds a case worker given their name.
     * @param name
     * @return The case worker ID.
     */
    public int findCaseWorker(String name){
        dbConnection = new DatabaseConnection();
        //Selects the suer_id given the user's name.
        String caseWorkerSQL = "SELECT user_id FROM User WHERE user_forename || ' ' || user_surname = '"+name+"';";
        ResultSet userID = dbConnection.runSQLQuery(caseWorkerSQL);
        try {
            if (userID.next()){
                int ID = userID.getInt("user_id");
                dbConnection.close();
                return ID;
            }
            else{
                System.out.println("Case worker doesn't exist.");
            }
        } 
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return -1;
    }

    /**
     * Selects details from all cases.
     * @return List of JLabels containing all information about all cases.
     */
    public ArrayList<JLabel> getAllCases(){
        //Selects all cases.
        String outstandingAppointmentSQL = "SELECT case_id, client_forename, client_surname, case_open_date FROM Client JOIN Client_Case on fk_case_client = client_id";
        ResultSet appointments = dbConnection.runSQLQuery(outstandingAppointmentSQL);
        ArrayList<JLabel> result = new ArrayList();
        try{
            while(appointments.next()){
                JLabel j = new JLabel("");
                j.setText(appointments.getString("case_id") + " " +"\n" + appointments.getString("client_forename") + " " + "\n" + appointments.getString("client_surname") + " "
                + "\n" + appointments.getString("case_open_date"));
                result.add(j);
            }
            return result;

        }catch(Exception e){
        }
        return result;
    }

    /**
     * Cancels an appointment
     * @param caseID
     * @return True if successful
     */
    public boolean cancelAppointment(String caseID){
        String client = "";
        String caseWorker = "";
        String availabilityID = "";
        Date currentDate = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);
        Date currentDatePlusOne = c.getTime();
        String cd = dateFormat.format(currentDatePlusOne);
        //Deletes an appointment given a case_id.
        String closeSQL = "DELETE FROM Appointment WHERE appointment_date >= '"+cd+"' AND fk_case = '"+caseID+"';";

        boolean closeCase = dbConnection.runSQL(closeSQL);
        try {
            dbConnection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }
        return closeCase;
    }
    
    /**
     * Cancels an appointment
     * @param firstName
     * @param lastName
     * @param dob
     * @return True if successful.
     */
    public boolean cancelAppointment(String firstName, String lastName, String dob){
        String client = "";
        String caseWorker = "";
        String caseID = "";
        String availabilityID = "";
        Date currentDate = new Date();
        Calendar c = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        c.setTime(currentDate);
        Date currentDatePlusOne = c.getTime();
        String cd = dateFormat.format(currentDatePlusOne);
        //Selects a case_id given a client's name.
        String getIDSQL = "SELECT case_id FROM Client JOIN Client_Case ON client_id = fk_case_client WHERE client_forename = '"+firstName+"' AND client_surname = '"+lastName+"' AND client_dob='"+dob+"';";
        ResultSet getID = dbConnection.runSQLQuery(getIDSQL);

        try {
            if(getID.next()){
                caseID = getID.getString("case_ID");
            }else{
                JOptionPane.showMessageDialog(null, "No client with credentials: " + firstName + " " + lastName + "\n" + "DOB: " + dob + " Found.\nPlease contact support service admin.");
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Deletes an appointment given a case_id.
        String closeCaseSQL = "DELETE FROM Appointment WHERE appointment_date >= '"+cd+"' AND fk_case = '"+caseID+"';";
        boolean closeCase = dbConnection.runSQL(closeCaseSQL);
        try {
            dbConnection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseFunctions.class.getName()).log(Level.SEVERE, null, ex);
        }
        return closeCase;
    }
}