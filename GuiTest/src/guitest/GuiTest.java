/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guitest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
    private static List<Scene> scenes = new ArrayList<Scene>();//
    private static GuiTest gt;
    static Stage currentStage;
    @Override
    public void start(Stage primaryStage) throws IOException
    {
        
        gt = this;
        ScreenChanger.setGuiTest(this);//needed to easily change screens
        currentStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));
        Scene scene = new Scene(root);
        scenes.add(scene);
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
        currentStage.setTitle("Customer Screen");//sets the screen title
        currentStage.setScene(scene);//adds the scene to the stage
        scenes.add(scene);
        
    }
    public void showAdminScreen() throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("AdminScreen.fxml"));
        Scene scene = new Scene(root);
        currentStage.setScene(scene);
        currentStage.setTitle("Admin Screen");
        scenes.add(scene);
    }
    public void showCustomerEventScreen() throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("EventScreen.fxml"));
        Scene scene = new Scene(root);
        currentStage.setTitle("Event Screen");
        currentStage.setScene(scene);
        scenes.add(scene);
        
    }
    public static GuiTest getGuiTest()//use this to access show screen methods
    {
        return gt;
    }
    public static List<Scene> getSceneList()
    {
        return scenes;
    }
    public static void goToPreviousScene()
    {
        Scene s;//placeholder scene variable
        s = scenes.get(scenes.lastIndexOf(currentStage.getScene()) - 1);//fills placeholder with previous scene
        scenes.remove(currentStage.getScene());//removes the current scene
        currentStage.setScene(s);// shows previous scene
        
    }
}
