/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guitest;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Joshua Happel <happelj0841@student.faytechcc.edu>
 */
public class ItemListScreenController implements Initializable {
    private int itemIndex = 0;
    private List<Item> items = new ArrayList<Item>();
    
    
    
    @FXML
    private GridPane itemGridPane;
    @FXML
    private GridPane itemDetailGridPane;
    @FXML
    private Pane itemPricePane;
    @FXML
    private Label itemPriceLabel00;
    @FXML
    private Pane itemNamePane;
    @FXML
    private Label itemNameLabel00;
    @FXML
    private Pane itemQuantityPane;
    @FXML
    private TextField quantityTextField00;
    @FXML
    private Pane addToCartPane;
    @FXML
    private Button addToCartButton00;
    @FXML
    private ImageView itemPictureImageView00;
    @FXML
    private GridPane itemGridPane1;
    @FXML
    private GridPane itemDetailGridPane1;
    @FXML
    private Pane itemPricePane1;
    @FXML
    private Label itemPriceLabel01;
    @FXML
    private Pane itemNamePane1;
    @FXML
    private Label itemNameLabel01;
    @FXML
    private Pane itemQuantityPane1;
    @FXML
    private TextField quantityTextField01;
    @FXML
    private Pane addToCartPane1;
    @FXML
    private Button addToCartButton01;
    @FXML
    private ImageView itemPictureImageView01;
    @FXML
    private GridPane itemGridPane2;
    @FXML
    private GridPane itemDetailGridPane2;
    @FXML
    private Pane itemPricePane2;
    @FXML
    private Label itemPriceLabel02;
    @FXML
    private Pane itemNamePane2;
    @FXML
    private Label itemNameLabel02;
    @FXML
    private Pane itemQuantityPane2;
    @FXML
    private TextField quantityTextField02;
    @FXML
    private Pane addToCartPane2;
    @FXML
    private Button addToCartButton02;
    @FXML
    private ImageView itemPictureImageView02;
    @FXML
    private GridPane itemGridPane3;
    @FXML
    private GridPane itemDetailGridPane3;
    @FXML
    private Pane itemPricePane3;
    @FXML
    private Label itemPriceLabel03;
    @FXML
    private Pane itemNamePane3;
    @FXML
    private Label itemNameLabel03;
    @FXML
    private Pane itemQuantityPane3;
    @FXML
    private TextField quantityTextField03;
    @FXML
    private Pane addToCartPane3;
    @FXML
    private Button addToCartButton03;
    @FXML
    private ImageView itemPictureImageView03;
    @FXML
    private GridPane itemGridPane4;
    @FXML
    private GridPane itemDetailGridPane4;
    @FXML
    private Pane itemPricePane4;
    @FXML
    private Label itemPriceLabel10;
    @FXML
    private Pane itemNamePane4;
    @FXML
    private Label itemNameLabel10;
    @FXML
    private Pane itemQuantityPane4;
    @FXML
    private TextField quantityTextField10;
    @FXML
    private Pane addToCartPane4;
    @FXML
    private Button addToCartButton10;
    @FXML
    private ImageView itemPictureImageView10;
    @FXML
    private GridPane itemGridPane5;
    @FXML
    private GridPane itemDetailGridPane5;
    @FXML
    private Pane itemPricePane5;
    @FXML
    private Label itemPriceLabel11;
    @FXML
    private Pane itemNamePane5;
    @FXML
    private Label itemNameLabel11;
    @FXML
    private Pane itemQuantityPane5;
    @FXML
    private TextField quantityTextField11;
    @FXML
    private Pane addToCartPane5;
    @FXML
    private Button addToCartButton11;
    @FXML
    private ImageView itemPictureImageView11;
    @FXML
    private GridPane itemGridPane6;
    @FXML
    private GridPane itemDetailGridPane6;
    @FXML
    private Pane itemPricePane6;
    @FXML
    private Label itemPriceLabel12;
    @FXML
    private Pane itemNamePane6;
    @FXML
    private Label itemNameLabel12;
    @FXML
    private Pane itemQuantityPane6;
    @FXML
    private TextField quantityTextField12;
    @FXML
    private Pane addToCartPane6;
    @FXML
    private Button addToCartButton12;
    @FXML
    private ImageView itemPictureImageView12;
    @FXML
    private GridPane itemGridPane7;
    @FXML
    private GridPane itemDetailGridPane7;
    @FXML
    private Pane itemPricePane7;
    @FXML
    private Label itemPriceLabel13;
    @FXML
    private Pane itemNamePane7;
    @FXML
    private Label itemNameLabel13;
    @FXML
    private Pane itemQuantityPane7;
    @FXML
    private TextField quantityTextField13;
    @FXML
    private Pane addToCartPane7;
    @FXML
    private Button addToCartButton13;
    @FXML
    private ImageView itemPictureImageView13;
    @FXML
    private Button removeButton;
    @FXML
    private Button checkoutButton;
    //fxml variables 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setEightItems(GuiTest.sendEightItems(itemIndex));
    }    
    public void setEightItems(List<Item> eightItems)
    {
        items = eightItems;
        for (int i = 0; i < 8; i++)
        {
            if(items.get(i) == null)
            {
                break;
            }
            else
            {
                populateItems(i, items.get(i));
                itemIndex++;
            }
        }
    }
    public void populateItems(int i, Item item)
    {
        String name = item.getItemName();
        String price = item.getPrice() + "";
        
        Image im = new Image(item.getImagePath());
        switch(i) 
        {
            case 0:
                itemPictureImageView00.setImage(im);
                itemNameLabel00.setText(name);
                itemPriceLabel00.setText(price);
                item.setMyButton(addToCartButton00);
                break;
            case 1:
                itemPictureImageView10.setImage(im);
                itemNameLabel10.setText(name);
                itemPriceLabel10.setText(price);
                item.setMyButton(addToCartButton10);
                break;
            case 2:
                itemPictureImageView01.setImage(im);
                itemNameLabel01.setText(name);
                itemPriceLabel01.setText(price);
                item.setMyButton(addToCartButton01);
                break;
            case 3:
                itemPictureImageView11.setImage(im);
                itemNameLabel11.setText(name);
                itemPriceLabel11.setText(price);
                item.setMyButton(addToCartButton11);
                break;
            case 4:
                itemPictureImageView02.setImage(im);
                itemNameLabel02.setText(name);
                itemPriceLabel02.setText(price);
                item.setMyButton(addToCartButton02);
                break;
            case 5:
                itemPictureImageView12.setImage(im);
                itemNameLabel12.setText(name);
                itemPriceLabel12.setText(price);
                item.setMyButton(addToCartButton12);
                break;
            case 6:
                itemPictureImageView03.setImage(im);
                itemNameLabel03.setText(name);
                itemPriceLabel03.setText(price);
                item.setMyButton(addToCartButton03);
                break;
            case 7:
                itemPictureImageView13.setImage(im);
                itemNameLabel13.setText(name);
                itemPriceLabel13.setText(price);
                item.setMyButton(addToCartButton13);
                break;
        }
    }
}
