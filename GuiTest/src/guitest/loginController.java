/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guitest;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
/**
 *
 * @author happelj0841
 */
public class loginController
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
        if(userNameTextField.getText().equals("Customer"))
        {
            try 
            {
                ScreenChanger.getGuiTest().showCustomerScreen();
            }
            catch (IOException ex)
            {
                System.out.println(ex.getMessage());
            }
        }
        if(userNameTextField.getText().equals("Admin"))
        {
            try 
            {
                ScreenChanger.getGuiTest().showAdminScreen();
            }
            catch (IOException ex)
            {
                System.out.println(ex.getMessage());
            }
        }
    }
}


