/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guitest;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
/**
 *
 * @author happelj0841
 */
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
    
    public void submitListener()
    {
        boolean b = true;
        for(User u : GuiTest.getUserList())
        {
            if(u.getUsername().equals(userNameTextField.getText()))
            {
                if(u.getPassword().equals(passwordTextField.getText()))
                {
                    if(u.getIsAdmin())
                    {
                        try
                        {
                            GuiTest.getGuiTest().showAdminScreen();
                            b = false;
                            GuiTest.setCurrentUser(u);
                            break;
                        }
                        catch(IOException e)
                        {
                            System.out.println(e.getMessage());
                        }
                    }
                    else
                    {
                        try
                        {
                            GuiTest.getGuiTest().showCustomerScreen();
                            b = false;
                            GuiTest.setCurrentUser(u);
                            break;
                        }
                        catch(IOException e)
                        {
                            System.out.println(e.getMessage());
                        }
                    }
                }
            }
        }
        userNameTextField.setText("");
        passwordTextField.setText("");
        if(b)
        {
            System.out.println("Invalid Username or password");
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
}


