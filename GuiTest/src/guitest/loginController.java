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
            GuiTest gt = new GuiTest();
            try 
            {
                gt.showCustomerScreen();
            } 
            catch (IOException ex) 
            {
                Logger.getLogger(loginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(userNameTextField.getText().equals("Admin"))
        {
            GuiTest gt = new GuiTest();
            try 
            {
                gt.showAdminScreen();
            }
            catch (IOException ex)
            {
                System.out.println(ex.getMessage());
            }
        }
    }
}


