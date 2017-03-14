/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guitest;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Joshua Happel
 */
public class GuiTest
        extends Application
{
    static Stage currentStage;
    Scene currentScene;
    @Override
    public void start(Stage primaryStage) throws IOException
    {
        ScreenChanger.setGuiTest(this);//needed to easily change screens
        currentStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Login");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }
    //if you are going to load an fxml the method needs to throw an IOException
    //
    public void showCustomerScreen() throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("CustomerScreen.fxml"));
        Scene scene = new Scene(root);//creates a scene using the fxml
        Stage customerStage = new Stage();//creates a stage to hold the scene
        currentStage.close();//gets rid of the old screen
        currentStage = customerStage;//sets the current screen to the currentstage field to easily be closed
        customerStage.setTitle("Customer Screen");//sets the screen title
        customerStage.setScene(scene);//adds the scene to the stage
        customerStage.show();//makes the stage visible
    }
    public void showAdminScreen() throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("AdminScreen.fxml"));
        Scene scene = new Scene(root);
        Stage adminStage = new Stage();
        currentStage.close();
        currentStage = adminStage;
        adminStage.setTitle("Admin Screen");
        adminStage.setScene(scene);
        adminStage.show();
    }
    public void showEventScreen() throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("EventScreen.fxml"));
        Scene scene = new Scene(root);
        Stage eventStage = new Stage();
        currentStage.close();
        currentStage = eventStage;
        eventStage.setTitle("Admin Screen");
        eventStage.setScene(scene);
        eventStage.show();
    }
}
