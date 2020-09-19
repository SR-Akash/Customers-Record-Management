
package testrt;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author Saidur Rahman Akash
 */
public class AdmintController implements Initializable {
    
    private Label label;
    private Connection connection;
    private PreparedStatement preparedStatement;
    Parent root;
    Scene scene;
    Stage stage;
    @FXML
    private TextField UserName;
    @FXML
    private PasswordField PassWord;
    @FXML
    private Button Login;
    @FXML
    private Label error;
    @FXML
    private Button back;
    @FXML
    private Button Clear;
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    private void exit(MouseEvent event) {
        
        System.exit(0);
    }

    @FXML
    private void Login(MouseEvent event) throws IOException {
        
           try {
            connection=DBConnection.getConnection();
            
           
            String sql ="select * from login where Username=? and Pass= ? ";
            
            preparedStatement =connection.prepareStatement(sql);
            preparedStatement.setString(1, UserName.getText());
            preparedStatement.setString(2, PassWord.getText());
             
            
             ResultSet status = preparedStatement.executeQuery();
            
          
            if(status.next()){
                
           stage = (Stage)Login.getScene().getWindow();
                
        root = FXMLLoader.load(getClass().getResource("adminservices.fxml"));

         scene = new Scene(root);
        
         stage.setScene(scene);
        
     
        stage.show();
                
                
            }
            else{
          
                error.setText("Invalid username or password");
               
            }
            
            preparedStatement.close();
            
            status.close();
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
    }
    

    @FXML
    private void back(MouseEvent event) throws IOException {
         stage = (Stage)Login.getScene().getWindow();
                
        root = FXMLLoader.load(getClass().getResource("home.fxml"));

         scene = new Scene(root);
        
         stage.setScene(scene);
        
     
        stage.show();
    }

    @FXML
    private void Clear(MouseEvent event) {
        
        UserName.setText(null);
        PassWord.setText(null);
    }
    
}
