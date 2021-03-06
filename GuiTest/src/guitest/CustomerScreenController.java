/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guitest;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author happe
 */
public class CustomerScreenController implements Initializable {

    @FXML
    private Button buyInventoryButton;
    @FXML
    private Button reserveEventButton;
    @FXML
    private AnchorPane customerPane;
    @FXML
    private Button backButton;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void buyInventoryButton()
    {
            try 
            {
                GuiTest.getGuiTest().showItemListScreen();
            }
            catch (IOException ex)
            {
                System.out.println(ex.getMessage());
            }
    }
    public void reserveEventButton()
    {
        
            try 
            {
                GuiTest.getGuiTest().showCustomerEventScreen();
            }
            catch (IOException ex)
            {
                System.out.println(ex.getMessage());
            }
    }
    public void backButtonListener()
    {
        GuiTest.goToPreviousScene();
    }
    public void nextButtonListener()
    {
        GuiTest.goToNextScene();
    }
}
