/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.*;
import beans.*;

/**
 *
 * @author Administrator
 */
public class UseDB {
    
    private static Connection connect;
    
    public UseDB() throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.jdbc.Driver");
        connect = DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12346922", "sql12346922" , "E3T8PQ26Yn");
        createBookTable();
        createUserTable();
        createAdminTable();
    }
    
    public static Connection getConnection()
    {
       return connect;
    }
    
    private boolean createBookTable(){
      
        try{
            Statement state = connect.createStatement();
        
            String query =  "CREATE TABLE IF NOT EXISTS Book(bookId VARCHAR(10) PRIMARY KEY NOT NULL,"
                + "bookName VARCHAR(50), category VARCHAR(20), author VARCHAR(50), "
                + "publisher VARCHAR(50), description VARCHAR(150), imagePath VARCHAR(100),"
                + "available VARCHAR(20))";
            
            state.executeUpdate(query);
        }
        catch(Exception e){
            System.out.println("create book table exception caught");
             return false;
        }        
       
        return true;

    }

    private boolean createUserTable() {
        
        try{
            Statement state = connect.createStatement();
            
            String query = "CREATE TABLE IF NOT EXISTS User(userName VARCHAR(20) PRIMARY KEY NOT NULL, password VARCHAR(15), email VARCHAR(50),"
                    + "firstName VARCHAR(50), lastName VARCHAR(50), imagePath VARCHAR(100), booksIssued VARCHAR(700))";
            
            state.executeUpdate(query);
        }
        catch(Exception e){
            System.out.println("create User Table exception caught");
            return false;
        }

        return true;
   
    }

    private boolean createAdminTable() {
        
        try{
            Statement state = connect.createStatement();
            
            String query = "CREATE TABLE IF NOT EXISTS Admin(userName VARCHAR(20) PRIMARY KEY NOT NULL, password VARCHAR(15), email VARCHAR(50),"
                    + "firstName VARCHAR(50), lastName VARCHAR(50), imagePath VARCHAR(100))";
            
            state.executeUpdate(query);
            
        }
        catch(Exception e){
            System.out.println("create admin table exception caught");
            return false;
        }
        return true;
    }
   
    public User getUser(String username, String password){
    
        
        return null;
    
    }
}


