package guitest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Singleton design pattern to create logging object
 * that acts as a static (single) instance through program
 */

public class MyLogger 
{
     private static MyLogger _instance; // copy of the object itself
        
    private MyLogger() 
    {
        // constructor is private, so only the class itself can call it   
    }
    
    public static MyLogger Instance() 
    {
        // does it exist? if not, make it.
        if (_instance == null) 
        {
            _instance = new MyLogger();
        }
        return _instance;
    }
    public void log(String text) 
    {
        //logging code
        String logtime = new SimpleDateFormat("hh-mm-ss").format(Calendar.getInstance().getTime());
        setLogFilename("\nLogging: \n"+ logtime + " \n" + text);
    }
    
    public void setLogFilename(String fn) 
    {
        
        try
        {
            String logtime = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
            File logFile = new File(logtime + ".txt");
            /*
            if you are unaware of where file is going 
            */
            System.out.println(logFile.getCanonicalPath());
            
            //checks for file, if not creates its 
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(logFile, true));
            fileWriter.write(fn + "\r\n");
            fileWriter.flush();
            fileWriter.close();
			
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
    }
}
