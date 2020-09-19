/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testrt;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Saidur Rahman Akash
 */
public class RegController implements Initializable {

    private Connection connection;
    private PreparedStatement preparedStatement;
    Parent root;
    Scene scene;
    Stage stage;
    @FXML
    private Button submit;
    @FXML
    private Label lpass;
    @FXML
    private Label luser;
    @FXML
    private Label lmail;
    @FXML
    private Label lphone;
    @FXML
    private Label lgender;
    @FXML
    private Label laddress;
    @FXML
    private TextField tfuser;
    @FXML
    private TextField tfmail;
    @FXML
    private TextField tfphone;
    @FXML
    private TextField tfaddress;
    @FXML
    private TextField tfgender;
    @FXML
    private PasswordField tfpass;
    @FXML
    private Button back;
    @FXML
    private AnchorPane anchor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    
     private boolean validatefields(){
        
       
        if(tfuser.getText().isEmpty() | tfmail.getText().isEmpty() | tfphone.getText().isEmpty()| tfaddress.getText().isEmpty()| tfgender.getText().isEmpty()| tfpass.getText().isEmpty() )
        {
        
      
            
            Alert alert = new Alert(Alert.AlertType.WARNING); 
            alert.setTitle("Empty Field");
            alert.setHeaderText(null);
            alert.setContentText("None of the Field Can't Be Empty");
            alert.showAndWait();
            return false;
        }
        
        else{
        return true;
        }
}
    @FXML
    private void submit(MouseEvent event) throws SQLException {

        
            if(validatefields())
            {
                  connection = DBConnection.getConnection();
            
            
            String sql ="select * from userreg where Username=?  ";
            
            preparedStatement =connection.prepareStatement(sql);
            preparedStatement.setString(1, tfuser.getText());
            
             
            
             ResultSet status = preparedStatement.executeQuery();
            
          
            if(status.next()){
                
          
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText("Results:");
            alert.setContentText("User Already exist!");

            alert.showAndWait();
                preparedStatement.close();
            }
            else{
          
                 String sq = "insert into userreg  (Username,Pass,Phone,Email,Address,Gender) values (?,?,?,?,?,?) ";

            preparedStatement = connection.prepareStatement(sq);

            preparedStatement.setString(1, tfuser.getText());
            preparedStatement.setString(2, tfpass.getText());
            preparedStatement.setString(3, tfphone.getText());
            preparedStatement.setString(4, tfmail.getText());
            preparedStatement.setString(5, tfaddress.getText());
            preparedStatement.setString(6, tfgender.getText());
            

            preparedStatement.execute();

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText("Results:");
            alert.setContentText("User Registration Has Succesfully Done!");

            alert.showAndWait();

            preparedStatement.close();

            tfuser.clear();
            tfmail.clear();
            tfphone.clear();
            tfaddress.clear();
            tfgender.clear();
            tfpass.clear();
               
            }
          }     
  }

    @FXML
    private void back(MouseEvent event) throws IOException {
        stage = (Stage) back.getScene().getWindow();

        root = FXMLLoader.load(getClass().getResource("home.fxml"));

        scene = new Scene(root);

        stage.setScene(scene);

        stage.show();
    }
        
 }

