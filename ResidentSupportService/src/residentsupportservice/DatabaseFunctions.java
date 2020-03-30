package residentsupportservice;
import java.sql.ResultSet;
import java.sql.SQLException;

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
               User loggedInUser = new User(user.getString("user_type_new"), user.getString("user_forename"), user.getString("user_surname"), user.getString("user_username"), user.getString("user_password"), user.getString("user_email"));
               loggedInUser.setId(user.getInt("user_id"));
               return loggedInUser;
           }
           else{
               System.out.println("Your username or password was incorrect. Please try again.");
               return null;
           }
       }
       catch(SQLException error){
           System.out.println(error.getMessage());
        
       }
       return null;
       
   }
   
}