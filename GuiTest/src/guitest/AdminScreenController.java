/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guitest;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author happelj0841
 */
public class AdminScreenController
{

    @FXML
    private AnchorPane adminPane;
    @FXML
    private Button inventoryButton;
    @FXML
    private Button placeOrderButton;
    @FXML
    private Button reserveEvent;
    @FXML
    private Label outputLabel;
    
    public void inventoryButtonListener()
    {
        outputLabel.setText("Inventory");
    }
    
    public void placeOrderButtonListener()
    {
        outputLabel.setText("Place Order");
    }
    
    public void reserveEventListener()
    {
        outputLabel.setText("Reserve Event");
    }
}
