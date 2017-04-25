/**
 * SQL DOA Class
 * All SQL queries for the DB
 * Capstone Group 6 
 */
package guitest;

import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author campbelk4215
 */
public class SQL_DAO
{
    
    //Select a user
    public static Access_User_Information searchUser (String uname) 
                                                            throws SQLException
    {
        //define the sql statement
        String selectStmt = "SELECT * FROM USER_INFO WHERE USER_NAME ='" + uname + "'\n";
        
        //executes select statmesnt
        try
        {
            //gets resultsef from DB_ExecuteionQuery methods
            ResultSet rsUser = DB_Connection.DB_ExecutionQuery(selectStmt);
            
            //sends resultset to method
            Access_User_Information access_user = getUserFromResultSet(rsUser);
            
            //returns user object
            return access_user;
        }
        catch (SQLException er)
        {
            System.out.println("While searching users with name " + uname);
            throw er;
        }
    }

        //resultset from DB
    public static Access_User_Information getUserFromResultSet(ResultSet rs) 
                                                            throws SQLException
    {
        Access_User_Information aui = null;
        if (rs.next())
        {
            aui = new Access_User_Information();
            aui.setFName(rs.getString("FIRST_NAME"));
            aui.setLName(rs.getString("LAST_NAME"));
            aui.setPWord(rs.getString("PASSWORD"));
            aui.setUName(rs.getString("USER_NAME"));
        }
        return aui;
    }
    
    //Select all users
    public static ObservableList<Access_User_Information> searchUsers() 
                                                            throws SQLException
    {
        //declaring select statment
        String selectStmt = "SELECT * FROM USER_INFO";
        
        //Executes select statemt
        try
        {
            //get resultset
            ResultSet rsUser = DB_Connection.DB_ExecutionQuery(selectStmt);
            
            //sends results
            ObservableList<Access_User_Information> userList = getUserList(rsUser);
            
            return userList;
        }
        catch (SQLException er)
        {
            System.out.println("SQL select operation ahs FAILED: " + er);
            throw er;
        }
    }
    
    //select * operation
    private static ObservableList<Access_User_Information> getUserList(ResultSet rs)
                                                            throws SQLException
    {
        ObservableList<Access_User_Information> userList = FXCollections.observableArrayList();
        
        while (rs.next())
        {
            Access_User_Information aui = new Access_User_Information();
            aui.setFName(rs.getString("FIRST_NAME"));
            aui.setLName(rs.getString("LAST_NAME"));
            aui.setPWord(rs.getString("PASSWORD"));
            aui.setUName(rs.getString("USER_NAME"));
            
            //add users to observablelist
            userList.add(aui);
        }
        return userList;
    }
    
    //delete user
    public static void deleteUser (String uname) throws SQLException
    {
        //delete statement
        String updateStmt = 
                        "   DELETE FROM USER_INFO\n" +
                        "   WHERE USER_NAME ='" + uname + "'\n";
        //Execute UPDATE operation
        try
        {
            DB_Connection.DB_ExecuteUpdate(updateStmt);
        }
        catch (SQLException er)
        {
            //Logs to file
            MyLogger.Instance().log("\nError occurred while DELETE Operation \n" + er);
            System.out.print("Error occurred while DELETE Operation" + er);
            throw er;
        }
    }
    
    //insert user
    public static void insertUser (String name, String lname, String uname, String password)
                                                                throws SQLException
    {
        //insert statement
        String updateStmt =
                        "INSERT INTO USER_INFO\n" +
                        "(USER_NAME, FIRST_NAME, LAST_NAME, PASSWORD)\n" +
                        "VALUES\n" +
                        "('"+ uname + "', '" + name + "', '" + lname + "', '"+ password +"')\n";
        try 
        {
            //Logs to file
            MyLogger.Instance().log("\nInsert Operation \nUser \n" + uname + " added.");
            DB_Connection.DB_ExecuteUpdate(updateStmt);
        }
        catch (SQLException er)
        {
            System.out.print("Error occured while Insert Operation: "+ er);
            throw er;
        }
    }
}
