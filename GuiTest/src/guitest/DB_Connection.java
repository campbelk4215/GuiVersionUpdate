/**
 * DB Connection Class
 * sets conn/disc to the DB
 * Checks for user and password in DB
 * Capstone Group 6 
 */
package guitest;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DB_Connection
{
    /*  
    Connection String
    If the database uses userName and password add in these lines
    String userName = "";
    String userPassword = "";
    */        
    private static Connection conn = null;
    private static final String HOST = "jdbc:derby://localhost:1527/PaintballDBv1";
    
    //Opens Connection
    public static void DB_Connect() throws SQLException 
    {
        try 
        {   
            // Connection
            conn = DriverManager.getConnection(HOST); 
            System.out.println("Database Successfully Connnected!");
        }
        catch (SQLException er)
        {
            //Logs to file
            MyLogger.Instance().log("\nWarning Error: Connection Failed! \n" + er);
            System.out.println("Connection Failed! Check output console" + er);
            throw er;
        }
    }    
    
    //Close Connection
    public static void DB_Disconnect() throws SQLException
    {
        try
        {
            if (conn != null && !conn.isClosed())
            {
                conn.close();
            }
        }
        catch (Exception er)
            {
                //Logs to file
                MyLogger.Instance().log("\nWarning Error: Disconnection Failed! \n" + er);
                throw er;
            }
    }
    
    //Executes query operation
    public static ResultSet DB_ExecutionQuery(String qStmt) throws SQLException
    {
        //declare statement, resultset, and cachedresultset
        Statement stmt = null;
        ResultSet resultSet = null;
        CachedRowSetImpl crs = null;
        
        try
        {
            DB_Connect();
            System.out.println("Select Statement: " + qStmt + "\n");
            
            //creates statement
            stmt = conn.createStatement();
            
            //executes select query
            resultSet = stmt.executeQuery(qStmt);
            
            //cachedrowset imple
            crs = new CachedRowSetImpl();
            crs.populate(resultSet);
        }
        catch (SQLException er)
        {
            System.out.println("Problem occurred at executeQuery Operation: " + er);
            throw er;
        }
        finally
        {
            if (resultSet != null)
            {
                //close resultset
                resultSet.close();
            }
            if (stmt != null)
            {
                //clsoe statement
                stmt.close();
            }
            DB_Disconnect();
        }
        //return the cachedrowset
        return crs;
        
    }
    
    //Executes updated records
    public static void DB_ExecuteUpdate(String sqlStmt) throws SQLException
    {
        Statement stmt = null;
        try
        {
            //connect to db
            DB_Connect();
            //create statement
            stmt = conn.createStatement();
            //run executeUpdate operation with sql statemte
            stmt.executeUpdate(sqlStmt);
        }
        catch (SQLException er)
        {
            //Logs to file
            MyLogger.Instance().log("\nWarning Error Updating, Problem occurred"
                                    + " at excuteUpdate operation " + er);
            System.out.println("Problem occurred at excuteUpdate operation " + er);
            throw er;
        }
        finally 
        {
            if (stmt != null)
            {
                //closes statement
                stmt.close();
            }
            DB_Disconnect();
        }
    }
}
