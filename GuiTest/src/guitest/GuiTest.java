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
 * @author happelj0841
 */
public class GuiTest
        extends Application
{
    static Stage currentStage;
    Scene currentScene;
    @Override
    public void start(Stage primaryStage) throws IOException
    {
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
    public void showCustomerScreen() throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("CustomerScreen.fxml"));
        Scene scene = new Scene(root);
        Stage customerStage = new Stage();
        currentStage.close();
        currentStage = customerStage;
        customerStage.setTitle("Customer Screen");
        customerStage.setScene(scene);
        customerStage.show();
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
}
