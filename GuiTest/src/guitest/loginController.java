/**
 * Login Class Controller
 * Checks for user and password in DB
 * Capstone Group 6 
 */

package guitest;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class loginController implements Initializable
{
    @FXML
    private Button submitButton;

    @FXML
    private Button cancelButton;

    @FXML
    private TextField userNameTextField;

    @FXML
    private TextField passwordTextField;
    
   
    public void submitListener() throws SQLException, ClassNotFoundException
    {
        
        try 
        {
            //get users
            Access_User_Information userData = SQL_DAO.searchUser(userNameTextField.getText());
            //method to check for user access
            getUsers(userData);
        }
        catch (SQLException er)
        {
            System.out.print("Warning!!! \nError occurred searching SQL for user:\n"
                                + userNameTextField.getText() + "\nError Message:\n"+ er);
            throw er;
        }
    }
    public void cancelButtonListener()
    {
        GuiTest.getGuiTest().Close();
    }

    @Override
    public void initialize(URL location,
            ResourceBundle resources)
    {
        submitButton.setDefaultButton(true);
        cancelButton.setCancelButton(true);
    }
    
    private void getUsers(Access_User_Information access_user) throws ClassNotFoundException
    {
        boolean b = true;
        //checks if user is in Db and password matchs
        if (access_user != null)
        {
            if(access_user.getUName().equals(userNameTextField.getText()))
            {  
                if(access_user.getPWord().equals(passwordTextField.getText()))
                {
                     try
                    {
                        GuiTest.getGuiTest().showAdminScreen();
                        b = false;
                    }
                    catch(IOException e)
                    {
                        System.out.println(e.getMessage());
                    }
                }
            }
            else
            {
                try
                {
                    GuiTest.getGuiTest().showCustomerScreen();
                    b = false;
                }
                catch(IOException e)
                {
                    System.out.println(e.getMessage());
                }
            }
            userNameTextField.setText("");
            passwordTextField.setText("");
            if(b)
            {
                //Logs to file
                MyLogger.Instance().log("Invalid Username or password "  + userNameTextField.getText());
                System.out.println("Invalid Username or password");
            }
            else
            {
                System.out.print("Error occurred while getting user information");
            }
        }
    }
}


