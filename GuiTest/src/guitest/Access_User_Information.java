package guitest;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author campbelk4215
 */
public class Access_User_Information
{
   
   private StringProperty fname;
   private StringProperty lname;
   private StringProperty uname;
   private StringProperty pword;
    
    public Access_User_Information()
    {
        this.fname = new SimpleStringProperty();
        this.lname = new SimpleStringProperty();
        this.pword = new SimpleStringProperty();
        this.uname = new SimpleStringProperty();
    }
    
    //First Name
    public String getFName()
    {
        return fname.get();
    }
    public void setFName(String f_name)
    {
        this.fname.set(f_name);
    }
    public StringProperty fnameProperty()
    {
        return fname;
    }
    
    //Last Name
    public String getLName()
    {
        return lname.get();
    }
    public void setLName(String l_name)
    {
        this.lname.set(l_name);
    }
    public StringProperty lnameProperty()
    {
        return lname;
    }
    
    //Password
    public String getPWord()
    {
        return pword.get();
    }
    public void setPWord(String p_word)
    {
        this.pword.set(p_word);
    }
    public StringProperty pwordProperty()
    {
        return pword;
    }
    
    //Username
    public String getUName()
    {
        return uname.get();
    }
    public void setUName(String u_name)
    {
        this.uname.set(u_name);
    }
    public StringProperty unameProperty()
    {
        return uname;
    }
    
}


