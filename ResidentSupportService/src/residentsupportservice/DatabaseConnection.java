package residentsupportservice;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Kyle Ranaghan
 */
public class DatabaseConnection {
    private Connection conn;
    
    public DatabaseConnection(){
        conn = null;
        connect();
    }
    
    public boolean connect(){
        try{
            String url = "jdbc:sqlite:" + ".\\Database\\ResidentSupportService.db";
            conn = DriverManager.getConnection(url);
        }
        catch(SQLException error){
            System.out.println("Failed to connect to database.");
            System.out.println(error.getMessage());
            return false;
        }
        return true;
    }
    
    public boolean runSQL(String sql){
        if(conn == null){
            System.out.println("There is no database connection. Cannot run SQL");
            return false;
        }
        try{
            Statement sqlStatement = conn.createStatement();
            sqlStatement.execute(sql);
        }
        catch(SQLException error){
            System.out.println("Failed to execute SQL.");
            System.out.println(error.getMessage());
            return false;
        }
        return true;
    }
    
    public ResultSet runSQLQuery(String sql){
        ResultSet result;
        if(conn == null){
            System.out.println("There is no database connection. Cannot run SQL");
            return null;
        }
        try{
            Statement sqlStatement = conn.createStatement();
            result = sqlStatement.executeQuery(sql);
        }
        catch(SQLException e){
	   System.out.println("Failed to execute SQL");
           System.out.println(e.getMessage());
           return null;
        }
        return result;
        
    }
    
    public Connection getConnection(){
        if(conn == null){
            System.out.println("No database connection.");
            return null;
        }
        return conn;
    }
    
    public void close(){
        try{
            conn.close();
        }
        catch(SQLException e){
            e.getMessage();
        }
    }
}
    
    
