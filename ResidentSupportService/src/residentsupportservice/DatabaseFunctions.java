package residentsupportservice;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;


/**
 *
 * @author Kyle James Ranaghan
 * This class contains all the necessary database functions and queries
 * for the Resident Support Service application.
 */
public class DatabaseFunctions {
    private DatabaseConnection dbConnection;

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

        String newCaseDepartmentSQL = "INSERT INTO Case_Department VALUES("+null+",'"+caseDepartment.getDepartmentName()+"');" + "";

        boolean newCaseDepartmentSuccess = dbConnection.runSQL(newCaseDepartmentSQL);

        if(!newCaseDepartmentSuccess){
            System.out.print("Failed to add new case department to the database. ");
            return false;

        }
        return true;
   }

   /**
    * Check if a client already exists in the database
    *
    * @param client
    * @return Returns the userID of the user if they already exist within the database.
    */
   public int checkIfExists(Client client){


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
    * Alternate creation of a client for case generation afterwards
    *
    * @param client
    * @return Will return the id of the client that has been created in order to link their id to a case if they wish to proceed.
    */
    public int createNewClient(Client client){
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
    public boolean createNewCase(int department, int client_id){
        int ph = 1;
        String caseId = "";
        System.out.println(client_id);
        
        int caseid = -1;
        String checkcase = "SELECT case_id FROM Client_Case WHERE fk_case_client = '"+client_id+"';";
        ResultSet idcase = dbConnection.runSQLQuery(checkcase);
        try{
            caseid = idcase.getInt("case_id");
        }catch(Exception e){
            
        }
        caseid +=1;
        System.out.println(caseid);
        

        String newCaseSQL = "INSERT INTO Client_Case VALUES('"+null+"','"+ department +"' ,'"+client_id+"' , '"+ph+"' , '"+java.time.LocalDateTime.now()+"' , null );" + "";

        boolean newCaseSuccess = dbConnection.runSQL(newCaseSQL);

        if(!newCaseSuccess){
            System.out.print("Failed to add new to the database.");
            return false;
        }
        
        String checkid = "SELECT case_id FROM Client_Case WHERE fk_case_client = '"+client_id+"' and fk_case_department = '"+department+"';";
        ResultSet user = dbConnection.runSQLQuery(checkid);
        try{
            caseId = Integer.toString(user.getInt("case_id"));
        }catch(Exception e){
            
        }
        System.out.println(caseId);
        
        int appointmentid = -1;
        String checkids = "SELECT MAX(appointment_id) FROM Appointment";
        ResultSet id = dbConnection.runSQLQuery(checkids);
        try{
            appointmentid = id.getInt("appointment_id");
        }catch(Exception e){
            
        }
        appointmentid +=1;
        System.out.println(appointmentid);
        
        int waitingListCW = -1;  
        String waitingList = "INSERT INTO Appointment VALUES("+appointmentid+",'"+ caseId +"' ,'"+client_id+"' , '"+waitingListCW+"' , '"+java.time.LocalDate.now()+"' , '"+java.time.LocalTime.now()+"' , null );";
        boolean waitingListAdd = dbConnection.runSQL(waitingList);
        return true;
    }
   /**
    * Add new case to the database.
    * @param newCase
    * @return true if insertion query was successful or false if not.
    */
   public boolean addCase(Case newCase){

        String newCaseSQL = "INSERT INTO Client_Case VALUES("+null+",'"+newCase.getCaseDepartment().getId()+"' ,'"+newCase.getClient().getId()+"' , '"+newCase.getUser().getId()+"' , '"+newCase.getCaseOpenDate()+"' , '"+newCase.getCaseCloseDate()+"');" + "";

        boolean newCaseSuccess = dbConnection.runSQL(newCaseSQL);

        if(!newCaseSuccess){
            System.out.print("Failed to add new to the database. ");
            return false;
        }
        return true;
   }
   
   public ArrayList<String> outstandingAppointments(){
       String outstandingAppointmentSQL = "SELECT appointment_id, client_forename, client_surname, appointment_date, fk_case_worker FROM Appointment JOIN Client ON fk_client = client_id WHERE fk_case_worker = -1";
       ResultSet appointments = dbConnection.runSQLQuery(outstandingAppointmentSQL);
       ArrayList<String> result = new ArrayList();
       try{
            while(appointments.next()){
                result.add(appointments.getString("appointment_id"));
                result.add(appointments.getString("client_forename"));
                result.add(appointments.getString("client_surname"));
                result.add(appointments.getString("appointment_date"));
            }
            return result;
           
        }catch(Exception e){
               
        }
        return result;
    }

   /**
    *
    * @param username
    * @param password
    * @return User
    * Processes the details entered in the username and password fields of the LoginGUI
    * and returns the User and their details if the values they entered were correct.
    * Returns null if the details are incorrect and no user record is found.
    */
   public User logIn(String username, String password){
       String loginSQL = "SELECT * FROM User WHERE user_username = '"+username+"' and user_password = '"+password+"';";

       ResultSet user = dbConnection.runSQLQuery(loginSQL);

       try{
           if(user.next()){
               User loggedInUser = new User(user.getString("user_forename"), user.getString("user_surname"), user.getString("user_username"), user.getString("user_password"), user.getString("user_email"), user.getString("user_type"));
               loggedInUser.setId(user.getInt("user_id"));
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

}
