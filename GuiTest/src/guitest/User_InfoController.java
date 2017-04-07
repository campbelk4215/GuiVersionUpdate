package guitest;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author campbelk4215
 */
public class User_InfoController
{

    @FXML
    private AnchorPane AnchorPane;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Button nextButton;
    @FXML
    private Button previousButton;
    @FXML
    private Button updateButton;
    @FXML
    private Button deleteButton;
    @FXML
    private Button newRecordButton;
    @FXML
    private TextField firstNameTextField;
    @FXML
    private TextField lastNameTextField;
    @FXML
    private TextField userNameTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private TextArea resultArea;
    @FXML
    private TableView outputTable;
    @FXML
    private TableColumn<Access_User_Information, String> userNameColumn;
    @FXML
    private TableColumn<Access_User_Information, String> firstNameColumn;
    @FXML 
    private TableColumn<Access_User_Information, String> lastNameColumn;
    @FXML
    private TableColumn<Access_User_Information, String> passwordColumn;
    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label userNameLabel;
    @FXML
    private Label passwordLabel;
    
    //search user
    @FXML
    private void searchUser (ActionEvent actionEvent) throws SQLException
    {
        try
        {
            //get user info
            Access_User_Information access_user = SQL_DAO.searchUser(userNameTextField.getText());
            
            populateAndShowUser(access_user);
        }
        catch (SQLException er)
        {
            System.out.print("Error occurred while getting user info from DB " + er);
            throw er;
        }
    }
    
    //search all users
    @FXML
    private void searchAllUsers (ActionEvent actionEvent) throws SQLException
    {
        try
        {
            //get all users
            ObservableList<Access_User_Information> userData = SQL_DAO.searchUsers();
            
            populateUsers(userData);
        }
        catch (SQLException er)
        {
            System.out.print("Error occurred while getting employees information" + er);
            throw er;
        }
    }
    
    //insert a user to DB
    @FXML
    private void insertUser (ActionEvent actionEvent) throws SQLException
    {
        try
        {
            SQL_DAO.insertUser(firstNameTextField.getText(), 
                                        lastNameTextField.getText(),
                                            userNameTextField.getText());
            resultArea.setText("User Added!\n");
        }
        catch (SQLException er)
        {
            resultArea.setText("Problem occurred while adding new user: " + er);
            throw er;
        }
    }

    //delete a user from DB
    @FXML
    private void deleteUser (ActionEvent actionEvent) throws SQLException
    {
        try
        {
            SQL_DAO.deleteUser(userNameTextField.getText());
            resultArea.setText("User deleted!\n");
        }
        catch (SQLException er)
        {
            resultArea.setText("Problem occured while deleting user");
            throw er;
        }
    }
    /**
     * Initializes the controller class.
     */
    public void initialize(URL url, ResourceBundle rb) 
    {
        
    } 

    public void previousButtonListener()
    {
        GuiTest.goToPreviousScene();
    }
        public void nextButtonListener()
        {
            GuiTest.goToNextScene();
        }
    
    //populate users
    @FXML
    private void populateUser (Access_User_Information user)
    {
        //declares list for tableview
        ObservableList<Access_User_Information> userData = FXCollections.observableArrayList();
        //add tthe users to the list
        userData.add(user);
        //set items to the table
        
        
    }
    
}

