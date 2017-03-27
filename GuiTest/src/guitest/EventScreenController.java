/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guitest;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author happe
 */
public class EventScreenController implements Initializable {

    @FXML
    private DatePicker eventDatePicker;
    @FXML
    private MenuButton menuButton;
    @FXML
    private MenuItem menuItem;
    @FXML
    private Button reserveEventButton;
    @FXML
    private Button backButton;
    @FXML
    private TableView tableView;
    @FXML
    private TextField numberOfGuestsTextField;
    @FXML
    private Label dateLabel;
    @FXML
    private Label timeLabel;
    @FXML
    private Label guestsLabel;    
    @FXML
    private TableColumn dateColumn;
    @FXML
    private TableColumn timeColumn;
    @FXML
    private TableColumn guestsColumn;
    private LocalDate ld = java.time.LocalDate.now();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        eventDatePicker.getChronology().dateNow();
    }    
    
    public void menuButtonListener(ActionEvent e)
    {
        for(MenuItem m : menuButton.getItems())//enhanced for loop behaves a c# foreach loop
        {
            if(e.getSource().equals(m))//compares the source of the event to the current menuitem
            {
                menuButton.setText(m.getText());//changes the text of the menuButton
            }
        }
    }
    
    public void eventDatePickerListener()
    {
        
    }
    public void reserveEventListener()
    {
        /**
         * this compares the selected date to the current date
         * the compareTo method compares two chronology objects and returns an int
         * if the returned int is positive that means the object being sent as an
         * arguement eventDatePicker.getValue() is earlier in time than the object
         * calling the compareTo method
         * This if statement makes sure the user has picked a time on the current 
         * date or sometime in the future
         */
        try
        {
            String str = numberOfGuestsTextField.getText();
            int guests = Integer.parseInt(str);
            if(guests > 30)
            {
                System.out.println("Too many guests");
            }
            if(ld.compareTo(eventDatePicker.getValue()) > 0)
            {
                System.out.println("Invalid Date please pick a time not in the past");
            }
            //this makes sure the user has picked a time slot
            if(menuButton.getText().equals("Pick Time"))
            {
                System.out.println("Please Pick a time slot");
            }
            //if the user has correctly picked a time then an event object is created
            else
            {
                
                Event e = new Event(eventDatePicker.getValue().toString(), menuButton.getText(), guests);
                System.out.println(e.getDate());
                System.out.println(e.getTime());
                System.out.println(guests);
                dateLabel.setText(e.getDate() +"\n");
                timeLabel.setText(e.getTime()+"\n");
                guestsLabel.setText("" + e.getGuests()+"\n");
                Event ee = new Event(eventDatePicker.getValue().toString(), menuButton.getText(), guests);
                System.out.println(ee.getDate());
                System.out.println(ee.getTime());
                System.out.println(guests);
                dateLabel.setText(dateLabel.getText() + ee.getDate() +"\n");
                timeLabel.setText(timeLabel.getText() + ee.getTime()+"\n");
                guestsLabel.setText(guestsLabel.getText() + "" + ee.getGuests()+"\n");
            }
        }
        catch(Exception e)
        {
            System.out.println("Invalid number of guests");
        }
    }
    public void backButtonListener()
    {
        GuiTest.goToPreviousScene();
    }
}
