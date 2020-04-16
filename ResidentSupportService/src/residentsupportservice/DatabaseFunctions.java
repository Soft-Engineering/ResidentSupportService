package residentsupportservice;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;


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
            System.out.print("Failed to add new client to the database. ");
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
   public int checkIfExists(Client newClient){


       String checkClientSQL = "SELECT * FROM Client WHERE client_forename = '"+newClient.getForename()+"' and client_surname = '"+newClient.getSurname()+"' and client_address = '"+newClient.getAddress()+"';";
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

       String checkReasonSQL = "SELECT case_department FROM Client_Case JOIN User on fk_case_client = user_id WHERE user_id = '" + user + "';";
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
//    public int createNewClient(Client client){
//       String newCaseSQL = "INSERT INTO Client VALUES(null,'"+client.getForename()+"' ,'"+client.getSurname()+"' , '"+client.getDOB()+"' , '"+client.getAddress()+"' , '"+client.getPhone()+"' , '"+client.getEmail()+"' , '"+java.time.LocalDateTime.now()+"');";
//       boolean newCaseSuccess = dbConnection.runSQL(newCaseSQL);
//
//       if(newCaseSuccess){
//           return checkIfExists(client);
//       }
//       return -1;
//    }

    /**
     * Alternate creation of cases assuming the department is a string instead of an integer so the CaseDepartment object is unable to be used.
     *
     * @param department
     * @param client_id
     * @return returns true is the case is successfully created.
     */
    public boolean createNewCase(String department, int client_id){
        int ph = 1;
        System.out.println(client_id);
        String newCaseSQL = "INSERT INTO Client_Case VALUES(' ','"+ ph +"' ,'"+client_id+"' , '"+ph+"' , '"+java.time.LocalDateTime.now()+"' , null );" + "";

        boolean newCaseSuccess = dbConnection.runSQL(newCaseSQL);

        if(!newCaseSuccess){
            System.out.print("Failed to add new to the database. ");
            return false;
        }
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
