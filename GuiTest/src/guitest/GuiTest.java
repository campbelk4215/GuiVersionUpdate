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
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    private static User currentUser;
    private static List<User> users = new ArrayList<User>();
    private static List<Item> items = new ArrayList<Item>();
    static Stage currentStage;
    @Override
    public void start(Stage primaryStage) throws IOException
    {
        User u0 = new User("Josh", "12345", 1, false);
        User u1 = new User("IUYT", "12345", 2, false);
        User u2 = new User("bill", "12345", 3, false);
        User u3 = new User("qwer", "12345", 4, false);
        User u4 = new User("JUYT", "12345", 5, true);
        items.add(new Item(1, "goat", 100, "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/Hausziege_04.jpg/220px-Hausziege_04.jpg"));
        items.add(new Item(2, "other goat", 10, "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/Hausziege_04.jpg/220px-Hausziege_04.jpg\""));
        items.add(new Item(1, "goat", 110, "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/Hausziege_04.jpg/220px-Hausziege_04.jpg"));
        items.add(new Item(2, "other goat", 150, "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/Hausziege_04.jpg/220px-Hausziege_04.jpg\""));
        items.add(new Item(1, "goat", 10021, "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/Hausziege_04.jpg/220px-Hausziege_04.jpg"));
        items.add(new Item(2, "other goat", 1150, "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/Hausziege_04.jpg/220px-Hausziege_04.jpg\""));
        items.add(new Item(1, "goat", 1056840, "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/Hausziege_04.jpg/220px-Hausziege_04.jpg"));
        items.add(new Item(2, "other goat", 1560, "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/Hausziege_04.jpg/220px-Hausziege_04.jpg\""));
        users.add(u0);
        users.add(u1);
        users.add(u2);
        users.add(u3);
        users.add(u4);
        gt = this;
        System.out.println("Working Directory = " +
              System.getProperty("user.dir"));
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
    
    //displays the userInfo Screen
    public void showUserInfoScreen() throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("user_Info_Form.fxml"));
        Scene scene = new Scene(root);
        currentStage.setTitle("User Information");
        currentStage.setScene(scene);
        scenes.add(scene);
    }
    
    public void showItemListScreen() throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("ItemListScreen.fxml"));
        Scene scene = new Scene(root);
        currentStage.setTitle("Items Screen");
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
        currentStage.setScene(s);// shows previous scene
    }
    public static void goToNextScene()
    {
        Scene s;//placeholder scene variable
        s = scenes.get(scenes.lastIndexOf(currentStage.getScene()) + 1);//fills placeholder with next scene
        currentStage.setScene(s);// shows previous scene
    }
    public static List<User> getUserList()
    {
        return users;
    }
    public static List<Item> getItemList()
    {
        return items;
    }
    public static User getCurrentUser()
    {
        return currentUser;
    }
    public static void setCurrentUser(User u)
    {
        currentUser = u;
    }
    public void Close()
    {
        currentStage.close();
    }
    public static List<Item> sendEightItems(int startingIndex)
    {
        List<Item> returnList = new ArrayList<Item>();
        for(int i = 0; i < 8; i++)
        {
            returnList.add(items.get(startingIndex + i));
        }
        return returnList;
    }
}
