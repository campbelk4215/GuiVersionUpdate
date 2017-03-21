/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guitest;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

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
        String timeString = "";
        for(MenuItem m : menuButton.getItems())
        {
            if(e.getSource().equals(m))
            {
                menuButton.setText(m.getText());
                timeString = m.getText();
            }
        }
        Event event = new Event();
        event.setTime(timeString);
        System.out.println(event.getTime());
    }
    
    public void eventDatePickerListener()
    {
        eventDatePicker.getValue();
        System.out.println(eventDatePicker.getValue().toString());
        System.out.println(eventDatePicker.getChronology().toString());
    }
    public void reserveEventListener()
    {
        if(ld.compareTo(eventDatePicker.getValue()) > 0)
        {
            System.out.print("Invalid Date please a time not in the past");
        }
    }
}
