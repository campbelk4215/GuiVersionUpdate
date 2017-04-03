/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guitest;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;

/**
 * FXML Controller class
 *
 * @author Joshua Happel <happelj0841@student.faytechcc.edu>
 */
public class ItemListScreenController implements Initializable {

    @FXML
    private GridPane itemGridPane;
    @FXML
    private Image im;
    @FXML
    private ImageView imageViewer;
    @FXML
    private GridPane singleItemGridPane;
    @FXML
    private GridPane itemDetailGridPane;
    @FXML
    private Label itemName;
    @FXML
    private Label priceLabel;
    @FXML
    private Button addToCartButton;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        
        
        int x = 0, y = 0, index = 0;
        for(Item i : GuiTest.getItemList())
        {
            populateItemDetail(i, x, y);
            x++;
            populateItemDetail(i, x, y);
            if(y == 2)
            {
                break;
            }
            else
            {
                y++;
            }
            x = 0;
            index++;
        }
    }    
    public void populateItemDetail(Item i, int x, int y)
    {
        
        im = new Image(i.getImagePath(),150,150,true,false);
        imageViewer = new ImageView(im);
        singleItemGridPane = new GridPane();
        singleItemGridPane.add(imageViewer, 0, 0);
        itemName = new Label();
        itemName.setText(i.getItemName());
        priceLabel = new Label();
        priceLabel.setText("$" + i.getPrice());
        addToCartButton = new Button();
        addToCartButton.setOnAction(new AddToCartListener());
        addToCartButton.setText("Add to Cart");
        itemDetailGridPane = new GridPane();
        itemDetailGridPane.add(itemName, 0, 0);
        itemDetailGridPane.add(priceLabel, 0, 1);
        itemDetailGridPane.add(addToCartButton, 0, 2);
        singleItemGridPane.add(itemDetailGridPane, 1, 0);
        itemGridPane.add(singleItemGridPane, x, y);
    }
    private class AddToCartListener implements EventHandler
    {
        @Override
        public void handle(Event event) {
            System.out.println("added");
        }
    }
    
}
