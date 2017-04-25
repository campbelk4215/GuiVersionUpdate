/**
 * User Info Class Controller
 * executes User from add, delete, update 
 * Capstone Group 6 
 */
package guitest;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


public class User_InfoController implements Initializable
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
    private Button searchButton;
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
    private void searchUser (ActionEvent actionEvent) throws SQLException, ClassNotFoundException
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
    private void searchAllUsers (ActionEvent actionEvent) throws SQLException, ClassNotFoundException
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    { 
        userNameColumn.setCellValueFactory(cellData -> cellData.getValue().unameProperty());
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().fnameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lnameProperty());
        passwordColumn.setCellValueFactory(cellData -> cellData.getValue().pwordProperty());
        
    } 
    
    //populate a user
    @FXML
    private void populateUser (Access_User_Information access_user) throws ClassNotFoundException
    {
        //declares list for tableview
        ObservableList<Access_User_Information> userData = FXCollections.observableArrayList();
        //add tthe users to the list
        userData.add(access_user);
        //set items to the table
        outputTable.setItems(userData);     
    }
    
    //set employee information to text area
    @FXML
    private void setUserInfoToTextArea (Access_User_Information userData)
    {
        resultArea.setText("First Name: " + userData.getFName());
    }
     
    @FXML
    private void populateAndShowUser (Access_User_Information userData) throws ClassNotFoundException
    {
        if (userData != null)
        {
            populateUser(userData);
            setUserInfoToTextArea(userData);
        }
        else
        {
            resultArea.setText("This eployee does Not exist!\n");
        }
    }
       
    //displays users for tableview
    @FXML
    private void populateUsers (ObservableList<Access_User_Information> userData) throws ClassNotFoundException
    {
        //set items to the table
        outputTable.setItems(userData);
    }
   
    //insert a user to DB
    @FXML
    private void insertUser (ActionEvent actionEvent) throws SQLException, ClassNotFoundException
    {
        try
        {
            SQL_DAO.insertUser(firstNameTextField.getText(), 
                                        lastNameTextField.getText(),
                                            userNameTextField.getText(),
                                                passwordTextField.getText());
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
    private void deleteUser (ActionEvent actionEvent) throws SQLException, ClassNotFoundException
    {
        try
        {
            //Logs to file
            MyLogger.Instance().log("\nUser deleted: " + userNameTextField.getText());
            SQL_DAO.deleteUser(userNameTextField.getText());
            resultArea.setText("User deleted!\n");
        }
        catch (SQLException er)
        {
            //Logs to file
            MyLogger.Instance().log("\nWarning Error: Problem occured while deleting user: " 
                                    + userNameTextField.getText() + "\nError: " + er);
            resultArea.setText("Problem occured while deleting user");
            throw er;
        }
    }
    
    public void previousButtonListener()
    {
        GuiTest.goToPreviousScene();
    }
    public void nextButtonListener()
    {
        GuiTest.goToNextScene();
    }
}
